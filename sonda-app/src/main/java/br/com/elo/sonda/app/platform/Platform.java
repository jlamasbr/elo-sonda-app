package br.com.elo.sonda.app.platform;

import br.com.elo.sonda.app.coordinate.Coordinate;

/**
 * Representa uma plataforma que as sondas irão explorar
 * 
 * @author jlamas
 *
 */
public class Platform {

	private final Coordinate maxCoordinate;
	private final Coordinate minimumCoordinate;

	private Platform(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
		this.minimumCoordinate = Coordinate.minimumCoordinate();
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public Coordinate getMinimumCoordinate() {
		return minimumCoordinate;
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
	public void validateCoordinate(Coordinate coordinate) throws CoordinateNotAvaibleOnPlatformException {
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
