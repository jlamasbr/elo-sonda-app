package br.com.elo.sonda.api.platform;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.elo.sonda.api.error.ApiErrorMessage;
import br.com.elo.sonda.api.probe.SpaceProbeParameter;

public class PlatformExploreRequest {

	@NotNull(message = ApiErrorMessage.PLATFORM_REQUIRED)
	@Valid
	private PlatformParameter platform;

	@Size(min = 1, message = ApiErrorMessage.PROBE_REQUIRED)
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
