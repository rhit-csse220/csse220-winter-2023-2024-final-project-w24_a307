package mainApp.tests;
/**
 * Class: BarrierTest
 * @author Rohan Malipeddi
 * <br>Purpose: Used to test functionality of barrier
 * <br>Restrictions: Cannot be used for other objects
 */
import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Hero;

public class BarrierTest {
	/**
	 * Makes a default hero and another hero with pre-determined position and 
	 * velocity. 
	 */
	Hero h = new Hero();
	
	/**
	 * Makes a custom hero and another hero with specified position and 
	 * velocity. 
	 */
	Hero h1 = new Hero(30, 10, 100, 0, 20, 40);

	/**
	 * ensures: new Barrier makes the hero stop going horizontally.
	 */
	@Test
	public void testOverlapsWithN02() {
		if((new Barrier(70, 50, 9, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	
	/**
	 * ensures: new Barrier makes the hero stop going horizontally.
	 */
	@Test
	public void testOverlapsWithN03() {
		if((new Barrier(200, 350, 100, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	
	/**
	 * ensures: new Barrier makes the hero stop going horizontally.
	 */
	@Test
	public void testOverlapsWithN04() {
		if((new Barrier(300, 150, 55, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	

}
