package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class NorthDirectionTest implements DirectionTest {
	
	private Direction north = Directions.NORTH;
	@Test
	public void testLeftDirection() {
		Assert.assertEquals(Directions.WEST, north.getLeftDirection());
	}

	@Test
	public void testRightDirection() {
		Assert.assertEquals(Directions.EAST, north.getRightDirection());
	}

	@Test
	public void testMove() {
		Coordinate coordinateFrom = Coordinate.createCoordinate(1, 2);
		Coordinate coordinateTo = north.move(coordinateFrom);
		Assert.assertEquals(coordinateTo.getLatitude(), coordinateFrom.getLatitude() + 1);
	}

}