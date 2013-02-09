package creational.builder;

/**
 * 
 */
public class Product2Builder implements Builder {

	/**
	 * Cf Méthode surchargée
	 * @see creational.builder.Builder#buildPart(creational.builder.Part)
	 * {@inheritDoc}
	 */
	@Override
	public Product buildPart(Part part) {
		return new Product2();
	}
}



