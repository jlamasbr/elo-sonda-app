package br.com.elo.sonda.app.platform;

import java.util.HashMap;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.probe.SpaceProbe;

/**
 * Representa uma plataforma que as sondas irão explorar
 * 
 * @author jlamas
 *
 */
public class Platform {

	private final Coordinate maxCoordinate;
	private final Coordinate minimumCoordinate;
	private HashMap<Coordinate, SpaceProbe> spaceProbes;
	
	private Platform(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
		this.minimumCoordinate = Coordinate.minimumCoordinate();
		this.spaceProbes = new HashMap<Coordinate, SpaceProbe>();
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public Coordinate getMinimumCoordinate() {
		return minimumCoordinate;
	}
	
	public void registerProbeCoordinateOnPlatform(final SpaceProbe probe) throws CoordinateNotAvaibleOnPlatformException{
		validateCoordinate(probe.getCoordinate());
		this.spaceProbes.put(probe.getCoordinate(), probe);
	}

	/**
	 * Verifica se uma determinada coordenada esta dentro dos limites da
	 * plataforma.
	 * 
	 * @param coordinate
	 *            coordenada que deverá ser validada na plataforma.
	 * @throws CoordinateNotAvaibleOnPlatformException
	 *             caso a coordenada não exista na plataforma.
	 */
	private void validateCoordinate(Coordinate coordinate) throws CoordinateNotAvaibleOnPlatformException {
		if (coordinate.isLessThan(minimumCoordinate)) {
			throw new CoordinateNotAvaibleOnPlatformException(
					"the coordinate: " + coordinate + " should be bigger or equal than: " + minimumCoordinate);
		}
		if (coordinate.isBiggerThan(maxCoordinate)) {
			throw new CoordinateNotAvaibleOnPlatformException(
					"the coordinate: " + coordinate + " should be less or equal than: " + maxCoordinate);
		}		
	}

	/**
	 * Cria uma nova plataforma, com uma {@link Coordinate} maxima, e uma
	 * {@link Coordinate} minima (0,0)
	 * 
	 * @param maxCoordinate
	 *            - coordenada maxima que a plataforma ira suportar
	 * @return - {@link Platform} plataforma criada.
	 */
	public static Platform createPlatform(final Coordinate maxCoordinate) {
		return new Platform(maxCoordinate);
	}

	@Override
	public String toString() {
		return "Platform [maxCoordinate=" + maxCoordinate + ", minimumCoordinate=" + minimumCoordinate + "]";
	}

}
