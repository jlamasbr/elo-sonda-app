package br.com.elo.sonda.api.probe;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.elo.sonda.api.coordinate.CoordinateParameter;
import br.com.elo.sonda.api.error.ApiErrorMessage;

public class ProbePositionParameter {
	
	@NotNull(message=ApiErrorMessage.PROBE_COORDINATE_REQUIRED)
	@Valid
	private CoordinateParameter coordinate;
	
	@NotBlank(message=ApiErrorMessage.PROBE_DIRECTION_REQUIRED)
	private String direction;
	
	public CoordinateParameter getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(CoordinateParameter initialCoordinate) {
		this.coordinate = initialCoordinate;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String initialDirection) {
		this.direction = initialDirection;
	}
}
