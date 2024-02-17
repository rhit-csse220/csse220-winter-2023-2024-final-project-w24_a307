package mainApp.tests;
/**
 * Class: CoinTest
 * @author Rohan Malipeddi
 * <br>Purpose: Used to test functionality of coin
 * <br>Restrictions: Cannot be used for other objects
 */
import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;

public class CoinTest {
	/**
	 * Makes a default hero and another hero with pre-determined position and 
	 * velocity. 
	 */
	Hero h = new Hero();

	/**
	 * ensures: new coin collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN01() {
		assertEquals(true, (new Coin(20, 40)).overlapsWith(h));
	}
	
	/**
	 * ensures: new coin collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN02() {
		assertEquals(true, (new Coin(30, 45)).overlapsWith(h));
	}
	
	/**
	 * ensures: new coin collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN03() {
		assertEquals(false, new Coin(200, 150).overlapsWith(h));
	}
	
	/**
	 * ensures: new coin collides with the hero or not
	 */
	@Test
	public void testOverlapsWithN04() {
		assertEquals(false, (new Coin(300, 250)).overlapsWith(h));
	}
	

}
