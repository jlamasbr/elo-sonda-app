package br.com.elo.sonda.app.platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.platform.Platform;
import br.com.elo.sonda.app.probe.Command;
import br.com.elo.sonda.app.probe.SpaceProbe;

public class PlatformTest {

	@Test
	public void testCreateNewPlatform() {
		final long maxLatitude = 5;
		final long maxLongitude = 5;
		Coordinate coordinate = Coordinate.createCoordinate(maxLongitude, maxLatitude);
		Platform platform = Platform.createPlatform(coordinate);

		Assert.assertEquals(coordinate, platform.getMaxCoordinate());
		Assert.assertEquals(Coordinate.minimumCoordinate(), platform.getMinimumCoordinate());
	}

	@Test
	public void testAddProbes() throws CoordinateNotFoundOnPlatformException {

		SpaceProbe probe1 = createProbe(Coordinate.createCoordinate(1, 2));
		SpaceProbe probe2 = createProbe(Coordinate.createCoordinate(3, 1));

		Coordinate coordinate = Coordinate.createCoordinate(3, 3);
		Platform platform = Platform.createPlatform(coordinate);
		platform.addProbesOnPlatform(Arrays.asList(probe1, probe2));

		Assert.assertNotNull(platform.retrieveProbeByCoordinate(probe1.getCoordinate()));
		Assert.assertNotNull(platform.retrieveProbeByCoordinate(probe2.getCoordinate()));
	}

	@Test(expected = CoordinateNotFoundOnPlatformException.class)
	public void testAddProbesWithInvalidCoordinate() throws CoordinateNotFoundOnPlatformException {

		SpaceProbe probe1 = createProbe(Coordinate.createCoordinate(1, 2));
		SpaceProbe probe2 = createProbe(Coordinate.createCoordinate(99, 1));

		Coordinate coordinate = Coordinate.createCoordinate(3, 3);
		Platform platform = Platform.createPlatform(coordinate);
		platform.addProbesOnPlatform(Arrays.asList(probe1, probe2));
	}

	@Test
	public void testExplorePlatformWithProbes() throws CoordinateNotFoundOnPlatformException {

		SpaceProbe probe1 = createProbe(Coordinate.createCoordinate(1, 2));
		SpaceProbe probe2 = createProbe(Coordinate.createCoordinate(3, 1));

		Coordinate coordinate = Coordinate.createCoordinate(3, 3);
		Platform platform = Platform.createPlatform(coordinate);
		platform.addProbesOnPlatform(Arrays.asList(probe1, probe2));
		platform.explorePlatformWithProbes();

		Assert.assertEquals(probe1, platform.retrieveProbeByCoordinate(Coordinate.createCoordinate(1, 3)));
		Assert.assertEquals(probe2, platform.retrieveProbeByCoordinate(Coordinate.createCoordinate(3, 2)));
	}

	@Test(expected = CoordinateNotFoundOnPlatformException.class)
	public void testExplorePlatformWithProbesWithInvalidProbCommand() throws CoordinateNotFoundOnPlatformException {

		SpaceProbe probe1 = createProbe(Coordinate.createCoordinate(1, 2));
		SpaceProbe probe2 = createProbe(Coordinate.createCoordinate(3, 3));

		Coordinate coordinate = Coordinate.createCoordinate(3, 3);
		Platform platform = Platform.createPlatform(coordinate);
		platform.addProbesOnPlatform(Arrays.asList(probe1, probe2));
		platform.explorePlatformWithProbes();
	}

	private SpaceProbe createProbe(final Coordinate coordinate) {
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.fromCode("M"));
		return new SpaceProbe(coordinate, //
				Direction.fromCode("N"), //
				commands);//
	}

}
