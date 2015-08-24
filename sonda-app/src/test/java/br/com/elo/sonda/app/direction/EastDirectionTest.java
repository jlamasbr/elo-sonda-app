package br.com.elo.sonda.app.direction;

import org.junit.Test;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.direction.IDirection;
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
