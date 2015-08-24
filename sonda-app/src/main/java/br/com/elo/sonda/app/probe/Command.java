package br.com.elo.sonda.app.probe;

public enum Command {

	TURN_RIGHT("R"), TURN_LEFT("L"), MOVE("M");

	private String code;

	private Command(final String code) {
		this.code = code;
	}

	public static Command fromCode(final String code) {
		for (Command command : values()) {
			if (command.code.equals(code)) {
				return command;
			}
		}

		throw new IllegalArgumentException("command: " + code + "is not found");
	}
}
