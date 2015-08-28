package br.com.elo.sonda.api.probe;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/platform")
public class SpaceProbeResource {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ProbeExploreRequest explorePlatform(@RequestBody @Valid ProbeExploreRequest request) {
		
		
		return request;
	}

}
