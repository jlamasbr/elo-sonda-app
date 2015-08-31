package br.com.elo.sonda.api.platform;

import java.util.List;

import br.com.elo.sonda.api.probe.SpaceProbeVO;

public class PlatformExploreResponse {

	private List<SpaceProbeVO> probes;

	public List<SpaceProbeVO> getProbes() {
		return probes;
	}

	public void setProbes(List<SpaceProbeVO> probes) {
		this.probes = probes;
	}

}
