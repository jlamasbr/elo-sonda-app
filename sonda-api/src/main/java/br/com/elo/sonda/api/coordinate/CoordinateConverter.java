package br.com.elo.sonda.api.coordinate;

import br.com.elo.sonda.app.coordinate.Coordinate;

public class CoordinateConverter {
	
	public static Coordinate convertToCoordinate(CoordinateParameter coordinateParameter){
		Long latitude = coordinateParameter.getLatitude();
		Long longitude = coordinateParameter.getLongitude();
		return Coordinate.createCoordinate(longitude, latitude);
	}
	
	public static CoordinateParameter convertToCoordinate(Coordinate coordinateParameter){
		CoordinateParameter parameter = new CoordinateParameter();
		parameter.setLatitude(coordinateParameter.getLatitude());
		parameter.setLongitude(coordinateParameter.getLongitude());
		return parameter;
	}
}
