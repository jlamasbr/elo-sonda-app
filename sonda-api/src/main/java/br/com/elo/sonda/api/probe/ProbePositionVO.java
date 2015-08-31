package br.com.elo.sonda.api.probe;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.elo.sonda.api.coordinate.CoordinateVO;
import br.com.elo.sonda.api.error.ApiErrorMessage;

public class ProbePositionVO {
	
	private static final List<String> VALID_DIRECTIONS = Arrays.asList("S","N","E","W");
	
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
	
	@JsonIgnore
	@AssertTrue(message=ApiErrorMessage.INVALID_DIRECTION)
	public boolean isValidDirection(){
		return direction == null || VALID_DIRECTIONS.contains(direction);
	}
}
