package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Hero extends GameObject{

	@Override
	public void handlePickup() {
		//nothing
	}

	@Override
	public void drawOn(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(velX, velY, width, length);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
