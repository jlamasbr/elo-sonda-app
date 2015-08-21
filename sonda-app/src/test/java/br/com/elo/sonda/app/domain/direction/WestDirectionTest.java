package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class WestDirectionTest implements DirectionTest {
	Direction west = Directions.WEST;

	@Test
	public void testLeftDirection() {
		Assert.assertEquals(Directions.SOUTH, west.getLeftDirection());
	}

	@Test
	public void testRightDirection() {
		Assert.assertEquals(Directions.NORTH, west.getRightDirection());
	}

	@Test
	public void testMove() {
		Coordinate coordinateFrom = Coordinate.createCoordinate(1, 2);
		Coordinate coordinateTo = west.move(coordinateFrom);

		Assert.assertEquals(coordinateTo.getLongitude(), coordinateFrom.getLongitude() - 1);
	}
}
