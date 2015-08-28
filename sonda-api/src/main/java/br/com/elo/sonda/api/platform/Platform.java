package br.com.elo.sonda.api.platform;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.elo.sonda.api.coordinate.Coordinate;

public class Platform {

	@NotNull(message = "MaxCoordinate in platform is required.")
	@Valid
	private Coordinate maxCoordinate;

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}
}
