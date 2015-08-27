package br.com.elo.sonda.app.platform;

import java.text.MessageFormat;

import br.com.elo.sonda.app.coordinate.Coordinate;

public class CoordinateNotFoundOnPlatformException extends Exception {

	private static final long serialVersionUID = -6016994652969443551L;
	private static final String ERROR_MESSAGE = "the coordinate: {0}, is invalid. The coordinate should be {1} and {2}";
	private final Coordinate toCoordinate;
	private final Coordinate limitCoordinate;

	public CoordinateNotFoundOnPlatformException(final Coordinate toCoordinate, //
			final Coordinate minimumCoordinate,
			final Coordinate maxCoordinate) {
		
		super(MessageFormat.format(ERROR_MESSAGE, toCoordinate,minimumCoordinate,maxCoordinate));
		this.toCoordinate = toCoordinate;
		this.limitCoordinate = minimumCoordinate;
	}

	public Coordinate getToCoordinate() {
		return toCoordinate;
	}

	public Coordinate getLimitCoordinate() {
		return limitCoordinate;
	}
}
