package br.com.elo.sonda.app.probe;

import java.util.List;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.direction.IDirection;
import br.com.elo.sonda.app.platform.CoordinateNotFoundOnPlatformException;
import br.com.elo.sonda.app.platform.Platform;

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
	private final List<Command> commands;
	
	public SpaceProbe(
			final Coordinate coordinate, // coordenada incial da sonda
			final Direction direction, // direcao inicial da sonda
			final List<Command> commands){//comandos que a sonda ira executar 
		this.coordinate = coordinate;
		this.direction = direction.getDirection();
		this.commands = commands;
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
	
	public List<Command> getCommands() {
		return commands;
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
	 * move a sonda de acordo com a direcao corrente.
	 * 
	 * @throws CoordinateNotFoundOnPlatformException
	 *             - caso a coordenada requisitada pela sonda não exista na
	 *             plataforma.
	 */
	private void move() throws CoordinateNotFoundOnPlatformException {
		coordinate = direction.move(coordinate);
		platform.registerProbeCoordinateOnPlatform(this);
	}
	
	
	public void explorePlatform(Platform platform) throws CoordinateNotFoundOnPlatformException{
		this.platform = platform;
		for (Command command : commands){
			executeCommand(command);
		}
	}
	
	private void executeCommand(Command command) throws CoordinateNotFoundOnPlatformException{
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
			throw new IllegalArgumentException("unknow command: " + command);
		}
	}
}
