package br.com.elo.sonda.app.direction;

import br.com.elo.sonda.app.coordinate.Coordinate;

/**
 * Implementacao da direcao Oeste
 * 
 * @author jlamas
 */
public class West implements IDirection {

	/**
	 * Para instanciar {@link West} utilize {@link Direction}
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

	public IDirection getLeftDirection() {
		return Direction.SOUTH.getDirection();
	}

	public IDirection getRightDirection() {
		return Direction.NORTH.getDirection();
	}

}
