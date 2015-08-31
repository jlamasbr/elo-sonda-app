package br.com.elo.sonda.api.platform;

import java.util.List;

import br.com.elo.sonda.api.probe.SpaceProbeParameter;

public class PlatformExploreResponse {

	private List<SpaceProbeParameter> probes;

	public List<SpaceProbeParameter> getProbes() {
		return probes;
	}

	public void setProbes(List<SpaceProbeParameter> probes) {
		this.probes = probes;
	}

}
