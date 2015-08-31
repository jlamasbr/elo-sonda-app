package br.com.elo.sonda.app.platform;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.elo.sonda.app.probe.SpaceProbe;

@Service
@Component
public class PlatformService {

	public Platform explorePlatform(final Platform platform, final List<SpaceProbe> probes) throws CoordinateNotFoundOnPlatformException{
		platform.addProbesOnPlatform(probes);
		platform.explorePlatformWithProbes();
		return platform;
	}
}
