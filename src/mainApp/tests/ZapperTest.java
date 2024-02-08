package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Hero;
import mainApp.domain.Laser;
import mainApp.domain.Zapper;

public class ZapperTest {
	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 95, 95, 20, 40);
	Hero h2 = new Hero(30, 10, 70, 175, 20, 80);
	/**
	 * Makes a default hero and another hero with pre-determined position and 
	 * velocity. Tests if the laser collides with the hero or not.
	 */
	@Test
	public void testOverlapsWithN01() {
		Zapper z = new Zapper(20, 20, 80, Math.PI/4);
		z.turnOn();
		assertEquals(true, z.overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN02() {
		Zapper z1 = new Zapper(70, 200, 78, Math.PI/6);
		z1.turnOn();
		assertEquals(false, z1.overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN03() {
		Zapper z2 = new Zapper(105, 105, 9, Math.PI/12);
		z2.turnOn();
		assertEquals(true, z2.overlapsWith(h1));
	}
	
	@Test
	public void testOverlapsWithN04() {
		Zapper z3 = new Zapper(90, 80, 62, Math.PI/6);
		z3.turnOn();
		assertEquals(false, z3.overlapsWith(h1));
	}
	@Test
	public void testOverlapsWithN05() {
		Zapper z4 = new Zapper(40, 20, 80, Math.PI/4);
		z4.turnOn();
		assertEquals(false, z4.overlapsWith(h1));
	}
	@Test
	public void testOverlapsWithN06() {
		System.out.println("In Test 6: with hero in middle and zapper turned on");
		Zapper z5 = new Zapper(70, 200, 20, Math.PI/3);
		z5.turnOn();
		assertEquals(true, z5.overlapsWith(h2));
	}
	
	@Test
	public void testOverlapsWithN09() {	
		System.out.println("In Test 9: with hero in middle and zapper turned off");
		Zapper z8 = new Zapper(70, 200, 20, Math.PI/3);
		assertEquals(false, z8.overlapsWith(h2));
	}
	
	@Test
	public void testOverlapsWithN07() {
		Zapper z6 = new Zapper(105, 205, 9, Math.PI/12);
		z6.turnOn();
		assertEquals(false, z6.overlapsWith(h2));
	}
	@Test
	public void testOverlapsWithN08() {
		Zapper z7 = new Zapper(87, 82, 62, Math.PI/6);
		z7.turnOn();
		assertEquals(true, z7.overlapsWith(h1));
	}
	
}
