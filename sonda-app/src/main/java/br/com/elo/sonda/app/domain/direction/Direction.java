package br.com.elo.sonda.app.domain.direction;

/**
 * Enum que contem todas as implementações de direcoes disponiveis no modelo e
 * que poderao ser utilizadas por uma sonda.
 * 
 * @author jlamas
 *
 */
public enum Direction {

	NORTH("N", new North()), SOUTH("S", new South()), EAST("E", new East()), WEST("W", new West());

	private String code;
	private IDirection direction;

	private Direction(String code, IDirection direction) {
		this.code = code;
		this.direction = direction;
	}

	public String getCode() {
		return code;
	}

	public IDirection getDirection() {
		return direction;
	}

	public static Direction fromCode(final String code) {
		for (Direction direction : values()) {
			if (direction.code.equalsIgnoreCase(code)) {
				return direction;
			}
		}

		throw new IllegalArgumentException("direction not found with code: " + code);
	}

}
