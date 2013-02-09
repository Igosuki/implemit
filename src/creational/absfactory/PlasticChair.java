package creational.absfactory;

/**
 * Plastic Chair for abstract factory pattern
 */
public class PlasticChair implements Chair {

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.Chair#getType()
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		return "Plastic Chair";
	}
}



