package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Implementacao da direcao Norte
 * 
 * @author jlamas
 */
public class North implements Direction {

	/**
	 * Para instanciar {@link North} utilize {@link Directions}
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

	public Direction getLeftDirection() {
		return Directions.WEST;
	}

	public Direction getRightDirection() {
		return Directions.EAST;
	}

}
