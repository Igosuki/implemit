package org.geps.struct;

public abstract class Node<V> {

	public Node(V value) {
		this.value = value;
	}
	
	private V value;
	
	public V getValue() {	
		return this.value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}