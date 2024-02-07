package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Hero;
import mainApp.domain.Laser;

public class LaserTest {
	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 100, 0, 20, 40, 0, 5);
	/**
	 * Makes a default hero and another hero with pre-determined position and 
	 * velocity. Tests if the laser collides with the hero or not.
	 */
	@Test
	public void testOverlapsWithN01() {
		Laser l = new Laser(3);
		l.turnOn();
		assertEquals(true, l.overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN02() {
		Laser l1 = new Laser(100);
		l1.turnOn();
		assertEquals(false, l1.overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN03() {
		Laser l2 = new Laser(5);
		l2.turnOn();
		assertEquals(true, l2.overlapsWith(h));
	} 
	
	@Test
	public void testOverlapsWithN04() {
		Laser l3 = new Laser(10);
		l3.turnOn();
		assertEquals(true, l3.overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN05() {
		Laser l4 = new Laser(3);
		l4.turnOn();
		assertEquals(true, l4.overlapsWith(h1));
	}
	
	@Test
	public void testOverlapsWithN06() {
		Laser l5 = new Laser(100);
		l5.turnOn();
		assertEquals(false, l5.overlapsWith(h1));
	}
	
	@Test
	public void testOverlapsWithN07() {
		Laser l6 = new Laser(15);
		l6.turnOn();
		assertEquals(true, l6.overlapsWith(h1));
	}
	
	@Test
	public void testOverlapsWithN08() {
		Laser l7 = new Laser(300);
		l7.turnOn();
		assertEquals(false, l7.overlapsWith(h1));
	}

}
