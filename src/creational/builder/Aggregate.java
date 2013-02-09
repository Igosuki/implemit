package creational.builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */
public class Aggregate {
	private List<Object> content = new ArrayList<Object>();
	private Iterator<Object> contentPointer;
	public void addProducts(Collection<Product> products){
		for (Product product : products) {
			addProduct(product);
		}
	}
	
	/**
	 * 
	 */
	public void addProduct(Product product) {
		content.add(product.getContent());
	}

	public Object read(){
		if(contentPointer == null){
			contentPointer = content.iterator();
		}
		return contentPointer.next();
	}
}



