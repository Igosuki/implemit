package creational.prototype;

/**
 * Concrete prototype for prototype pattern
 */
public class ConcretePrototype1 implements Prototype {
	/**
	 * Cf Méthode surchargée
	 * @see java.lang.Object#clone()
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}



