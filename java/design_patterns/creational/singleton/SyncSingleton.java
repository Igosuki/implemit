package creational.singleton;

/**
 * Synchronized singleton
 */
public class SyncSingleton {
	
	private SyncSingleton instance;
	
	private SyncSingleton(){
	}
	
	public synchronized SyncSingleton getInstance(){
		if(instance == null){
			instance = new SyncSingleton(); 
		} 
		return instance;
	}
}



