package creational.factorym;

/**
 * Implementation of Foo Factory interface
 */
public class PureFooFactory implements FooFactory {

	/**
	 * @see creational.factorym.FooFactory#createFoo()
	 * {@inheritDoc}
	 */
	@Override
	public Foo createFoo() {
		return new Foo();
	}
}



