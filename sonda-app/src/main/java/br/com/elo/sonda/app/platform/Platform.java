package br.com.elo.sonda.app.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.elo.sonda.app.coordinate.Coordinate;
import br.com.elo.sonda.app.probe.SpaceProbe;

/**
 * Representa uma plataforma que as sondas irão explorar
 * 
 * @author jlamas
 *
 */
public class Platform {

	private final Coordinate maxCoordinate;
	private final Coordinate minimumCoordinate;
	private List<SpaceProbe> spaceProbes;
	private HashMap<Coordinate, SpaceProbe> probesMap;
	
	private Platform(Coordinate maxCoordinate){
		this.maxCoordinate = maxCoordinate;
		this.minimumCoordinate = Coordinate.minimumCoordinate();
		this.probesMap = new HashMap<Coordinate, SpaceProbe>();
		this.spaceProbes = new ArrayList<SpaceProbe>();
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public Coordinate getMinimumCoordinate() {
		return minimumCoordinate;
	}
	
	public List<SpaceProbe> getSpaceProbes() {
		return spaceProbes;
	}
	
	public SpaceProbe retrieveProbeByCoordinate(final Coordinate coordinate){
		return probesMap.get(coordinate);
	}
	
	public void registerProbeCoordinateOnPlatform(final SpaceProbe probe) throws CoordinateNotFoundOnPlatformException{
		validateCoordinate(probe.getCoordinate());
		this.probesMap.put(probe.getCoordinate(), probe);
	}
	
	public void addProbesOnPlatform(List<SpaceProbe> probes) throws CoordinateNotFoundOnPlatformException{
		for (SpaceProbe probe: probes) {
			registerProbeCoordinateOnPlatform(probe);
			spaceProbes.add(probe);	
		}
	}

	public void explorePlatformWithProbes() throws CoordinateNotFoundOnPlatformException{
		for(SpaceProbe spaceProbe : this.spaceProbes){
			spaceProbe.explorePlatform(this);
		}	
	}

	/**
	 * Verifica se uma determinada coordenada esta dentro dos limites da
	 * plataforma.
	 * 
	 * @param coordinate
	 *            coordenada que deverá ser validada na plataforma.
	 * @throws CoordinateNotFoundOnPlatformException
	 *             caso a coordenada não exista na plataforma.
	 */
	private void validateCoordinate(Coordinate coordinate) throws CoordinateNotFoundOnPlatformException {
		if (coordinate.isLessThan(minimumCoordinate) || coordinate.isBiggerThan(maxCoordinate)) {
			throw new CoordinateNotFoundOnPlatformException(coordinate, minimumCoordinate, maxCoordinate);
		}
	}

	/**
	 * Cria uma nova plataforma, com uma {@link Coordinate} maxima, e uma
	 * {@link Coordinate} minima (0,0)
	 * 
	 * @param maxCoordinate
	 *            - coordenada maxima que a plataforma ira suportar
	 * @return - {@link Platform} plataforma criada.
	 * @throws CoordinateNotFoundOnPlatformException 
	 */
	public static Platform createPlatform(final Coordinate maxCoordinate) {
		return new Platform(maxCoordinate);
	}

	@Override
	public String toString() {
		return "Platform [maxCoordinate=" + maxCoordinate + ", minimumCoordinate=" + minimumCoordinate + "]";
	}

}
