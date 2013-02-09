package creational.absfactory;

/**
 * Four Feet Table for abstract factory pattern
 */
public class FourFeetTable implements Table {

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.Table#getFeet()
	 * {@inheritDoc}
	 */
	@Override
	public Integer getFeet() {
		return 4;
	}
}



