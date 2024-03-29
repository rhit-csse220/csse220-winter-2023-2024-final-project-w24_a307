package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Class: Zapper
 * @author Joshua Yang
 * <br>Purpose: Used to create zapper objects
 * <br>Restrictions: cannot be used for making other types of barriers
 * <br>For example: 
 * <pre>
 *    obstacles.add(new Zapper(s.nextInt(),s.nextInt(),s.nextInt(),s.nextDouble()));
 * </pre>
 */
public class Zapper extends Obstacle {
	private int length;
	private int countdown;
	private int blinkCounter;
	private boolean blinkOn;
	private boolean isOn;
	private int x2;
	private int y2;
	private double rotation;
	public static final int ZAPPER_WIDTH = 10;
	public static final int ZAPPER_HEIGHT = 10;
	public static final int TIME_BEFORE_ON = 80;
	public static final int DURATION = 80;
	public static final int BLINK_INTERVAL = 5;
	/*
 	 * ensures: initializes the zapper object
   	 */
	public Zapper(int x, int y, int length, double rotation) {
		super(0, 0, x, y, ZAPPER_WIDTH, ZAPPER_HEIGHT);
		this.rotation = rotation;
		this.length = length;
		countdown = TIME_BEFORE_ON;
		x2 = (int) (x+length*Math.cos(rotation));
		y2 = (int) (y+length*Math.sin(rotation));
		blinkCounter = BLINK_INTERVAL;
		blinkOn = true;
	}//Zapper
	public void turnOn() //for testing
	{
		isOn = true;
	}
	/* --- overridden update method ---
	 * ensures: checks:
	 *    if - countdown runs out and zapper is off/on
	 *  then - the zapper turns back on/off
	 *  (before turning on, the zapper will have a blink effect for short duration)
	 */
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
		if(countdown < DURATION/2)
		{
			blinkCounter--;
		}
		else
			blinkOn = true;
		if(blinkCounter == 0)
		{
			blinkCounter = BLINK_INTERVAL;
			blinkOn = !blinkOn;
		}
		
	}//update
	/*
	 * ensures: drawOn method is overridden for the zapper
	 */
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
		else if(blinkOn)
		{
			g2.fillRect(0, 0, ZAPPER_WIDTH, ZAPPER_HEIGHT);
			g2.fillRect(length-ZAPPER_WIDTH, 0, ZAPPER_WIDTH, ZAPPER_HEIGHT);
		}
		g2.rotate(-rotation);
		g2.translate(-x,-y);
	}//drawOn
	/*
	 * ensures: zapper's overlap method works with collisions involving the hero
	 */
	@Override
	public boolean overlapsWith(Hero hero)
	{
		if(!isOn)
			return false;
		if(Math.cos(rotation)*length+x > hero.x && x < hero.x + hero.width)
		{
			if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y,y2) >= hero.y )
			{
				if(Math.min(Math.tan(rotation)*(hero.x+hero.width-x)+y,y2) <= hero.y+hero.height)
				{
					System.out.println(this+"overlaps with hero"); // for testing
					System.out.println("Height: "+Math.tan(rotation)*(hero.x+hero.width-x)+y);
					System.out.println("Hero: "+hero.y);
					System.out.println("Hero: "+(hero.y+hero.height+Math.abs(y2-y)));
					return true;
				}
			}
		}
		return false;
	}//overlapsWith
}
