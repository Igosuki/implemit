package creational.builder;

/**
 * 
 */
public class BuilderFactory {

	/**
	 * @param nextPart
	 */
	public Builder getBuilder(Part nextPart) {
		if(nextPart instanceof PartType1) {
			return new Product1Builder();
		} else if(nextPart instanceof PartType2){
			return new Product2Builder();
		}
		return null;
	}
	
}



