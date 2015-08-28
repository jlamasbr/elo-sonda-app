package br.com.elo.sonda.api.probe;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpaceProbe {

	@NotNull(message="Position is required in spaceProbe")
	@Valid
	private ProbePosition position;
	
	@Size(min=1,message="At least one command is required in spaceProbe")
	private List<String> commands;
	
	public ProbePosition getPosition() {
		return position;
	}
	public void setPosition(ProbePosition initialPosition) {
		this.position = initialPosition;
	}
	public List<String> getCommands() {
		return commands;
	}
	public void setCommands(List<String> commands) {
		this.commands = commands;
	}

	
	
}
