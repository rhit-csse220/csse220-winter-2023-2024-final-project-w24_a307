package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Coin;
import mainApp.domain.Hero;

public class CoinTest {
	Hero h = new Hero();

	@Test
	public void testOverlapsWithN01() {
		assertEquals(true, (new Coin(20, 40)).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN02() {
		assertEquals(true, (new Coin(30, 45)).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN03() {
		assertEquals(false, new Coin(200, 150).overlapsWith(h));
	}
	
	@Test
	public void testOverlapsWithN04() {
		assertEquals(false, (new Coin(300, 250)).overlapsWith(h));
	}
	

}
