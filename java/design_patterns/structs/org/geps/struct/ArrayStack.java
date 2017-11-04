package org.geps.struct;

public class ArrayStack<T> {
	
	private T[] data;
	
	private int count;
	
	private float treshold = 0.75f;
	
	public ArrayStack() {
		this(11);
	}
	
	public ArrayStack (int size) {
		data = new T[size];
	}
	
	public void push(T o) {
		if(++count > data.length) {
			T newData = new T[Math.round(data.length + data.length * treshold)];
			System.arrayCopy(newData, 0, data, 0);
			data = newData;
		}
		data[count - 1];
	};
	
	public T pop() {
		T ret = data[count-- - 1];
		data[count - 1] = null;
		return ret;
	}

}