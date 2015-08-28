package br.com.elo.sonda.api.platform;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.elo.sonda.api.probe.SpaceProbeParameter;

@XmlRootElement
public class PlatformExploreRequest {

	@NotNull(message = "Platform is required.")
	@Valid
	private PlatformParameter platform;

	@Size(min = 1, message = "At least one space probe is required.")
	@Valid
	private List<SpaceProbeParameter> spaceProbes;

	public PlatformParameter getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformParameter platform) {
		this.platform = platform;
	}

	public List<SpaceProbeParameter> getSpaceProbes() {
		return spaceProbes;
	}

	public void setSpaceProbes(List<SpaceProbeParameter> spaceProbes) {
		this.spaceProbes = spaceProbes;
	}
}
