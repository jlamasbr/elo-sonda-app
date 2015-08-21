package br.com.elo.domain;

import org.junit.Assert;
import org.junit.Test;

public class PlatformTest {
	
	@Test
	public void testCreateNewPlatform(){
		final long maxLatitude = 5;
		final long maxLongitude = 4;
		Coordinate coordinate = Coordinate.createCoordinate(maxLatitude, maxLongitude);
		Platform platform = Platform.createPlatform(coordinate);
		
		Assert.assertEquals(coordinate, platform.getMaxCoordinate());
		Assert.assertEquals(Coordinate.minimumCoordinate(), platform.getMinimumCoordinate());
	}

}
