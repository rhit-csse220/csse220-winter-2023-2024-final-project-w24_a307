package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Hero extends GameObject{
	private int score;
	private int lives;
	public Hero(int velX, int velY, int x, int y, int length, int width, int score, int lives) {
		super(velX, velY, x, y, length, width);
		this.score = score;
		this.lives = lives;
	}
	
	@Override
	public void handlePickup() {
		//nothing
	}

	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(velX, velY, width, length);
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
	
}
