package mainApp;

import java.awt.Graphics;

public abstract class GameObject {
	protected int velX, velY, x, y, length, width;
	public abstract void handlePickup();
	public abstract void drawOn(Graphics g);
	public void update()
	{
		x += velX;
		if(x > MainApp.FRAME_WIDTH)
			x = MainApp.FRAME_WIDTH;
		else if (x < 0)
			x = 0;
		y += velY;
		if(y > MainApp.FRAME_HEIGHT)
			y = MainApp.FRAME_HEIGHT;
		else if (y < 0)
			y = 0;
	}
	public boolean overlapsWith(GameObject other)
	{
		return false; // to be implemented
	}
	public GameObject(int velX, int velY, int x, int y, int length, int width) {
		super();
		this.velX = velX;
		this.velY = velY;
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
	}
}
