package br.com.elo.sonda.app.probe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.platform.CoordinateNotFoundOnPlatformException;
import br.com.elo.sonda.app.platform.Platform;
import br.com.elo.sonda.app.probe.Command;
import br.com.elo.sonda.app.probe.SpaceProbe;

public class SpaceProbeTest {
	Platform platform = Platform.createPlatform(Coordinate.createCoordinate(5, 5));

	@Test
	public void testTurnLeft() throws CoordinateNotFoundOnPlatformException {
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.fromCode("L"));

		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(1, 2), //
				Direction.fromCode("N"), //
				commands);//
		probe.explorePlatform(platform);
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Direction.WEST.getDirection(), probe.getDirection());
	}

	@Test
	public void testTurnRight() throws CoordinateNotFoundOnPlatformException {
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.fromCode("R"));
		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(1, 2), //
				Direction.fromCode("N"), //
				commands);//

		probe.explorePlatform(platform);
		Assert.assertEquals(Coordinate.createCoordinate(1, 2), probe.getCoordinate());
		Assert.assertEquals(Direction.EAST.getDirection(), probe.getDirection());
	}

	@Test
	public void testMove() throws CoordinateNotFoundOnPlatformException {
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.fromCode("M"));
		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(1, 2), //
				Direction.fromCode("N"), //
				commands);//
		probe.explorePlatform(platform);
		Assert.assertEquals(Coordinate.createCoordinate(1, 3), probe.getCoordinate());
		Assert.assertEquals(Direction.NORTH.getDirection(), probe.getDirection());
	}

	@Test
	public void testRoute() throws CoordinateNotFoundOnPlatformException {
		List<Command> commands = new ArrayList<Command>();

		commands.add(Command.fromCode("L"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("L"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("L"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("L"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("M"));

		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(1, 2), //
				Direction.fromCode("N"), //
				commands);//

		probe.explorePlatform(platform);

		Assert.assertEquals(1, probe.getCoordinate().getLongitude());
		Assert.assertEquals(3, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Direction.NORTH.getDirection(), probe.getDirection());
	}

	@Test
	public void testRoute2() throws CoordinateNotFoundOnPlatformException {
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("R"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("R"));
		commands.add(Command.fromCode("M"));
		commands.add(Command.fromCode("R"));
		commands.add(Command.fromCode("R"));
		commands.add(Command.fromCode("M"));

		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(3, 3), //
				Direction.fromCode("E"), //
				commands);//

		probe.explorePlatform(platform);

		Assert.assertEquals(5, probe.getCoordinate().getLongitude());
		Assert.assertEquals(1, probe.getCoordinate().getLatitude());
		Assert.assertEquals(Direction.EAST.getDirection(), probe.getDirection());
	}

}
