package br.com.elo.sonda.api.platform;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.elo.sonda.api.coordinate.CoordinateParameter;

public class PlatformParameter {

	@NotNull(message = "MaxCoordinate in platform is required.")
	@Valid
	private CoordinateParameter maxCoordinate;

	public CoordinateParameter getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(CoordinateParameter maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}
}
