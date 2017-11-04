package org.geps.concurrency;

public class ReentrantMutex {
	
	private int acquired;
	
	private Stack<Lock> locks;
	
	public ReentrantMutex() {
		this.locks = new Stack<Lock>();
	}
	
	public Lock acquire(int pid) {
		locks.push(new Lock(pid));
	}
}