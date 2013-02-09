package creational.factory;

/**
 * 
 */
public class ConcreteProduct2 implements Product {

	/**
	 * Cf Méthode surchargée
	 * @see creational.factory.Product#sell()
	 * {@inheritDoc}
	 */
	@Override
	public void sell() {
		System.out.println("Concrete Product 2 sold !");
	}
}



