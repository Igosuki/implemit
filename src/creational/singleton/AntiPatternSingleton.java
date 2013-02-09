package creational.singleton;

/**
 * Singleton in the form of the anti pattern
 */
public class AntiPatternSingleton {

	private AntiPatternSingleton instance;
	
	private AntiPatternSingleton(){
	}
	
	public AntiPatternSingleton getInstance(){
		synchronized(instance){
			if(instance == null){
				instance = new AntiPatternSingleton(); 
			} 
			return instance;
		}
	}

}



