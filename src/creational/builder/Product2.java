package creational.builder;

/**
 * 
 */
public class Product2 implements Product {

	/**
	 * Cf Méthode surchargée
	 * @see creational.builder.Product#getContent()
	 * {@inheritDoc}
	 */
	@Override
	public Object getContent() {
		return "Product 2";
	}
}



