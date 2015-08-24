package br.com.elo.sonda.app.domain;

import br.com.elo.sonda.app.domain.direction.Direction;
import br.com.elo.sonda.app.domain.direction.IDirection;
import br.com.elo.sonda.app.domain.platform.CoordinateNotAvaibleOnPlatformException;
import br.com.elo.sonda.app.domain.platform.Platform;

/**
 * Classe que representa uma sonda espacial
 * 
 * @author jlamas
 *
 */
public class SpaceProbe {

	private Platform platform;
	private Coordinate coordinate;
	private IDirection direction;

	public SpaceProbe(final Platform platform, // plataforma
			final Coordinate coordinate, // coordenada incial da sonda
			final Direction direction) { // direcao inicial da sonta
		this.platform = platform;
		this.coordinate = coordinate;
		this.direction = direction.getDirection();
	}

	public Platform getPlatform() {
		return platform;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public IDirection getDirection() {
		return direction;
	}

	/**
	 * posiciona a sonda a sua direcao esquerda
	 */
	private void turnLeft() {
		this.direction = direction.getLeftDirection();
	}

	/**
	 * posiciona a sonda a sua direcao direita.
	 */
	private void turnRight() {
		this.direction = direction.getRightDirection();
	}

	/**
	 * move a sonda de acordo com a a direcao corrente.
	 * 
	 * @throws CoordinateNotAvaibleOnPlatformException
	 *             - caso a coordenada requisitada pela sonda não exista na
	 *             plataforma.
	 */
	private void move() throws CoordinateNotAvaibleOnPlatformException {
		Coordinate newCoordinate = direction.move(coordinate);
		platform.validateCoordinate(newCoordinate);
		coordinate = newCoordinate;
	}
	
	public void executeCommand(Command command) throws CoordinateNotAvaibleOnPlatformException{
		switch (command) {
		case MOVE:
			move();
			break;
		case TURN_LEFT:
			turnLeft();
			break;
		case TURN_RIGHT:
			turnRight();
			break;
		default:
			break;
		}
	}
}
