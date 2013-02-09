package structural.flyweight;

/**
 * Concrete FooFlyweight
 */
public class FooBarFlyweight implements FooFlyweight {
	Object state;

	/**
	 * Cf Méthode surchargée
	 * @see structural.flyweight.FooFlyweight#doThing(java.lang.Object)
	 * {@inheritDoc}
	 */
	@Override
	public void doThing(Object state) {
		this.state = state;
	}
}



