package structural.flyweight;

/**
 * Concrete Client
 */
public class FooBarClient implements Client {

	/**
	 * Cf Méthode surchargée
	 * @see structural.flyweight.Client#doThing(java.lang.String)
	 * {@inheritDoc}
	 */
	@Override
	public Object doThing(String key) {
		return FooBarFlyweightFactory.getInstance().getFlyweight(key);
	}
}



