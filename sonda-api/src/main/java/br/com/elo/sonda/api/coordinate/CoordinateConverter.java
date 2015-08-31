package br.com.elo.sonda.api.coordinate;

import br.com.elo.sonda.app.coordinate.Coordinate;

public class CoordinateConverter {
	
	public static Coordinate convertToCoordinate(CoordinateVO coordinateParameter){
		Long latitude = coordinateParameter.getLatitude();
		Long longitude = coordinateParameter.getLongitude();
		return Coordinate.createCoordinate(longitude, latitude);
	}
	
	public static CoordinateVO convertToCoordinate(Coordinate coordinateParameter){
		CoordinateVO parameter = new CoordinateVO();
		parameter.setLatitude(coordinateParameter.getLatitude());
		parameter.setLongitude(coordinateParameter.getLongitude());
		return parameter;
	}
}
