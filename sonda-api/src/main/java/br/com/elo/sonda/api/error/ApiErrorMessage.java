package br.com.elo.sonda.api.error;

public interface ApiErrorMessage {

	//COORDINATE VALIDATION MESSAGES;
	public static final String LATITUDE_REQUIRED = "1001";
	public static final String LONGITUDE_REQUIRED = "1002";
	public static final String INVALID_LATITUDE = "1003";
	public static final String INVALID_LONGITUDE = "1004";
	
	//PLATFORM VALIDATION MESSAGES
	public static final String PLATFORM_MAX_COORDINATE_REQUIRED = "2001";
	public static final String PLATFORM_REQUIRED = "2002";
	
	//PROBE VALIDATION MESSAGES
	public static final String PROBE_COORDINATE_REQUIRED = "3001";
	public static final String PROBE_DIRECTION_REQUIRED = "3002";
	public static final String PROBE_POSITION_REQUIRED = "3003";
	public static final String PROBE_COMMAND_REQUIRED = "3004";
	public static final String PROBE_REQUIRED = "3005";
}
