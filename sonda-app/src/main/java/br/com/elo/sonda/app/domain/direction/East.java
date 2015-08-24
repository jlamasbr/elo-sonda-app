package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Implementacao da direcao Leste
 * 
 * @author jlamas
 */
public class East implements IDirection {

	/**
	 * Para instanciar {@link East} utilize {@link Direction}
	 */
	protected East() {
		// para forçar a criacao da instancia via interface Destinations
	}

	/**
	 * move uma coordenada para o leste (x+1,y)
	 * 
	 * @param {@link
	 * 			Coordinate} fromCoordinate - coordenada (x,y) de partida.
	 * @return {@link Coordinate} toCoordinate - coordenada de chegada
	 */
	public Coordinate move(Coordinate fromCoordinate) {
		return Coordinate.createCoordinate(fromCoordinate.getLongitude() + 1, fromCoordinate.getLatitude());
	}

	public IDirection getLeftDirection() {
		return Direction.NORTH.getDirection();
	}

	public IDirection getRightDirection() {
		return Direction.SOUTH.getDirection();
	}
}
