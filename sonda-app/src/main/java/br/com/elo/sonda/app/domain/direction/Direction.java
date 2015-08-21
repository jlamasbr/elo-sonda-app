package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

public interface Direction {

	public Coordinate move(Coordinate fromCoordinate);
	
	public Direction getLeftDirection();
	
	public Direction getRightDirection();
	
}
