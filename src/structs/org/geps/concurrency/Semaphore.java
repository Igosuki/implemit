package org.geps.concurrency;

public class Semaphore<T extends Thread> {
	
	private int count;
	private LinkedList<T> l;
	
	public Semaphore() {
		
	}
	
	public synchronized init(int val) {
			this.count = val;
	}
	
	//Load-Linked/Store-Conditional
	public synchronized boolean addTask(T thread) {
		if(count == 0) {
			l.add(thread);
			thread.setSate(LOCKED);
		} else {
			count--;
		}
	}
	
	public synchronized void processQueue() {
		count++;
		if(!l.isEmpty()){
			T thread = l.first();
			l.removeFirst();
			thread.setState(READY);
		}
	}
}