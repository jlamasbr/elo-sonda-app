package br.com.elo.sonda.api.probe;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.elo.sonda.api.coordinate.CoordinateVO;
import br.com.elo.sonda.api.error.ApiErrorMessage;

public class ProbePositionVO {
	
	@NotNull(message=ApiErrorMessage.PROBE_COORDINATE_REQUIRED)
	@Valid
	private CoordinateVO coordinate;
	
	@NotBlank(message=ApiErrorMessage.PROBE_DIRECTION_REQUIRED)
	private String direction;
	
	public CoordinateVO getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(CoordinateVO initialCoordinate) {
		this.coordinate = initialCoordinate;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String initialDirection) {
		this.direction = initialDirection;
	}
}
