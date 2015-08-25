package br.com.elo.sonda.api.probe;

import br.com.elo.sonda.api.coordinate.Coordinate;

public class ProbePosition {
	
	private Coordinate coordinate;
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
