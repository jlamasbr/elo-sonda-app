package br.com.elo.sonda.app.domain.direction;

/**
 * Interface que contem todas as implementações de direcoes disponiveis no
 * modelo e que poderao ser utilizadas por uma sonda.
 * 
 * @author jlamas
 *
 */
public interface Directions {

	public static final Direction NORTH = new North();
	public static final Direction SOUTH = new South();
	public static final Direction WEST = new West();
	public static final Direction EAST = new East();

}
