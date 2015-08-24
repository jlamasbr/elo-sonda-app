package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class EastDirectionTest implements DirectionTest {
	IDirection east = Direction.EAST.getDirection();

	@Test
	public void testLeftDirection() {
		Assert.assertEquals(Direction.NORTH.getDirection(), east.getLeftDirection());
	}

	@Test
	public void testRightDirection() {
		Assert.assertEquals(Direction.SOUTH.getDirection(), east.getRightDirection());
	}

	@Test
	public void testMove() {
		Coordinate coordinateFrom = Coordinate.createCoordinate(1, 2);
		Coordinate coordinateTo = east.move(coordinateFrom);

		Assert.assertEquals(coordinateTo.getLongitude(), coordinateFrom.getLongitude() + 1);
	}

}
