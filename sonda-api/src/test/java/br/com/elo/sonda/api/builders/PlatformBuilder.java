package br.com.elo.sonda.api.builders;

import br.com.elo.sonda.api.platform.PlatformVO;

public class PlatformBuilder {

	private PlatformVO platformParameter;
	private CoordinateBuilder coordinateBuilder;

	private PlatformBuilder() {
		this.platformParameter = new PlatformVO();
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

	public PlatformVO build() {
		if (coordinateBuilder != null) {
			this.platformParameter.setMaxCoordinate(coordinateBuilder.build());
		}
		return platformParameter;
	}
}
