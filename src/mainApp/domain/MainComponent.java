package mainApp.domain;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*
 * Class: MainComponent
 * @author A307
 * Purpose: Stores GameObjects, loads levels, handles collisions.
 */
public class MainComponent extends JComponent {
	private Hero hero;
	private BufferedImage img;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Coin> coins;
	private ArrayList<Barrier> barriers;
	private ArrayList<PowerUp> powerUps;
	private int score;
	private int lives;
	private int level;
	public static final int FINAL_LEVEL = 4;
	public static final int STARTING_LIVES = 3;
	public MainComponent()
	{
		obstacles = new ArrayList<>();
		coins = new ArrayList<>();
		barriers = new ArrayList<>();
		powerUps = new ArrayList<>();
		hero = new Hero();
		lives = STARTING_LIVES;
		score = 0;
		level = 1;
		levelLoader("Level1");
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					hero.setBoosting(true);
				}
				else if(e.getKeyCode() == KeyEvent.VK_U)
				{
					level++;
					System.out.println("Loading level "+level);
					hero.resetPosition();
					levelLoader("Level"+level);
				}
				else if(e.getKeyCode() == KeyEvent.VK_D)
				{
					level--;
					System.out.println("Loading level "+level);
					hero.resetPosition();
					levelLoader("Level"+level);
				}

			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					hero.setBoosting(false);
				}
			}
			@Override
			public void keyTyped(KeyEvent e)
			{
				
			}
		});
		this.setFocusable(true);
	} 
	public int getScore()
	{
		return score;
	}
	public int getLives()
	{
		return lives;
	}
	public void tick()
	{
		hero.update();
		
		boolean toRestart = false;
		for(Obstacle obstacle : obstacles)
		{
			obstacle.update();
			if(obstacle.overlapsWith(hero))
			{
				if(!hero.isImmune())
				{
					lives--;
					hero.resetPosition();
					score = 0;
					toRestart = true;
					System.out.println("You died to "+obstacle);
				}
				
			}			
		}
		if(toRestart)
			levelLoader("Level"+level);
		ArrayList<GameObject> coinsToRemove = new ArrayList<GameObject>();
		for(Coin coin : coins)
		{
			coin.update();
			if(coin.overlapsWith(hero))
			{
				score++;
				coinsToRemove.add(coin);
			}			
		}
		for(GameObject object : coinsToRemove)
		{
			coins.remove(object);
		}
		ArrayList<GameObject> powersToRemove = new ArrayList<GameObject>();
		for(PowerUp power : powerUps)
		{
			power.update();
			if(power.overlapsWith(hero))
			{
				hero.setShielded(true);
				powersToRemove.add(power);
			}
		}
		for(GameObject object : powersToRemove)
		{
			powerUps.remove(object);
		}
		boolean blocked = false;
		for(Barrier barrier : barriers)
		{
			barrier.update();
			if(barrier.overlapsWith(hero))
			{
				blocked = true;
			}			
		}
		if(blocked)
		{
			hero.setVelX(0);
			//hero.setX(hero.getX()-Hero.BARRY_WIDTH);
		}
		else
		{
			hero.setVelX(Hero.RUNNING_SPEED);
			hero.setYBlocked(false);
		}
		if(hero.isFinished())
		{
			level++;
			levelLoader("Level"+level);
			hero.resetPosition();
		}
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img, 0, 0, 800, 400, null);
		hero.drawOn(g2);
		for(GameObject object : coins)
		{
			object.drawOn(g2);
		}
		for(GameObject object : barriers)
		{
			object.drawOn(g2);
		}
		for(GameObject object : obstacles)
		{
			object.drawOn(g2);
		}
		for(GameObject object : powerUps)
		{
			object.drawOn(g2);
		}
	}
	public void levelLoader(String filename)
	{
		if(filename.equals("Level0") || filename.equals("level"+FINAL_LEVEL)) //for testing
		{
			lives = 0;
			return;
		}
		obstacles.clear();
		barriers.clear();
		coins.clear();
		powerUps.clear();
		//if(filename.equals("Level"+FINAL_LEVEL))
			//TODO:popup
		try {
			img = ImageIO.read(new File("images/background-"+filename.toLowerCase()+".jpg"));
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Image not found for level");
		}

		try {
			FileReader file = new FileReader(filename);
			Scanner s = new Scanner(file);
			while(s.hasNext())
			{
				String nextLine = s.nextLine();
				if(nextLine.equals("Laser"))
				{
					try {
						obstacles.add(new Laser(s.nextInt()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("LaserError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("LaserError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("Zapper"))
				{
					try {
						obstacles.add(new Zapper(s.nextInt(),s.nextInt(),s.nextInt(),s.nextDouble()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("ZapperError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("ZapperError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("Barrier"))
				{
					try {
						barriers.add(new Barrier(s.nextInt(),s.nextInt(),s.nextInt(),s.nextDouble()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("BarrierError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("BarrierError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("Coin"))
				{
					try {
						coins.add(new Coin(s.nextInt(),s.nextInt()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("CoinError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("CoinError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("Missile"))
				{
					try {
						obstacles.add(new Missile(s.nextInt(),s.nextInt()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("MissileError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("MissileError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("TrackingMissile"))
				{
					try {
						obstacles.add(new TrackingMissile(s.nextInt(),s.nextInt(), hero));
					}
					catch(InputMismatchException e)
					{
						System.err.println("TrackingMissileError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("TrackingMissileError");
						throw new InvalidLevelFormatException();
					}
				}
				else if(nextLine.equals("Shield"))
				{
					try {
						powerUps.add(new ShieldPowerUp(s.nextInt(),s.nextInt()));
					}
					catch(InputMismatchException e)
					{
						System.err.println("ShieldError");
						throw new InvalidLevelFormatException();
					}
					catch(NoSuchElementException e)
					{
						System.err.println("ShieldError");
						throw new InvalidLevelFormatException();
					}
				}
			}
		}
		catch(InvalidLevelFormatException e)
		{
			System.err.println("Invalid format");
		}
		catch(IOException e)
		{
			System.err.println("Level not found.");
		}
		
		
	}
	public void restart()
	{
		hero.resetPosition();
		lives = STARTING_LIVES;
		score = 0;
		level = 1;
		levelLoader("Level1");
		System.out.println("restarted");
	}
}