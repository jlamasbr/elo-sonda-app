package br.com.elo.sonda.app.domain;

import br.com.elo.sonda.app.domain.direction.Direction;

/**
 * Classe que representa uma sonda espacial
 * 
 * @author jlamas
 *
 */
public class SpaceProbe {

	private Platform platform;
	private Coordinate coordinate;
	private Direction direction;

	public SpaceProbe(final Platform platform, // plataforma
			final Coordinate coordinate, // coordenada incial da sonda
			final Direction direction) { // direcao inicial da sonta
		this.platform = platform;
		this.coordinate = coordinate;
		this.direction = direction;
	}

	public Platform getPlatform() {
		return platform;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Direction getDirection() {
		return direction;
	}

	/**
	 * posiciona a sonda a sua direcao esquerda
	 */
	public void turnLeft() {
		this.direction = direction.getLeftDirection();
	}

	/**
	 * posiciona a sonda a sua direcao direita.
	 */
	public void turnRight() {
		this.direction = direction.getRightDirection();
	}

	/**
	 * move a sonda de acordo com a a direcao corrente.
	 */
	public void move() {
		coordinate = direction.move(coordinate);
	}

}
