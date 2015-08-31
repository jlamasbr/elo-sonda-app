package br.com.elo.sonda.api.probe;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.elo.sonda.api.error.ApiErrorMessage;

public class SpaceProbeVO {

	private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M");

	@NotNull(message = ApiErrorMessage.PROBE_POSITION_REQUIRED)
	@Valid
	private ProbePositionVO position;

	@Size(min = 1, message = ApiErrorMessage.PROBE_COMMAND_REQUIRED)
	private List<String> commands;

	public ProbePositionVO getPosition() {
		return position;
	}

	public void setPosition(ProbePositionVO initialPosition) {
		this.position = initialPosition;
	}

	public List<String> getCommands() {
		return commands;
	}

	public void setCommands(List<String> commands) {
		this.commands = commands;
	}

	@JsonIgnore
	@AssertTrue(message = ApiErrorMessage.INVALID_COMMAND)
	public boolean isValidCommand() {
		return commands == null || VALID_COMMANDS.containsAll(commands);
	}
}
