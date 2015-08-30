package br.com.elo.sonda.api.probe;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.elo.sonda.api.error.ApiErrorMessage;

public class SpaceProbeParameter {

	@NotNull(message = ApiErrorMessage.PROBE_POSITION_REQUIRED)
	@Valid
	private ProbePositionParameter position;

	@Size(min = 1, message = ApiErrorMessage.PROBE_COMMAND_REQUIRED)
	private List<String> commands;

	public ProbePositionParameter getPosition() {
		return position;
	}

	public void setPosition(ProbePositionParameter initialPosition) {
		this.position = initialPosition;
	}

	public List<String> getCommands() {
		return commands;
	}

	public void setCommands(List<String> commands) {
		this.commands = commands;
	}
}
