package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero extends GameObject{
	private boolean boosting;
	private boolean yblocked;
	private boolean above;
	private boolean shielded;
	private int immunityCounter;
	public static final int JETPACK_SPEED = -4;
	public static final int FALLING_SPEED = 4;
	public static final int RUNNING_SPEED = 1;
	public static final int BARRY_HEIGHT = 50;
	public static final int BARRY_WIDTH = 30;
	public static final int STARTING_X = 5;
	public static final int STARTING_Y = 0;
	public static final int IMMUNITY_DURATION = 15;
	
	public Hero(int velX, int velY, int x, int y, int width, int height) {
		super(velX, velY, x, y, width, height);
		boosting = false;
		yblocked = false;
		above = true;
		shielded = false;
		immunityCounter = 0; 

	}
	public boolean isImmune()
	{
		if(immunityCounter > 0)
			return true;
		else if(shielded)
		{
			immunityCounter  = IMMUNITY_DURATION;
			shielded = false;
			return true;
		}
		return false;
		
	}
	public Hero() {
		super(RUNNING_SPEED, FALLING_SPEED, STARTING_X, STARTING_Y, BARRY_WIDTH, BARRY_HEIGHT);
		boosting = false;
		yblocked = false;
		above = true;
		shielded = false;
		immunityCounter = 0; 
	}
	public void update()
	{
		super.update();
		immunityCounter--;
	}
	@Override
	public void handlePickup(Hero hero) {
		//nothing
	}
	public boolean isFinished()
	{
		return MainApp.FRAME_WIDTH == x+width;
	}
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage img;
		try {
			img = ImageIO.read(new File("images/hero.gif"));
			g2.drawImage(img, x, y, width, height, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, width, height);
	}

	public void setBoosting(boolean isBoosting)
	{
			boosting = isBoosting;
			if(isBoosting)
			{
				if(above || !yblocked)
					velY = JETPACK_SPEED;
			}
			else
			{
				if(!above || !yblocked)
					velY = FALLING_SPEED;
			}
	}
	public void resetPosition()
	{
		x = STARTING_X;
		y = STARTING_Y;
	}
	public int getVelX() {
		return velX;
	}
	public boolean isYBlocked()
	{
		return yblocked;
	}
	public void setYBlocked(boolean isBlocked)
	{
		yblocked = isBlocked;
	}
	public boolean isAbove() {
		return above;
	}
	public void setAbove(boolean above) {
		this.above = above;
	}
	public void setShielded(boolean isShielded)
	{
		shielded = isShielded;
	}
}
