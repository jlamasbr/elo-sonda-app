package br.com.elo.sonda.app.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import br.com.elo.sonda.app.domain.Platform;
import br.com.elo.sonda.app.domain.SpaceProbe;
import br.com.elo.sonda.app.domain.direction.Directions;

public class SpaceProbeTest {
	Platform platform = Platform.createPlatform(Coordinate.createCoordinate(5, 5));
	
	@Test
	public void testTurnLeft(){
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Directions.NORTH);
		probe.turnLeft();
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Directions.WEST, probe.getDirection());
	}
	
	@Test
	public void testTurnRight(){
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Directions.NORTH);
		probe.turnRight();
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Directions.EAST, probe.getDirection());
	}
	
	@Test
	public void testMove(){
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Directions.NORTH);
		probe.move();
		Assert.assertEquals(Coordinate.createCoordinate(1, 3), probe.getCoordinate());
		Assert.assertEquals(Directions.NORTH, probe.getDirection());
	}
	
	@Test
	public void testRoute(){
	
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Directions.NORTH);
		
		probe.turnLeft();
		probe.move();
		probe.turnLeft();
		probe.move();
		probe.turnLeft();
		probe.move();
		probe.turnLeft();
		probe.move();
		probe.move();
		
		Assert.assertEquals(1, probe.getCoordinate().getLongitude());
		Assert.assertEquals(3, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Directions.NORTH, probe.getDirection());
	}
	
	@Test
	public void testRoute2(){
		Platform platform = Platform.createPlatform(Coordinate.createCoordinate(5, 5));
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(3, 3), Directions.EAST);
		
		probe.move();
		probe.move();
		probe.turnRight();
		probe.move();
		probe.move();
		probe.turnRight();
		probe.move();
		probe.turnRight();
		probe.turnRight();
		probe.move();
		
		Assert.assertEquals(5, probe.getCoordinate().getLongitude());
		Assert.assertEquals(1, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Directions.EAST, probe.getDirection());
	}

}
