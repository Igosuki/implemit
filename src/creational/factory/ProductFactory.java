package creational.factory;

/**
 * Factory pattern factory
 */
public class ProductFactory {
	public Product createProduct(String id) {
		if(id.equals("1")){
			return new ConcreteProduct1();
		} else {
			return new ConcreteProduct2();
		}
	}
}



