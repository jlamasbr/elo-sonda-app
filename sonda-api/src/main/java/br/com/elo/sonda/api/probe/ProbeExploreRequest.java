package br.com.elo.sonda.api.probe;

import java.util.List;

import br.com.elo.sonda.api.platform.Platform;

public class ProbeExploreRequest {

	private Platform platform;
	private List<SpaceProbe> spaceProbes;
	
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public List<SpaceProbe> getSpaceProbes() {
		return spaceProbes;
	}
	public void setSpaceProbes(List<SpaceProbe> spaceProbes) {
		this.spaceProbes = spaceProbes;
	}
	
	
}
