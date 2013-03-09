package org.geps.concurrency;

public class CompareAndSwap {
	
	private int[] data;
	
	public CompareAndSwap(int size) {
		this.data = new int[size];
	}
	
	public synchronized boolean compareAndSet(int index, int oldValue, int newValue) {
		if(data[i] == oldValue) {
			data[i] = newValue;
			return true;
		} else {
			data[i] = oldValue;
			return false;
		}
	}
	
	public synchronized int compareAndSwap(int index, int oldValue, int newValue) {
		int dataval = data[i];
		if(dataval == oldValue) {
			data[i] = newValue;
		}
		return dataval;
	}
}