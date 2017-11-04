package org.geps.struct;

public class ComplexBinaryNode<Comparable<K>, V> extends ComplexNode<Comparable<K>, V> {
	
	private ComplexBinaryNode<Comparable<K>, V> left;
	private ComplexBinaryNode<Comparable<K>, V> right;
	
	public ComplexBinaryNode<Comparable<K>, V> getLeft() {
		return this.left;
	}

	public void setLeft(ComplexBinaryNode<Comparable<K>, V> node) {
		this.left = node;
	}
	
	public void setRight(ComplexBinaryNode<Comparable<K>, V> node) {
		this.right = node;
	}
	
	public ComplexBinaryNode<Comparable<K>, V> getRight() {
		return this.right;
	}
}