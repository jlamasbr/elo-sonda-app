package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class EastDirectionTest implements DirectionTest {
	Direction east = Directions.EAST;

	@Test
	public void testLeftDirection() {
		Assert.assertEquals(Directions.NORTH, east.getLeftDirection());
	}

	@Test
	public void testRightDirection() {
		Assert.assertEquals(Directions.SOUTH, east.getRightDirection());
	}

	@Test
	public void testMove() {
		Coordinate coordinateFrom = Coordinate.createCoordinate(1, 2);
		Coordinate coordinateTo = east.move(coordinateFrom);

		Assert.assertEquals(coordinateTo.getLongitude(), coordinateFrom.getLongitude() + 1);
	}

}
