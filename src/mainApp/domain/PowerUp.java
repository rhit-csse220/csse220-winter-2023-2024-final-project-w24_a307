package mainApp.domain;
/**
 * Class: PowerUp
 * @author Joshua Yang
 * <br>Purpose: Used as an abstract version of power ups
 * <br>Restrictions: is an abstract class, not to be used by itself
 */
public abstract class PowerUp extends GameObject {
	/*
	 *  ensures: initializes powerup abstact class
	 */
	public PowerUp(int x, int y, int width, int height) {
		super(0, 0, x, y, width, height);
	}//PowerUp

}
