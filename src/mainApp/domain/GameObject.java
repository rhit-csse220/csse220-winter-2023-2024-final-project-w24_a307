package mainApp.domain;
/**
 * Class: GameObject
 * @author Joshua Yang, James Fusco
 * <br>Purpose: used as an abstract class for other objects 
 * <br>Restrictions: Cannot be used for objects that are not in the game
 */
import java.awt.Graphics;

public abstract class GameObject {
	protected int velX, velY, x, y, width, height;
	public abstract void drawOn(Graphics g);
	/* --- UPDATE METHOD ---
	 * ensures: moves the character in accordance to the current 
	 * 		x and y velocities every tick
	 * checks: 
	 *  	if - x/y position would make it out of frame
	 *    then - x/y is set back to the border edge
	 */
	public void update()
	{
		x += velX;
		if(x > MainApp.FRAME_WIDTH-width)
			x = MainApp.FRAME_WIDTH-width;
		else if (x < 0)
			x = 0;
		y += velY;
		if(y > MainApp.FRAME_HEIGHT-2*height)
			y = MainApp.FRAME_HEIGHT-2*height;
		else if (y < 0)
			y = 0;
	}
	/* --- OVERLAPSWITH METHOD ---
	 * ensures: object's hitbox is checked along with the current position of the 
	 * 		hero to see if they are overlapping and returns true if yes
	 * returns: boolean 
	 */
	public boolean overlapsWith(Hero hero)
	{
		if(x+width > hero.x && x < hero.x + hero.width)
		{
			if(y+height > hero.y && y < hero.y + hero.height)
			{
				System.out.println(this+"overlaps with hero"); // for testing
				return true;
			}
		}
		return false;
	}
	/*  constructor
	 *  parameters: x/y velocity, x/y position, width, height
	 */
	public GameObject(int velX, int velY, int x, int y, int width, int height) {
		super();
		this.velX = velX;
		this.velY = velY;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	// --- various getters and setters below ---
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
