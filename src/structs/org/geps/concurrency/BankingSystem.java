package org.geps.concurrency;
//T the type of resource in the system
public class BankingSystem<T> {
	
	//These four arrays manage the available, maximum, allocated and projected resource use of threads
	//In all but available resources the first index is the thread number in the process resource stack
	//The second one is the resource type id the value is always a resource quantity.
	public int[] availableResources;
	
	public int[][] rightsToResources;
	
	public int[][] allocatedResources;
	
	public int[][] projectedNeeds;
	
	public Hashtable<Long, Integer> threads;
	
	public BankingSystem() {
		threads = new Hashtable();
	}
	
	//Init thread in system
	public void initThread(Thread t, int[][] projectedNeeds) {
		
	}
	
	//Supposed to be called whenever a new resource is asked
	public void requestResources(Thread t, int claim) {
		
	}
}