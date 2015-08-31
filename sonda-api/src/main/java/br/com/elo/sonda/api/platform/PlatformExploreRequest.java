package br.com.elo.sonda.api.platform;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.elo.sonda.api.error.ApiErrorMessage;
import br.com.elo.sonda.api.probe.SpaceProbeVO;

public class PlatformExploreRequest {

	@NotNull(message = ApiErrorMessage.PLATFORM_REQUIRED)
	@Valid
	private PlatformVO platform;

	@Size(min = 1, message = ApiErrorMessage.PROBE_REQUIRED)
	@Valid
	private List<SpaceProbeVO> spaceProbes;

	public PlatformVO getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformVO platform) {
		this.platform = platform;
	}

	public List<SpaceProbeVO> getSpaceProbes() {
		return spaceProbes;
	}

	public void setSpaceProbes(List<SpaceProbeVO> spaceProbes) {
		this.spaceProbes = spaceProbes;
	}
}
