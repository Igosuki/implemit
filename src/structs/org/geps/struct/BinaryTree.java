package org.geps.struct;

//T is the type of the node values
//Non balanced binary tree, can be O(n) instead of O(log n) in reading and inserting 
// (cascading values all respecting the same total order will cause an n element tree depth)
//This class presents little interest without balancing
public class BinaryTree<T> {
	
	BinaryNode<T> root;
	
	Comparator<T> comparator;
	
	int count;
	
	public BinaryTree(T first) {
		this.root = first;
	}
	
	public BinaryTree() {
	}
	
	//Add an item in the trees
	public void add(T item) {
		BinaryNode<T> parent = traverseAdd(root, new BinaryNode(item));
	}
	
	//Search an item in the tree
	public T search(T query) {
		return search(query, root);	
	} 
	
	//Search an item in the tree
	public BinaryNode search(T query, BinaryNode root) {
		int cmp;
		BinaryNode traversingNode = root;
		while(traversingNode != null) {
			cmp = compare(traversingNode.getValue(), query);
			switch(cmp) {
				case 0 :
					return traversingNode;
				case 1 : //Case searchingNode's value is < to traversingNode
					traversingNode = traversingNode.getLeft();
					continue;
				case -1 : 
					traversingNode = traversingNode.getRight(); 
					continue;
				default : break;
			}
		}
		return traversingNode;
	} 
	
	/**
	*	Recursive print
	**/
	public void print(BinaryNode node) {
		System.out.println("\t"+node.getValue());
		System.out.println("/\t\\");
		System
	}
	
	public Iterator<BinaryNode<T>> iterator() {
		
	}
	
	//Remove an item from the tree
	//<!--If false is returned it means the item did not exist in the tree-->
	//Doing recursion but it's not necessary, can do a while != null + return breaking
	public BinaryNode remove(T item, BinaryNode traversingNode) {
		if(traversingNode = null || item == null) {
			return null;
		}
		if(compare(item, traversingNode.getValue()) > 0) {
			traversingNode.setRight(remove(item, traversingNode.getRight()));
		} else if(compare(item, traversingNode.getValue()) < 0) {
			traversingNode.setLeft(remove(item, traversingNode.getLeft()));
		} else if(traversingNode.hasBothChildren()) {
			traversingNode.setValue(findMin(traversingNode));
			traversingNode.remove(traversingNode.getValue(), traversingNode);
		} else {
			count--;
			traversingNode = traversingNode.getLeft() != null ? traversingNode.getLeft() : traversingNode.getRight();
		}
		return traversingNode;
	}
	
	public T findMin(BinaryNode node) {
		BinaryNode iterator = node;
		//Why do recurtion ? Wanna clutter the call stack with log n elements for nothing ?
		while(iterator != null && iterator.getLeft() != null) {
			iterator = iterator.left;
		}
		return iterator != null ? iterator.getValue() : null;
	}
	
	//Find a suitable node matching the value of the searchingNode
	public BinaryNode traverseAdd(BinaryNode startNode, BinaryNode searchingNode) {
		if(startNode == null) {
			startNode = searchingNode;
			return startNode;
		}
		int cmp;
		BinaryNode traversingNode = startNode;
		while(traversingNode.hasChildren() && (cmp = compare(traversingNode.getValue(), searchingNode.getValue())) != 0) {
			switch(cmp) {
				case 1 : //Case searchingNode's value is < to traversingNode
					if(traversingNode.getLeft() == null) {
						count++;
						traversingNode.setLeft(searchingNode);
						return traversingNode;
					} else {
						traversingNode = traversingNode.getLeft();
						continue;
					}
				case -1 : 
					if(traversingNode.getRight()) {
						count++;
						traversingNode.setRight(searchingNode));
						return traversingNode;
					} else {
						traversingNode = traversingNode.getRight(); 
						continue;
					}
				default : break;
			}
		}
		return traversingNode;
	}
	
	private int compare(T a, T b) {
		return comparator.compare(a, b);
	}
}