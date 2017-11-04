package creational.absfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Factory pattern client
 */
public class Client {
	public void doThing() {
		List<Table> tables = new ArrayList<Table>();
		List<List<Chair>> chairs = new ArrayList<List<Chair>>();
		
		AbstractFurnitureFactory factory1 = getFactory(1);
		tables.add(factory1.createTable());
		chairs.add(factory1.createChairs());
		AbstractFurnitureFactory factory2 = getFactory(2);
		tables.add(factory2.createTable());
		chairs.add(factory2.createChairs());
		for (List<Chair> list : chairs) {
			for (Chair chair : list) {
				System.out.println("This is a "+chair.getType()+" chair");
			}
		}
		for (Table table : tables) {
			System.out.println("This table has "+String.valueOf(table.getFeet())+" feet");
		}
	}
	
	AbstractFurnitureFactory getFactory(int i) {
		switch (i) {
			case 1:
				return new NiceFurnitureFactory();
			default:
				return new CheapFurnitureFactory();
		}
	}
}



