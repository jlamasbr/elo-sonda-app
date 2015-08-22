package br.com.elo.sonda.app.domain;

/**
 * Classe que representa uma coordenada (latitude,longitude)
 * 
 * @author jlamas
 *
 */
public class Coordinate {

	private final long longitude; //x leste-oeste
	private final long latitude; //y norte-sul
	
	//representa uma coordenada minima que pode ser usada em uma plataforma.
	private static final Coordinate MINIMUM_COORDINATE = new Coordinate(0, 0);

	private Coordinate(long longitude, long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
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
	 * Cria uma coordenada (x,y) onde x é longitude e y é latitude.
	 * @param latitude - latitude da coordenada.
	 * @param longitude - longitude da coordenada.
	 * @return {@link Coordinate} - coordenada criada.
	 */
	public static Coordinate createCoordinate(final long longitude,final long latitude) {
		return new Coordinate(longitude, latitude);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (latitude ^ (latitude >>> 32));
		result = prime * result + (int) (longitude ^ (longitude >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (latitude != other.latitude)
			return false;
		if (longitude != other.longitude)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
