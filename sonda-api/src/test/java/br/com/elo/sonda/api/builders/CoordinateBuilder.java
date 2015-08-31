package br.com.elo.sonda.api.builders;

import br.com.elo.sonda.api.coordinate.CoordinateParameter;

public class CoordinateBuilder {

	private CoordinateParameter coordinateParameter;
	
	private CoordinateBuilder(){
		this.coordinateParameter = new CoordinateParameter();
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
	
	public CoordinateParameter build(){
		return coordinateParameter;
	}
}
