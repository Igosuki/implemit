package creational.absfactory;
import java.util.List;

/**
 * Abstract Factory for abstract factory pattern
 */
public abstract class AbstractFurnitureFactory {
	
	public abstract Table createTable();
	public abstract List<Chair> createChairs();
}



