package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Laser extends Obstacle{
	private int countdown;
	private boolean isOn;
	public static final int LASER_WIDTH = 10;
	public static final int LASER_HEIGHT = 10;
	public static final int TIME_BEFORE_ON = 100;
	public static final int DURATION = 10;
	public Laser(int y) {
		super(0, 0, 0, y, LASER_WIDTH, LASER_HEIGHT);
		countdown = TIME_BEFORE_ON;
		isOn = false;
	}

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
	}
	
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
	
	public void turnOn() //for testing, delete later
	{
		isOn = true;
	}
}
