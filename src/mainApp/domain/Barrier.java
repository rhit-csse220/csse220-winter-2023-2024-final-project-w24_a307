package mainApp.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Barrier extends GameObject{

	private int length;
	private double rotation;
	public static final int BARRIER_HEIGHT = 10;
	public Barrier(int x, int y, int length, double rotation)
	{
		super(0, 0, x, y, length, BARRIER_HEIGHT);
		this.length = length;
		this.rotation = rotation;
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
	@Override
	public void handlePickup(Hero hero) {
		//nothing, do not let him pass.
	}

}
