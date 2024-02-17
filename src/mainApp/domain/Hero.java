package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * Class: Hero
 * @author Joshua Yang, James Fusco
 * Purpose: Player controlled object, handles movement and stores data.
 */
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
	public static final int IMMUNITY_DURATION = 40;
	// --- constructor ---
	public Hero(int velX, int velY, int x, int y, int width, int height) {
		super(velX, velY, x, y, width, height);
		boosting = false;
		yblocked = false;
		above = true;
		shielded = false;
		immunityCounter = 0; 

	}
	/* --- isIMMUNE method ---
	 * ensures: if the shield is active and an obstacle is hit, the player
	 * 		will not lose a life and instead loses the shield. 
	 * - This is on a timer; if nothing is hit and the timer runs out, the player
	 *   loses the shield regardless
	 */
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
	// default constructor
	public Hero() {
		super(RUNNING_SPEED, FALLING_SPEED, STARTING_X, STARTING_Y, BARRY_WIDTH, BARRY_HEIGHT);
		boosting = false;
		yblocked = false;
		above = true;
		shielded = false;
		immunityCounter = 0; 
	}
	/* hero update method 
	 *  (mainly inherited from super)
         * ensures: hero is updated properly.
	 */
	public void update()
	{
		super.update();
		immunityCounter--;   // timer to make sure the immunity is limited in time
	}
	/* isFinished method
         * returns: true if hero is at the end of the screen (far right edge), else false.
	 */
	public boolean isFinished()
	{
		return MainApp.FRAME_WIDTH == x+width;
	}
	/* --- hero drawOn method ---
	 * ensures: hero image is drawn as well as the black box showing the hitbox
	 */
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
		if(shielded)
			g2.setColor(Color.BLUE);
		else
			g2.setColor(Color.BLACK);
		g2.drawRect(x, y, width, height);
	}
	/*  --- BOOSTING METHOD ---
	 * ensures: when the boosting button is pressed, the velocity is set:
	 * 		sets Y velocity to JETPACK_SPEED, until it is hitting another object 
	 * 			then it is set to FALLING_SPEED
	 * param: boolean isBoosting
	 */
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
	/* resetPosition method
	 * ensures: hero position is returned to the original starting spot
	 */
	public void resetPosition()
	{
		x = STARTING_X;
		y = STARTING_Y;
		velY = FALLING_SPEED;
		velX = RUNNING_SPEED;
	}
	// --- various getters and setters below ---
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
