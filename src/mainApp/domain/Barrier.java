package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Barrier extends GameObject{

	private int length;
	private double rotation;
	private int x2;
	private int y2;
	private boolean above;
	public static final int BARRIER_HEIGHT = 10;
	public Barrier(int x, int y, int length, double rotation)
	{
		super(0, 0, x, y, length, BARRIER_HEIGHT);
		this.length = length;
		this.rotation = rotation;
		x2 = (int) (x+length*Math.cos(rotation));
		y2 = (int) (y+length*Math.sin(rotation));
		above = false;
		System.out.println("New Barrier with "+x+", "+y+" "+x2+","+y2);
	}
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GRAY);
		g2.translate(x,y);
		g2.rotate(rotation);
		g2.fillRect(0, 0, length, BARRIER_HEIGHT);
		g2.rotate(-rotation);
		g2.translate(-x,-y);
	}
	public boolean overlapsWith(Hero hero)
	{
		if(Math.cos(rotation)*length+x > hero.x && x < hero.x + hero.width)
		{
			//System.out.println(this + " x overlap");
			
			if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y,Math.max(y,y2)) >= hero.y )
			{
				//System.out.println("above");
				
				if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y, Math.max(y2,y)) <= hero.y+hero.height+Math.abs(y2-y))
				{
					System.out.println(this+"overlaps with hero"); // for testing
					System.out.println("Height: "+Math.tan(rotation)*(hero.x+hero.width-x)+y);
					System.out.println("Hero: "+hero.y);
					if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y, Math.max(y2,y)) <= hero.y+hero.height+Math.abs(y2-y)-hero.height/2)
					{
						if(hero.getVelY()<0)
							hero.setVelY(0);
						hero.setYBlocked(true);
						hero.setAbove(false);
						//hero.setY(hero.getY()+Hero.JETPACK_SPEED/2);
					}
					else if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y,Math.max(y,y2)) >= hero.y + hero.height/2)
					{
						if(hero.getVelY()>0)
							hero.setVelY(0);
						hero.setYBlocked(true);
						hero.setAbove(true);
						//hero.setY(hero.getY()-Hero.JETPACK_SPEED/2);
					}
					
					return true;
				}
				
			}
			
			/*
			if(Math.sin(rotation)*length+y > hero.y && y < hero.y + hero.height)
			{
				if(hero.y > Math.tan(rotation)*(hero.x+hero.width-x)+y)
				{
					above = false;
				}
				else
				{
					above = true;
				}
				System.out.println("rectangular y overlap");
				System.out.println(this+"overlaps with hero");
				return true;
			}
			*/
		}
		/*
		if(Math.sin(rotation)*length+y > hero.y && y < hero.y + hero.height)
		{
			System.out.println(this + "y second overlap");
			if(Math.cos(rotation) > hero.y && Math.tan(rotation)*(hero.x+hero.width-x)+y < hero.y+hero.height)
			{
				System.out.println("good y overlap");
				System.out.println(this+"overlaps with hero"); // for testing
				return true;
			}
		}
		*/
		return false;
	}

}
