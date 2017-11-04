package creational.builder;

/**
 * 
 */
public class Product1 implements Product {

	/**
	 * Cf Méthode surchargée
	 * @see creational.builder.Product#getContent()
	 * {@inheritDoc}
	 */
	@Override
	public Object getContent() {
		return "Product 1";
	}
}



