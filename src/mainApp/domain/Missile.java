package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Missile extends Obstacle{
	public static final int MISSILE_X_SPEED = -Hero.RUNNING_SPEED; 
	public static final int MISSILE_WIDTH = 20;
	public static final int MISSILE_HEIGHT = 10;
	public Missile(int x, int y) {
		super(MISSILE_X_SPEED, 0, x, y, MISSILE_WIDTH, MISSILE_HEIGHT);
		
	}
	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage img;
		try {
			img = ImageIO.read(new File("images/missile.png"));
			g2.drawImage(img, x, y, MISSILE_WIDTH, MISSILE_HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//g2.setColor(Color.RED);
		//g2.fillOval(x, y, width, height);
	}
	@Override 
	public void update()
	{
		super.update();
		if(x <= 0)
			this.x =  MainApp.FRAME_WIDTH;
	}

}
