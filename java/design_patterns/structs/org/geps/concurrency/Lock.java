package org.geps.concurrency;

public class Lock {
	//Pid of the acquiring thread
	private int pid;
	private boolean locked;
	public Lock(int pid) {
		this.pid = pid;
	}
	
	public int getPid() {
		return this.pid;
	}
	
	public synchronized setPid(int pid) {
		this.pid = pid;
	}
	
	public boolean isLocked() {
		return this.locked;
	}
	
	//Other way to lock/unlock is provide the pid too and just use the pid value as the lock value
	public void lock() {
		this.locked = true;
	}
	
	public void unlock() {
		this.locked = false;
	}
}