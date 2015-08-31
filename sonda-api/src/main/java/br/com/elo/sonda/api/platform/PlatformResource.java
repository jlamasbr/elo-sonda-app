package br.com.elo.sonda.api.platform;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.sonda.api.error.BadRequestException;
import br.com.elo.sonda.api.probe.ProbeConverter;
import br.com.elo.sonda.app.platform.CoordinateNotFoundOnPlatformException;
import br.com.elo.sonda.app.platform.Platform;
import br.com.elo.sonda.app.platform.PlatformService;
import br.com.elo.sonda.app.probe.SpaceProbe;

@RestController
@RequestMapping(value = "/platform")
@Service
public class PlatformResource {

	@Autowired
	PlatformService platformService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PlatformExploreResponse explorePlatform(@RequestBody @Valid PlatformExploreRequest request) {
		PlatformExploreResponse response = new PlatformExploreResponse();
	
		Platform platform = PlatformConverter.convertToPlatform(request.getPlatform());
		List<SpaceProbe> probes = ProbeConverter.convertToSpaceProbe(request.getSpaceProbes());

		try {
			platform = platformService.explorePlatform(platform, probes);
			response.setProbes(ProbeConverter.convertToSpaceProbeParameter(platform.getSpaceProbes()));
		} catch (CoordinateNotFoundOnPlatformException e) {
			throw new BadRequestException(e.getErrorCode(), e.getToCoordinate(),e.getMinimumCoordinate(),e.getMaxCoordinate());
		}
		
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody PlatformExploreRequest findPlatform() {
		return null;
	}

}
