package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class WestDirectionTest implements DirectionTest {
	IDirection west = Direction.WEST.getDirection();

	@Test
	public void testLeftDirection() {
		Assert.assertEquals(Direction.SOUTH.getDirection(), west.getLeftDirection());
	}

	@Test
	public void testRightDirection() {
		Assert.assertEquals(Direction.NORTH.getDirection(), west.getRightDirection());
	}

	@Test
	public void testMove() {
		Coordinate coordinateFrom = Coordinate.createCoordinate(1, 2);
		Coordinate coordinateTo = west.move(coordinateFrom);

		Assert.assertEquals(coordinateTo.getLongitude(), coordinateFrom.getLongitude() - 1);
	}
}
