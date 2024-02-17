package mainApp.domain;

import java.awt.Graphics;
/**
 * Class: Obstacle
 * @author Joshua Yang
 * <br>Purpose: Used as an absrtact class for all obstacles
 * <br>Restrictions: is an abstract class, not to be used by itself
 */
public abstract class Obstacle extends GameObject{
	/*
	 * ensures: initializes default objects
	 */
	public Obstacle(int velX, int velY, int x, int y, int width, int height) {
		super(velX, velY, x, y, width, height);
	}//Obstacle
}
