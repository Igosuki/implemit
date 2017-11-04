package creational.absfactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Factory for abstract factory pattern
 */
public class NiceFurnitureFactory extends AbstractFurnitureFactory {

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.AbstractFurnitureFactory#createChairs()
	 * {@inheritDoc}
	 */
	@Override
	public List<Chair> createChairs() {
		List<Chair> chairs = new ArrayList<Chair>();
		chairs.add(new IkeaClassicChair());
		return chairs;
	}

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.AbstractFurnitureFactory#createTable()
	 * {@inheritDoc}
	 */
	@Override
	public Table createTable() {
		return new SixFeetTable();
	}
}



