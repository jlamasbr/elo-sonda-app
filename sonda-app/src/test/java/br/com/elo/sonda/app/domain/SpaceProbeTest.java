package br.com.elo.sonda.app.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.domain.Coordinate;
import br.com.elo.sonda.app.domain.SpaceProbe;
import br.com.elo.sonda.app.domain.direction.Direction;
import br.com.elo.sonda.app.domain.platform.CoordinateNotAvaibleOnPlatformException;
import br.com.elo.sonda.app.domain.platform.Platform;

public class SpaceProbeTest {
	Platform platform = Platform.createPlatform(Coordinate.createCoordinate(5, 5));
	
	@Test
	public void testTurnLeft() throws CoordinateNotAvaibleOnPlatformException{
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Direction.fromCode("N"));
		probe.executeCommand(Command.fromCode("L"));
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Direction.WEST.getDirection(), probe.getDirection());
	}
	
	@Test
	public void testTurnRight() throws CoordinateNotAvaibleOnPlatformException{
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Direction.fromCode("N"));
		probe.executeCommand(Command.fromCode("R"));
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Direction.EAST.getDirection(), probe.getDirection());
	}
	
	@Test
	public void testMove() throws CoordinateNotAvaibleOnPlatformException{
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Direction.fromCode("N"));
		probe.executeCommand(Command.fromCode("M"));
		Assert.assertEquals(Coordinate.createCoordinate(1, 3), probe.getCoordinate());
		Assert.assertEquals(Direction.NORTH.getDirection(), probe.getDirection());
	}
	
	@Test
	public void testRoute() throws CoordinateNotAvaibleOnPlatformException{
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(1, 2), Direction.fromCode("N"));
		
		probe.executeCommand(Command.fromCode("L"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("L"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("L"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("L"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("M"));
		
		Assert.assertEquals(1, probe.getCoordinate().getLongitude());
		Assert.assertEquals(3, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Direction.NORTH.getDirection(), probe.getDirection());
	}
	
	@Test
	public void testRoute2() throws CoordinateNotAvaibleOnPlatformException{
		SpaceProbe probe = new SpaceProbe(platform, Coordinate.createCoordinate(3, 3), Direction.fromCode("E"));
		
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("R"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("R"));
		probe.executeCommand(Command.fromCode("M"));
		probe.executeCommand(Command.fromCode("R"));
		probe.executeCommand(Command.fromCode("R"));
		probe.executeCommand(Command.fromCode("M"));
		
		Assert.assertEquals(5, probe.getCoordinate().getLongitude());
		Assert.assertEquals(1, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Direction.EAST.getDirection(), probe.getDirection());
	}

}
