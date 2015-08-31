package br.com.elo.sonda.api.probe;

import java.util.ArrayList;
import java.util.List;

import br.com.elo.sonda.api.coordinate.CoordinateConverter;
import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.probe.Command;
import br.com.elo.sonda.app.probe.SpaceProbe;

public class ProbeConverter {

	public static List<SpaceProbe> convertToSpaceProbe(final List<SpaceProbeParameter> probes) {
		List<SpaceProbe> spaceProbes = new ArrayList<>();

		for (SpaceProbeParameter parameter : probes) {
			spaceProbes.add(convertToSpaceProbe(parameter));
		}

		return spaceProbes;
	}

	private static SpaceProbe convertToSpaceProbe(SpaceProbeParameter parameter) {
		ProbePositionParameter positionParameter = parameter.getPosition();

		Coordinate coordinate = CoordinateConverter.convertToCoordinate(positionParameter.getCoordinate());
		Direction direction = Direction.fromCode(positionParameter.getDirection());
		List<Command> commands = Command.fromCode(parameter.getCommands());

		return new SpaceProbe(coordinate, direction, commands);
	}

	public static List<SpaceProbeParameter> convertToSpaceProbeParameter(List<SpaceProbe> probes) {
		List<SpaceProbeParameter> probeParameters = new ArrayList<>();
		for (SpaceProbe probe : probes) {
			probeParameters.add(convertToSpaceProbe(probe));
		}
		return probeParameters;
	}

	private static SpaceProbeParameter convertToSpaceProbe(SpaceProbe probe) {
		ProbePositionParameter positionParameter = new ProbePositionParameter();
		positionParameter.setCoordinate(CoordinateConverter.convertToCoordinate(probe.getCoordinate()));
		positionParameter.setDirection(Direction.fromDirection(probe.getDirection()).getCode());

		SpaceProbeParameter parameter = new SpaceProbeParameter();
		parameter.setPosition(positionParameter);
	
		return parameter;
	}
}
