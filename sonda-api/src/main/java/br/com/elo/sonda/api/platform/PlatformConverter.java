package br.com.elo.sonda.api.platform;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.platform.Platform;

public class PlatformConverter {

	public static Platform convertToPlatform(PlatformVO parameter) {
		Long latitude = parameter.getMaxCoordinate().getLatitude();
		Long longitude = parameter.getMaxCoordinate().getLongitude();
		return Platform.createPlatform(Coordinate.createCoordinate(longitude, latitude));
	}
}
