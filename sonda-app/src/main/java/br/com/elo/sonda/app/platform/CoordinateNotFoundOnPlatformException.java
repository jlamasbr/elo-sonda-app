package br.com.elo.sonda.app.platform;

import java.text.MessageFormat;

import br.com.elo.sonda.app.coordinate.Coordinate;

public class CoordinateNotFoundOnPlatformException extends Exception {

	private static final long serialVersionUID = -6016994652969443551L;
	private static final String ERROR_MESSAGE = "the coordinate: {0}, is invalid. The coordinate should be {1} and {2}";
	private static final String ERROR_CODE = "2003";
	private final Coordinate toCoordinate;
	private final Coordinate minimumCoordinate;
	private final Coordinate maxCoordinate;

	public CoordinateNotFoundOnPlatformException(final Coordinate toCoordinate, //
			final Coordinate minimumCoordinate,
			final Coordinate maxCoordinate) {
		
		super(MessageFormat.format(ERROR_MESSAGE, toCoordinate,minimumCoordinate,maxCoordinate));
		this.toCoordinate = toCoordinate;
		this.minimumCoordinate = minimumCoordinate;
		this.maxCoordinate = maxCoordinate;
	}

	public Coordinate getToCoordinate() {
		return toCoordinate;
	}
	
	public Coordinate getMinimumCoordinate() {
		return minimumCoordinate;
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public String getErrorCode(){
		return ERROR_CODE;
	}
}
