package mainApp.domain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShieldPowerUp extends PowerUp {

	public static final int SHIELD_WIDTH = 20;
	public static final int SHIELD_HEIGHT = 20;
	public ShieldPowerUp(int x, int y) {
		super(x, y, SHIELD_WIDTH, SHIELD_HEIGHT);
	}

	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage img;
		try {
			img = ImageIO.read(new File("images/shieldpixel.png"));
			g2.drawImage(img, x, y, SHIELD_WIDTH, SHIELD_HEIGHT, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}

}
