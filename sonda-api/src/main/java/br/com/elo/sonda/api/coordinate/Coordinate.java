package br.com.elo.sonda.api.coordinate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Coordinate {

	@NotNull(message = "Longitude is required.")
	@Min(value = 0L, message = "Longitude must be greater or equal than 0")
	private Long longitude;

	@NotNull(message = "Latitude is required.")
	@Min(value = 0L, message = "Latitude must be greater or equal than 0")
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
