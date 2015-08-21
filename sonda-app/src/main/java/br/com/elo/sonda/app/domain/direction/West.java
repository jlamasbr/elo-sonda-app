package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Implementacao da direcao Oeste
 * 
 * @author jlamas
 */
public class West implements Direction {

	/**
	 * Para instanciar {@link West} utilize {@link Directions}
	 */
	protected West() {
		// para forçar a criacao da instancia via interface Destinations
	}

	/**
	 * move uma coordenada para o Oeste (x - 1,y)
	 * 
	 * @param {@link
	 * 			Coordinate} fromCoordinate - coordenada (x,y) de partida.
	 * @return {@link Coordinate} toCoordinate - coordenada de chegada
	 */
	public Coordinate move(Coordinate fromCoordinate) {
		return Coordinate.createCoordinate(fromCoordinate.getLongitude() - 1, fromCoordinate.getLatitude());
	}

	public Direction getLeftDirection() {
		return Directions.SOUTH;
	}

	public Direction getRightDirection() {
		return Directions.NORTH;
	}

}
