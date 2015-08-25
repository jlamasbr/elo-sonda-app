package br.com.elo.sonda.api.probe;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/probe")
public class SpaceProbeResource {

	@RequestMapping(value = "/explore", method = RequestMethod.POST)
	public @ResponseBody ProbeExploreRequest explorePlatform(@RequestBody ProbeExploreRequest request) {
		
		return request;
	}

}
