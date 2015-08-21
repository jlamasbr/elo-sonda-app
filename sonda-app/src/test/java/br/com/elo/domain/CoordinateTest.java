package br.com.elo.domain;

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
	
}
