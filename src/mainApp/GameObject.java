package mainApp;

import java.awt.Graphics;

public abstract class GameObject {
	protected int velX, velY, x, y, length, width;
	public abstract void handlePickup();
	public abstract void drawOn(Graphics g);
	public void update()
	{
		x += velX;
		y += velY;
	}
	public boolean overlapsWith(GameObject other)
	{
		return false; // to be implemented
	}
	
}
