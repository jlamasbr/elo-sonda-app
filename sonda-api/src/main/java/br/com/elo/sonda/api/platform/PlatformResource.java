package br.com.elo.sonda.api.platform;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.direction.Direction;
import br.com.elo.sonda.app.platform.CoordinateNotFoundOnPlatformException;
import br.com.elo.sonda.app.platform.Platform;
import br.com.elo.sonda.app.probe.Command;
import br.com.elo.sonda.app.probe.SpaceProbe;

@RestController
@RequestMapping(value = "/platform")
public class PlatformResource {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PlatformExploreRequest explorePlatform(@RequestBody @Valid PlatformExploreRequest request) {
		
		
		return request;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody PlatformExploreRequest findPlatform() {
		
		Platform platform = Platform.createPlatform(Coordinate.createCoordinate(1, 1));
		SpaceProbe probe = new SpaceProbe(Coordinate.createCoordinate(2, 2), Direction.NORTH, Arrays.asList(Command.fromCode("M")));
	
		try {
			platform.addProbesOnPlatform(probe);
		} catch (CoordinateNotFoundOnPlatformException e) {
		throw new RuntimeException(e);
		}
		
		throw new NullPointerException("erro");
		//return request;
	}
	
}
