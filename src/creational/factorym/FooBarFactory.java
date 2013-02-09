/**
 * 
 */
package creational.factorym;

/**
 * Implement Foo Factory
 */
public class FooBarFactory implements FooFactory {

	class Bar {
		Object someNestedClassField;
	}
	
	/**
	 * Cf Méthode surchargée
	 * @see creational.factorym.FooFactory#createFoo()
	 * {@inheritDoc}
	 */
	@Override
	public Foo createFoo() {
		Foo foo = new Foo();
		foo.someField = new Bar();
		return foo;
	}
}



