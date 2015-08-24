package br.com.elo.sonda.app.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;

public class CoordinateTest {

	@Test
	public void testCreateMinimumCoordinate(){
		Coordinate coordinate = Coordinate.minimumCoordinate();
		Assert.assertEquals(0, coordinate.getLatitude());
		Assert.assertEquals(0, coordinate.getLongitude());
	}
	
	@Test
	public void testLessCoordinate(){
		Coordinate biggerCoordinate = Coordinate.createCoordinate(5, 5);
		Coordinate lessCoordinate = Coordinate.createCoordinate(6, 4);
		Coordinate lessCoordinate2 = Coordinate.createCoordinate(4, 6);
		Assert.assertTrue(lessCoordinate.isLessThan(biggerCoordinate));
		Assert.assertTrue(lessCoordinate2.isLessThan(biggerCoordinate));
	}
	
	@Test
	public void testBiggerCoordinate(){
		Coordinate lessCoordinate = Coordinate.createCoordinate(5, 5);
		Coordinate biggerCoordinate = Coordinate.createCoordinate(6, 4);
		Coordinate biggerCoordinate2 = Coordinate.createCoordinate(4, 6);
		Assert.assertTrue(biggerCoordinate.isBiggerThan(lessCoordinate));
		Assert.assertTrue(biggerCoordinate2.isBiggerThan(lessCoordinate));		
	}
	
}
