package br.com.elo.sonda.api.probe;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.elo.sonda.api.platform.Platform;

@XmlRootElement
public class ProbeExploreRequest {

	@NotNull(message = "Platform is required.")
	@Valid
	private Platform platform;

	@Size(min = 1, message = "At least one space probe is required.")
	@Valid
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
