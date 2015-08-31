package br.com.elo.sonda.api.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.elo.sonda.api.platform.PlatformExploreRequest;
import br.com.elo.sonda.api.probe.SpaceProbeParameter;

public class PlatformExploreRequestBuider {

	private PlatformExploreRequest exploreRequest;
	private PlatformBuilder platformBuilder;
	private List<ProbeBuilder> probeBuilders;

	private PlatformExploreRequestBuider() {
		this.exploreRequest = new PlatformExploreRequest();
		this.probeBuilders = new ArrayList<ProbeBuilder>();
	}

	public static PlatformExploreRequestBuider platformRequest() {
		return new PlatformExploreRequestBuider();
	}

	public PlatformExploreRequestBuider withPlatform(final PlatformBuilder platformBuilder) {
		this.platformBuilder = platformBuilder;
		return this;
	}

	public PlatformExploreRequestBuider addSpaceProbe(final ProbeBuilder probeBuilder) {
		this.probeBuilders.add(probeBuilder);
		return this;
	}

	public PlatformExploreRequest build() {
		if (platformBuilder != null) {
			this.exploreRequest.setPlatform(platformBuilder.build());
		}
		this.exploreRequest.setSpaceProbes(buildSpaceProbes());
		return exploreRequest;
	}

	private List<SpaceProbeParameter> buildSpaceProbes() {
		List<SpaceProbeParameter> spaceProbeParameters = new ArrayList<>();
		for (ProbeBuilder builder : probeBuilders) {
			spaceProbeParameters.add(builder.build());
		}
		return spaceProbeParameters;
	}
}
