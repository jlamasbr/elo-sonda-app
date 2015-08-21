package br.com.elo.sonda.app.domain.direction;

import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import junit.framework.Assert;

public class SouthDirectionTest implements DirectionTest {
	Direction south = Directions.SOUTH;
	@Test
	public void testLeftDirection(){
		Assert.assertEquals(Directions.EAST, south.getLeftDirection());
	}
	
	@Test
	public void testRightDirection(){
		Assert.assertEquals(Directions.WEST, south.getRightDirection());
	}
	
	@Test
	public void testMove(){
		Coordinate coordinateFrom = Coordinate.createCoordinate(1,2);
		Coordinate coordinateTo = south.move(coordinateFrom);
		Assert.assertEquals(coordinateTo.getLatitude(), coordinateFrom.getLatitude() - 1);
	}

}
