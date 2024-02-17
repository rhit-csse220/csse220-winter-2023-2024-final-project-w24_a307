package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Class: Laser
 * @author Joshua Yang
 * <br>Purpose: Used to hold information about the laser object
 * <br>Restrictions: none
 * <br>For example: 
 * <pre>
 *    obstacles.add(new Laser(s.nextInt()));
 * </pre>
 */
public class Laser extends Obstacle{
	private int countdown;
	private boolean isOn;
	public static final int LASER_WIDTH = 10;
	public static final int LASER_HEIGHT = 10;
	public static final int TIME_BEFORE_ON = 100;
	public static final int DURATION = 10;
	/*
 	 * ensures: initializes laser object
   	 */
	public Laser(int y) {
		super(0, 0, 0, y, LASER_WIDTH, LASER_HEIGHT);
		countdown = TIME_BEFORE_ON;
		isOn = false;
	} //Laser
	/* --- overridden drawOn method ---
	 * ensures: laser is drawn different depending on if on or off.
	 */
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		if(isOn)
		{
			g2.fillRect(0, y, MainApp.FRAME_WIDTH, LASER_HEIGHT);
		}
		else
		{
			g2.fillRect(0, y, LASER_WIDTH, LASER_HEIGHT);
			g2.fillRect(MainApp.FRAME_WIDTH-LASER_WIDTH-15, y, LASER_WIDTH, LASER_HEIGHT);
		} //-15 is because otherwise it loads off the screen for unknown reasons
	} // drawOn
	/* --- laser update method ---
	 * ensures: laser barrier is updated properly:
	 * uses variable 'countdown' to tell when to turn on and off
	 * - countdown set by DURATION
	 */
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
	} // update
	/* --- laser overlapsWith method ---
	 * ensures: barrier only considered as overlapping if  isOn = true.
	 */
	@Override
	public boolean overlapsWith(Hero hero)
	{
		if(!isOn)
			return false;
		if(y+height > hero.y && y < hero.y + hero.height)
		{
			System.out.println(this+"overlaps with hero"); // for testing
			return true;
		}
	return false;
	} // overlapsWith
	public void turnOn() //for testing, delete later
	{
		isOn = true;
	} // turnOn
}
