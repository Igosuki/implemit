package creational.prototype;

/**
 * Client to execute the prototype pattern
 */
public class Client {

	public void doThing() throws CloneNotSupportedException {
		Prototype p = new ConcretePrototype1();
		ConcretePrototype2 p2 = (ConcretePrototype2) p.clone();
	}
}



