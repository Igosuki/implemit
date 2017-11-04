package creational.factory;

/**
 * Client for factory pattern
 */
public class Client {
	
	public int sellProduct(String id){
		ProductFactory fac = new ProductFactory();
		Product p = fac.createProduct(id);
		p.sell();
		return 0;
	}
}



