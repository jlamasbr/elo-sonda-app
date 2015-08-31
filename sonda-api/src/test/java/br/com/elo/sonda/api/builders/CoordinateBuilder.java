package br.com.elo.sonda.api.builders;

import br.com.elo.sonda.api.coordinate.CoordinateVO;

public class CoordinateBuilder {

	private CoordinateVO coordinateParameter;
	
	private CoordinateBuilder(){
		this.coordinateParameter = new CoordinateVO();
	}
	
	public static CoordinateBuilder coordinate(){
		return new CoordinateBuilder();
	}
	
	public CoordinateBuilder withLongitude(final long longitude){
		coordinateParameter.setLongitude(longitude);
		return this;
	}
	
	public CoordinateBuilder withLatitude(final long latitude){
		coordinateParameter.setLatitude(latitude);
		return this;
	}
	
	public CoordinateVO build(){
		return coordinateParameter;
	}
}
