package br.com.elo.sonda.app.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import br.com.elo.sonda.app.domain.platform.Platform;

public class PlatformTest {
	
	@Test
	public void testCreateNewPlatform(){
		final long maxLatitude = 5;
		final long maxLongitude = 5;
		Coordinate coordinate = Coordinate.createCoordinate(maxLongitude,maxLatitude);
		Platform platform = Platform.createPlatform(coordinate);
		
		Assert.assertEquals(coordinate, platform.getMaxCoordinate());
		Assert.assertEquals(Coordinate.minimumCoordinate(), platform.getMinimumCoordinate());
	}

}
