package mainApp.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mainApp.domain.Barrier;
import mainApp.domain.Hero;

public class BarrierTest {
	Hero h = new Hero();
	Hero h1 = new Hero(30, 10, 100, 0, 20, 40);

	
	@Test
	public void testOverlapsWithN02() {
		if((new Barrier(70, 50, 9, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	
	@Test
	public void testOverlapsWithN03() {
		if((new Barrier(200, 350, 100, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	
	@Test
	public void testOverlapsWithN04() {
		if((new Barrier(300, 150, 55, Math.PI/2)).overlapsWith(h)) {
			assertEquals(0, h.getVelX());
		}
	}
	

}
