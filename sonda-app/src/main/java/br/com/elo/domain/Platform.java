package br.com.elo.domain;

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
