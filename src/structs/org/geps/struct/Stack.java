package org.geps.struct;
//This implementation is only better if the cost of resizing an array is lower than adding new objects to a list and keeping them in memory
public class Stack<T> {
	
	private Entry first;
	
	private Entry last;
	
	private int count;
	
	public Stack() {
	}
	
	public Stack(Collection<T> addAll) {
		for(T t : addAll) {
			push(t);
		}
	}
	
	public void push(T t) {
		if(first = null) {
			first = new Entry<T>(t, null);
			last = first;
		} else {
			last = new Entry<T>(t, last);
		}
		count++;
	};
	
	public T pop() {
		Entry<T> ret = peek();
		last = last.parent;
		count--;
		return ret;
	}

	public T peek() {
		return last;
	}
	
	public class Entry<T> {
		T item;
		Entry parent;
		public Entry(T item, Entry next) {
			this.item = item;
			this.parent = next;
		}
	}
	
	public int size() {
		return count;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getLast() {
		return last;
	}
}