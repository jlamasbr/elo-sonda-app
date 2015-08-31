package br.com.elo.sonda.api.platform;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.elo.sonda.api.coordinate.CoordinateVO;
import br.com.elo.sonda.api.error.ApiErrorMessage;

public class PlatformVO {

	@NotNull(message = ApiErrorMessage.PLATFORM_MAX_COORDINATE_REQUIRED)
	@Valid
	private CoordinateVO maxCoordinate;

	public CoordinateVO getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(CoordinateVO maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}
}
