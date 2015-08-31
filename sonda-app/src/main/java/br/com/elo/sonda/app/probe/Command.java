package br.com.elo.sonda.app.probe;

import java.util.ArrayList;
import java.util.List;

public enum Command {

	TURN_RIGHT("R"), //
	TURN_LEFT("L"), //
	MOVE("M");//

	private String code;

	private Command(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Command fromCode(final String code) {
		for (Command command : values()) {
			if (command.code.equals(code)) {
				return command;
			}
		}

		throw new IllegalArgumentException("command: " + code + "is not found");
	}

	public static List<Command> fromCode(final List<String> codes) {
		List<Command> commands = new ArrayList<Command>();
		for (String code : codes) {
			commands.add(fromCode(code));
		}
		return commands;
	}
}
