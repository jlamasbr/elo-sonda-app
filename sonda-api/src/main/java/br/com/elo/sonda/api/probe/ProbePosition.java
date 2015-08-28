package br.com.elo.sonda.api.probe;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.elo.sonda.api.coordinate.Coordinate;

public class ProbePosition {
	
	@NotNull(message="Coordinate in probePosition is required.")
	@Valid
	private Coordinate coordinate;
	
	@NotBlank(message="Direction in the probePosition is required.")
	private String direction;
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate initialCoordinate) {
		this.coordinate = initialCoordinate;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String initialDirection) {
		this.direction = initialDirection;
	}
	
}
