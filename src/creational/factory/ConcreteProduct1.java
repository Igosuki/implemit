package creational.factory;

/**
 * Concrete product 1 factory pattern
 */
public class ConcreteProduct1 implements Product {

	/**
	 * Cf Méthode surchargée
	 * @see creational.factory.Product#sell()
	 * {@inheritDoc}
	 */
	@Override
	public void sell() {
		System.out.println("Concrete Product 1 sold !");
	}
}



