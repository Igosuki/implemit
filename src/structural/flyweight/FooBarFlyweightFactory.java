package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete FooFlyweightFactory
 */
public class FooBarFlyweightFactory implements FooFlyweightFactory {

	private Map<String, FooBarFlyweight> flyweightData = new HashMap<String, FooBarFlyweight>();
	
	/**
	 * Cf Méthode surchargée
	 * @see structural.flyweight.FooFlyweightFactory#getFlyweight(java.lang.String)
	 * {@inheritDoc}
	 */
	@Override
	public FooFlyweight getFlyweight(String key) {
		FooFlyweight returnValue;
		if ((returnValue = flyweightData.get(key)) != null){
			return returnValue;
		} else {
			return new FooBarFlyweight();
		}
	}
	
	private FooBarFlyweightFactory(){
		
	}
	
	private static FooBarFlyweightFactory instance;
	
	public static FooBarFlyweightFactory getInstance(){
		if(instance == null){
			 instance = new FooBarFlyweightFactory();
		}
		return instance;
	}
}



