package creational.pool;

import java.util.HashSet;
import java.util.Stack;

/**
 * 
 */
public class ConcretePool implements Pool {
	Stack<PoolElement> available;
	HashSet<PoolElement> pool;
	static final Long averate_elt_lifetime = 100L; 
	Integer poolSize;
	/**
	 * 
	 */
	public ConcretePool(Integer size) {
		available = new Stack<PoolElement>();
		available.setSize(size);
		pool = new HashSet<PoolElement>(size);
		poolSize = size;
		for (int i = 0; i < pool.size(); i++) {
			PoolElement pe = new PoolElement(averate_elt_lifetime);
			pool.add(pe);
			available.push(pe);
		}
	}
	
	/**
	 * Cf Méthode surchargée
	 * @see creational.pool.Pool#getElement()
	 * {@inheritDoc}
	 */
	@Override
	public PoolElement getElement() {
		if(available.isEmpty()) {
			try {
				wait(averate_elt_lifetime);
			} catch (InterruptedException e) {
				return null;
			}
			getElement();
		}
		return available.pop();
	}

	public synchronized static Pool getInstance() {
		return new ConcretePool(10);
	}

	/**
	 * Cf Méthode surchargée
	 * @see creational.pool.Pool#release()
	 * {@inheritDoc}
	 */
	@Override
	public void release(PoolElement elt) {
		if(elt.isExpired() ) {
			pool.remove(elt);
			PoolElement poolElement = new PoolElement(averate_elt_lifetime);
			pool.add(poolElement);
			available.push(poolElement);
		} else if(elt.isFinished()){
			try {
				available.push(elt);
			} catch (ArrayIndexOutOfBoundsException e){
				elt = null;
			}
		}
	}
}



