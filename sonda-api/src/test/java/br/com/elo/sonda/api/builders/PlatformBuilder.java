package br.com.elo.sonda.api.builders;

import br.com.elo.sonda.api.platform.PlatformParameter;

public class PlatformBuilder {

	private PlatformParameter platformParameter;
	private CoordinateBuilder coordinateBuilder;

	private PlatformBuilder() {
		this.platformParameter = new PlatformParameter();
	}

	public static PlatformBuilder platform() {
		return new PlatformBuilder();
	}

	public PlatformBuilder withSize(final long longitude, final long latitude) {
		this.coordinateBuilder.withLatitude(latitude).withLongitude(longitude);
		return this;
	}

	public PlatformBuilder withCoordinate(CoordinateBuilder coordinateBuilder) {
		this.coordinateBuilder = coordinateBuilder;
		return this;
	}

	public PlatformParameter build() {
		if (coordinateBuilder != null) {
			this.platformParameter.setMaxCoordinate(coordinateBuilder.build());
		}
		return platformParameter;
	}
}
