package creational.absfactory;

/**
 * Concrete Chair for abstract factory pattern
 */
public class IkeaClassicChair implements Chair {

	/**
	 * Cf Méthode surchargée
	 * @see creational.absfactory.Chair#getType()
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		return "Ikea Classic Chair";
	}
}



