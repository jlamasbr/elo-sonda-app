package br.com.elo.sonda.api.probe;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.elo.sonda.api.coordinate.CoordinateParameter;

public class ProbePositionParameter {
	
	@NotNull(message="Coordinate in probePosition is required.")
	@Valid
	private CoordinateParameter coordinate;
	
	@NotBlank(message="Direction in the probePosition is required.")
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
