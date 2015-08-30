package br.com.elo.sonda.api.platform;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.elo.sonda.api.coordinate.CoordinateParameter;
import br.com.elo.sonda.api.error.ApiErrorMessage;

public class PlatformParameter {

	@NotNull(message = ApiErrorMessage.PLATFORM_MAX_COORDINATE_REQUIRED)
	@Valid
	private CoordinateParameter maxCoordinate;

	public CoordinateParameter getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(CoordinateParameter maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}
}
