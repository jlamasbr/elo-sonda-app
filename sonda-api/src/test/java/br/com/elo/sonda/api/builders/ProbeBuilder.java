package br.com.elo.sonda.api.builders;

import java.util.Arrays;

import br.com.elo.sonda.api.probe.ProbePositionVO;
import br.com.elo.sonda.api.probe.SpaceProbeVO;

public class ProbeBuilder {

	private ProbePositionVO probePositionParameter;
	private SpaceProbeVO spaceProbeParameter;
	private CoordinateBuilder coordinateBuilder;

	private ProbeBuilder() {
		this.probePositionParameter = new ProbePositionVO();
		this.spaceProbeParameter = new SpaceProbeVO();
		this.coordinateBuilder = CoordinateBuilder.coordinate();
	}
	
	public static ProbeBuilder spaceProbe(){
		return new ProbeBuilder();
	}

	public ProbeBuilder withCoordinate(final CoordinateBuilder builder) {
		this.coordinateBuilder = builder;
		return this;
	}

	public ProbeBuilder withDirection(final String direction) {
		this.probePositionParameter.setDirection(direction);
		return this;
	}

	public ProbeBuilder withCommands(final String... commands) {
		this.spaceProbeParameter.setCommands(Arrays.asList(commands));
		return this;
	}

	public SpaceProbeVO build() {
		this.probePositionParameter.setCoordinate(coordinateBuilder.build());
		this.spaceProbeParameter.setPosition(probePositionParameter);
		return spaceProbeParameter;
	}
}
