package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;
import mainApp.domain.Missile;

public class MissileTest {

	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 100, 0, 20, 40, 0, 5);

	@Test
	public void testOverlapsWithN01() {
		if((new Missile(20, 40)).overlapsWith(h)) {
			assertEquals(1, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN02() {
		if((new Missile(30, 70)).overlapsWith(h)) {
			assertEquals(2, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN03() {
		if((new Missile(200, 150)).overlapsWith(h)) {
			assertEquals(3, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN04() {
		if((new Missile(300, 250)).overlapsWith(h)) {
			assertEquals(4, h.getScore());
		}
	}

}
