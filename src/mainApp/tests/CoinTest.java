package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;

public class CoinTest {
	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 100, 0, 20, 40, 0, 5);

	@Test
	public void testOverlapsWithN01() {
		if((new Coin(20, 40)).overlapsWith(h)) {
			assertEquals(1, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN02() {
		if((new Coin(30, 70)).overlapsWith(h)) {
			assertEquals(2, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN03() {
		if((new Coin(200, 150)).overlapsWith(h)) {
			assertEquals(3, h.getScore());
		}
	}
	
	@Test
	public void testOverlapsWithN04() {
		if((new Coin(300, 250)).overlapsWith(h)) {
			assertEquals(4, h.getScore());
		}
	}
	

}
