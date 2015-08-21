package br.com.elo.domain;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testCreateMinimumCoordinate(){
		Coordinate coordinate = Coordinate.minimumCoordinate();
		Assert.assertEquals(0, coordinate.getLatitude());
		Assert.assertEquals(0, coordinate.getLongitude());
	}
	
}
