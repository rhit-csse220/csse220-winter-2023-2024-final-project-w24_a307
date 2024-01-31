package mainApp;

import java.awt.Graphics;

public abstract class Obstacle extends GameObject{

	public Obstacle(int velX, int velY, int x, int y, int width, int height) {
		super(velX, velY, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handlePickup(Hero hero) {
		hero.loseLife();
	}
	
}
