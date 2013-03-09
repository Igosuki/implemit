package org.geps.struct;

public abstract class ComplexNode<K, V> {
	private K key;
	private V value;
	
	public K getKey() {
		return this.key;
	}
	public V getValue() {	
		return this.value;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public void setValue(V value) {
		this.value = value;
	}
}