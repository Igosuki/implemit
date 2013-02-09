package creational.pool;


/**
 *
 */
public interface Pool {
	
	PoolElement getElement();
	
	void release(PoolElement elt);
}



