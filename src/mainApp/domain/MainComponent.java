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

public class MainComponent extends JComponent {
	private Hero hero;
	private BufferedImage img;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Coin> coins;
	private ArrayList<Barrier> barriers;
	private int score;
	private int lives;
	private int level;
	public static final int STARTING_LIVES = 3;
	public MainComponent()
	{
		obstacles = new ArrayList<>();
		coins = new ArrayList<>();
		barriers = new ArrayList<>();
		hero = new Hero();
		lives = STARTING_LIVES;
		score = 0;
		/*
		gameObjects.add(new Zapper(10, 10, 50, Math.PI/4));
		Zapper onZapper = new Zapper(100, 10, 50, Math.PI/4);
		gameObjects.add(onZapper);
		onZapper.turnOn();
		gameObjects.add(new Laser(40));
		Laser onLaser = new Laser(100);
		onLaser.turnOn();
		gameObjects.add(onLaser);
		gameObjects.add(new Coin(200,100));
		gameObjects.add(new Barrier(200, 10, 50, Math.PI/4));
		*/
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
		level = 0;
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
		ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
		for(Obstacle obstacle : obstacles)
		{
			obstacle.update();
			if(obstacle.overlapsWith(hero))
			{
				lives--;
				hero.resetPosition();
				score = 0;
				//levelLoader("Level"+level);
				System.out.println("You died to "+obstacle);
			}			
		}
		for(Coin coin : coins)
		{
			coin.update();
			if(coin.overlapsWith(hero))
			{
				score++;
				toRemove.add(coin);
			}			
		}
		for(GameObject object : toRemove)
		{
			coins.remove(object);
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
	}
	public void levelLoader(String filename)
	{
		obstacles.clear();
		barriers.clear();
		coins.clear();
		try {
			img = ImageIO.read(new File("images/background-"+filename.toLowerCase()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
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
}