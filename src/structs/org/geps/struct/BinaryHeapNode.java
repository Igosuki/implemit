package org.geps.struct;

public class BinaryNode<T extends Comparable> extends Node<T> {
	
	private T value;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T value) {
		this.value = value;
	}
	
	public BinaryNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(BinaryNode<T> node) {
		this.left = node;
	}
	
	public void setRight(BinaryNode<T> node) {
		this.right = node;
	}
	
	public BinaryNode<T> getRight() {
		return this.right;
	}
	
	public T getValue() {
		return this.value;
	}
}