package org.geps.struct;

//
public abstract class BinaryHeap<Comparable<T>> {
	
	ArrayList<T> data;
	
	public BinaryHeap() {
		this(11);
	}
	public BinaryHeap(int originalSize) {
		data = new ArrayList<T>(originalSize);
	}
	
	public boolean add(Comparable<T> nodeVal) {
		//Add the node and then resort the tree
		data.add(nodeVal);
		int pos = data.size() - 1;
		while(pos > 0 && compare(nodeVal, data.get((pos - 1) / 2)) == -1) {
			pos = swap(data, pos, (pos -1) /2);
		}
		return true;
	}
	
	private int swap(ArrayList<T> data, int from , int to ) {
		T tmp = data.get(from);
		data.set(from, data.get(to));
		data.set(to, tmp);
		return to;
	}
	
	//Remove the root
	public T popRoot() {
		T root = data.get(0);
		//Replace the root with the last member and remove the member
		data.set(0, data.get(data.size() - 1));
		data.remove(data.get(data.size() - 1));
		//While the new root is -1 in compare to either of its roots, swap em
		int pos = 0;
		while(pos < data.size()) {
			//Examine left node
			if(pos * 2 + 1 < data.size() && compare(data.get(pos), data.get(pos * 2 + 1)) == -1) {
				pos = swap(data, pos, pos * 2 + 1);
				continue;
			}
			//Examine right node
			if(pos * 2 + 2 < data.size() && compare(data.get(pos), data.get(pos * 2 + 2)) == -1) {
				pos = swap(data, pos, pos * 2 + 2);
				continue;
			}
			//Both nodes compared without fault so the position of the node is ok, break.
			break;
		}
		return root;
	}
	
	public void prettyPrint(OutputStream out) {
		//The exercise is to print it so you actually have to traverse the tree
		
	}
	
	//This make it easy to create any kind of relation heap on the fly by specifying the key function
	public abstract int compare(Comparable<T> a, Comparable<T> b);
}
