package br.com.elo.sonda.api.coordinate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.elo.sonda.api.error.ApiErrorMessage;


public class CoordinateParameter {

	@NotNull(message = ApiErrorMessage.LONGITUDE_REQUIRED)
	@Min(value = 0L, message=ApiErrorMessage.INVALID_LONGITUDE)
	private Long longitude;

	@NotNull(message = ApiErrorMessage.LATITUDE_REQUIRED)
	@Min(value = 0L, message=ApiErrorMessage.INVALID_LATITUDE)
	private Long latitude;

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

}
