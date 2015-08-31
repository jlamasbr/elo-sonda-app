package br.com.elo.sonda.api.builders;

import java.util.Arrays;

import br.com.elo.sonda.api.probe.ProbePositionParameter;
import br.com.elo.sonda.api.probe.SpaceProbeParameter;

public class ProbeBuilder {

	private ProbePositionParameter probePositionParameter;
	private SpaceProbeParameter spaceProbeParameter;
	private CoordinateBuilder coordinateBuilder;

	private ProbeBuilder() {
		this.probePositionParameter = new ProbePositionParameter();
		this.spaceProbeParameter = new SpaceProbeParameter();
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

	public SpaceProbeParameter build() {
		this.probePositionParameter.setCoordinate(coordinateBuilder.build());
		this.spaceProbeParameter.setPosition(probePositionParameter);
		return spaceProbeParameter;
	}
}
