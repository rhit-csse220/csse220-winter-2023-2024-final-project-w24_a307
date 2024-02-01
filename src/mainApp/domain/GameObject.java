package mainApp.domain;

import java.awt.Graphics;

public abstract class GameObject {
	protected int velX, velY, x, y, width, height;
	public abstract void handlePickup(Hero hero);
	public abstract void drawOn(Graphics g);
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
	public boolean overlapsWith(Hero hero)
	{
		return false; // to be implemented
	}
	public GameObject(int velX, int velY, int x, int y, int width, int height) {
		super();
		this.velX = velX;
		this.velY = velY;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
}
