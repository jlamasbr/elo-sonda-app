package br.com.elo.domain;

/**
 * Classe que representa uma coordenada (latitude,longitude)
 * 
 * @author jlamas
 *
 */
public class Coordinate {

	private final long latitude;
	private final long longitude;
	
	//representa uma coordenada minima que pode ser usada em uma plataforma.
	private static final Coordinate MINIMUM_COORDINATE = new Coordinate(0, 0);

	private Coordinate(long latitude, long longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	/**
	 * cria uma coordenada minima, de acordo com o modelo toda plataforma tem a
	 * coordenada minima em 0,0
	 * 
	 * @return {@link Coordinate} coordenada minima.
	 */
	public static Coordinate minimumCoordinate() {
		return MINIMUM_COORDINATE;
	}
	
	/**
	 * Cria uma coordenada (x,y) onde x é latitude e y é longitude.
	 * @param latitude - latitude da coordenada.
	 * @param longitude - longitude da coordenada.
	 * @return {@link Coordinate} - coordenada criada.
	 */
	public static Coordinate createCoordinate(final long latitude, final long longitude) {
		return new Coordinate(latitude, longitude);
	}

	@Override
	public String toString() {
		return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
