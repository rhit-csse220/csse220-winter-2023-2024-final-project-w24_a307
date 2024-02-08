package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;
import mainApp.domain.Missile;

public class MissileTest {

	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 290, 270, 30, 50);

	@Test
	public void testOverlapsWithN01() {
		assertEquals(true, (new Missile(20, 40)).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN02() {
		assertEquals(true, (new Missile(30, 45)).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN03() {
		assertEquals(false, (new Missile(200, 150)).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN04() {
		assertEquals(true, (new Missile(300, 300)).overlapsWith(h1));
	}

}
