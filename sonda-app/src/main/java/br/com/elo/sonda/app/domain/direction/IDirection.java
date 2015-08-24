package br.com.elo.sonda.app.domain.direction;

import br.com.elo.sonda.app.domain.Coordinate;

/**
 * Interface que representa as acoes que uma direcao deve ter dentro do modelo.
 * 
 * @author jlamas
 *
 */
public interface IDirection {

	/**
	 * move uma coordenada de acordo de alguma implementação de
	 * {@link IDirection}
	 * 
	 * @param {@link
	 * 			Coordinate} fromCoordinate - coordenada (x,y) de partida.
	 * @return {@link Coordinate} toCoordinate - coordenada de chegada
	 */
	public Coordinate move(Coordinate fromCoordinate);

	/**
	 * retorna a direcao que fica a esquerda
	 * 
	 * @return {@link IDirection}
	 */
	public IDirection getLeftDirection();

	/**
	 * retorna a direcao que fica a esquerda
	 * 
	 * @return {@link IDirection}
	 */
	public IDirection getRightDirection();

}
