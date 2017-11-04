package creational.absfactory;

/**
 * Six Feet Table for abstract factory pattern
 */
public class SixFeetTable implements Table {

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.Table#getFeet()
	 * {@inheritDoc}
	 */
	@Override
	public Integer getFeet() {
		return 6;
	}
}



