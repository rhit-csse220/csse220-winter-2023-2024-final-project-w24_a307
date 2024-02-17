package mainApp.tests;
/**
 * Class: MissileTest
 * @author Rohan Malipeddi
 * <br>Purpose: Used to test functionality of missile
 * <br>Restrictions: Cannot be used for other objects
 */
import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;
import mainApp.domain.Missile;

public class MissileTest {

	/**
	 * Makes a default hero and another hero with pre-determined position and 
	 * velocity. 
	 */
	Hero h = new Hero();
	/**
	 * Makes a custom hero and another hero with specified position and 
	 * velocity. 
	 */
	Hero h1 = new Hero(30, 10, 290, 270, 30, 50);

	/**
	 * ensures: new missle collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN01() {
		assertEquals(true, (new Missile(20, 40)).overlapsWith(h));
	}
	
	/**
	 * ensures: new missle collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN02() {
		assertEquals(true, (new Missile(30, 45)).overlapsWith(h));
	}
	
	/**
	 * ensures: new missle collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN03() {
		assertEquals(false, (new Missile(200, 150)).overlapsWith(h));
	}
	
	/**
	 * ensures: new missle collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN04() {
		assertEquals(true, (new Missile(300, 300)).overlapsWith(h1));
	}

}
