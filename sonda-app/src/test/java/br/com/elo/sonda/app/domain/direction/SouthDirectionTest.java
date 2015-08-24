package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class SouthDirectionTest implements DirectionTest {
	IDirection south = Direction.SOUTH.getDirection();
	@Test
	public void testLeftDirection(){
		Assert.assertEquals(Direction.EAST.getDirection(), south.getLeftDirection());
	}
	
	@Test
	public void testRightDirection(){
		Assert.assertEquals(Direction.WEST.getDirection(), south.getRightDirection());
	}
	
	@Test
	public void testMove(){
		Coordinate coordinateFrom = Coordinate.createCoordinate(1,2);
		Coordinate coordinateTo = south.move(coordinateFrom);
		Assert.assertEquals(coordinateTo.getLatitude(), coordinateFrom.getLatitude() - 1);
	}

}
