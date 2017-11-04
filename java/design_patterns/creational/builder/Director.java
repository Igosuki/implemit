package creational.builder;

import java.util.Stack;

/**
 * Director for builder pattern
 */
public class Director {
	public Aggregate doBuild(Buildable item){
		BuilderFactory factory = new BuilderFactory();
		Part nextPart = item.getNextPart();
		Builder builder = factory.getBuilder(nextPart);
		Product buildPart = builder.buildPart(nextPart);
		Stack<Product> stackedBuild = new Stack<Product>();
		stackedBuild.push(buildPart);
		Aggregate agg = new Aggregate();
		agg.addProducts(stackedBuild);
		return agg;
	}
}



