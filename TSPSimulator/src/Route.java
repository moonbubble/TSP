import java.util.ArrayList;
import java.util.Arrays;

public class Route {
	private ArrayList<Product> order = new ArrayList<Product>();
	public Route(ArrayList<Product> initialRoute) {
		setOrder(initialRoute);
	}
	public Route (Route route) {
		route.order.stream().forEach(x -> order.add(x));
	}
	public ArrayList<Product> getOrder() {
		return order;
	}
	
	public void setOrder(ArrayList<Product> order) {
		this.order = order;
	}
	
	public String toString() {
		return Arrays.toString(order.toArray());
	}
	
}
