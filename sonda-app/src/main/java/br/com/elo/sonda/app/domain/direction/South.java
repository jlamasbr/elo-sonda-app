package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Implementacao da direcao Sul
 * 
 * @author jlamas
 */
public class South implements Direction {
	/**
	 * Para instanciar {@link South} utilize {@link Directions}
	 */
	protected South() {
		// para forçar a criacao da instancia via interface Destinations
	}

	/**
	 * move uma coordenada para o sul (x,y-1)
	 * 
	 * @param {@link
	 * 			Coordinate} fromCoordinate - coordenada (x,y) de partida.
	 * @return {@link Coordinate} toCoordinate - coordenada de chegada
	 */
	public Coordinate move(Coordinate fromCoordinate) {
		return Coordinate.createCoordinate(fromCoordinate.getLongitude(), fromCoordinate.getLatitude() - 1);
	}

	public Direction getLeftDirection() {
		return Directions.EAST;
	}

	public Direction getRightDirection() {
		return Directions.WEST;
	}

}
