package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Implementacao da direcao Norte
 * 
 * @author jlamas
 */
public class North implements IDirection {

	/**
	 * Para instanciar {@link North} utilize {@link Direction}
	 */
	protected North() {
		// para forçar a criacao da instancia via interface Destinations
	}

	/**
	 * move uma coordenada para o norte (x,y+1)
	 * 
	 * @param {@link
	 * 			Coordinate} fromCoordinate - coordenada (x,y) de partida.
	 * @return {@link Coordinate} toCoordinate - coordenada de chegada
	 */
	public Coordinate move(Coordinate fromCoordinate) {
		return Coordinate.createCoordinate(fromCoordinate.getLongitude(), fromCoordinate.getLatitude() + 1);
	}

	public IDirection getLeftDirection() {
		return Direction.WEST.getDirection();
	}

	public IDirection getRightDirection() {
		return Direction.EAST.getDirection();
	}

}
