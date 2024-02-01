package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Zapper extends Obstacle {
	private int length;
	private int countdown;
	private boolean isOn;
	private double rotation;
	public static final int ZAPPER_WIDTH = 10;
	public static final int ZAPPER_HEIGHT = 10;
	public static final int TIME_BEFORE_ON = 50;
	public static final int DURATION = 10;
	public Zapper(int x, int y, int length, double rotation) {
		super(0, 0, x, y, ZAPPER_WIDTH, ZAPPER_HEIGHT);
		this.rotation = rotation;
		this.length = length;
		countdown = TIME_BEFORE_ON;
	}
	
	public void turnOn() //for testing, delete later
	{
		isOn = true;
	}
	
	@Override
	public void update()
	{
		super.update();
		if(countdown == 0 && !isOn)
		{
			countdown = DURATION;
			isOn = true;
		}
		else if (countdown == 0)
		{
			countdown = TIME_BEFORE_ON;
			isOn = false;
		}
		else
			countdown--;
	}
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.ORANGE);
		g2.translate(x,y);
		g2.rotate(rotation);
		if(isOn)
		{
			g2.fillRect(0, 0, length, ZAPPER_HEIGHT);
		}
		else
		{
			g2.fillRect(0, 0, ZAPPER_WIDTH, ZAPPER_HEIGHT);
			g2.fillRect(length-ZAPPER_WIDTH, 0, ZAPPER_WIDTH, ZAPPER_HEIGHT);
		}
		g2.rotate(-rotation);
		g2.translate(-x,-y);
	}
	@Override
	public boolean overlapsWith(Hero hero)
	{
		if(!isOn)
			return false;
		if(Math.cos(rotation)*length+x > hero.x && x < hero.x + hero.width)
		{
			if(y+(hero.x-x)*Math.cos(rotation) < hero.y + height && y+(hero.x-x)*Math.cos(rotation)+Math.sin(rotation)*height > hero.y)
			{
				System.out.println(this+"overlaps with hero"); // for testing
				return true;
			}
		}
		return false;
	}
}
