package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Hero extends GameObject{
	private int score;
	private int lives;
	private boolean boosting;
	public static final int JETPACK_SPEED = -20;
	public static final int FALLING_SPEED = 20;
	public static final int RUNNING_SPEED = 10;
	public static final int BARRY_HEIGHT = 50;
	public static final int BARRY_WIDTH = 50;
	public Hero(int velX, int velY, int x, int y, int width, int height, int score, int lives) {
		super(velX, velY, x, y, width, height);
		this.score = score;
		this.lives = lives;
		boosting = false;
	}
	public Hero(int x, int y, int score, int lives) {
		super(RUNNING_SPEED, FALLING_SPEED, x, y, BARRY_WIDTH, BARRY_HEIGHT);
		this.score = score;
		this.lives = lives;
		boosting = false;
	}
	
	@Override
	public void handlePickup(Hero hero) {
		//nothing
	}

	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(x, y, width, height);
	}

	public void loseLife()
	{
		lives--;
		if(lives <= 0)
			System.out.println("Game Over.");
	}
	public void getPoint(int pointsAdded)
	{
		score += pointsAdded;
	}
	public void setBoosting(boolean isBoosting)
	{
		boosting = isBoosting;
		if(isBoosting)
			velY = JETPACK_SPEED;
		else
			velY = FALLING_SPEED;
	}
	
}
