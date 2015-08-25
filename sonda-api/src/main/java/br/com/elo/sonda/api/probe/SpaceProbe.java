package br.com.elo.sonda.api.probe;

import java.util.List;

public class SpaceProbe {

	private ProbePosition position;
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
