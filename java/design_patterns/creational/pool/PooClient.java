package creational.pool;

/**
 * 
 */
public class PooClient {
	void doStuff(){
		Pool pool = ConcretePool.getInstance();
		for (int i = 0; i < 10000; i++) {
			pool.getElement();
		}
	}
	
}



