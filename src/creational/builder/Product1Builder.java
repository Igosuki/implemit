package creational.builder;

/**
 * 
 */
public class Product1Builder implements Builder {

	/**
	 * Cf Méthode surchargée
	 * @see creational.builder.Builder#buildPart(creational.builder.Part)
	 * {@inheritDoc}
	 */
	@Override
	public Product buildPart(Part part) {
		return new Product1();
	}
}



