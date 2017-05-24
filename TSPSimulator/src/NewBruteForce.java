import java.util.ArrayList;
import java.util.Collections;

public class NewBruteForce {
	
	private Order order;
	private int totaal;
	private int aantalProducten;
	private int afstand;
	private ArrayList<Product> snelsteRoute;
	private ArrayList<ArrayList<Product>> visitedRoutes = new ArrayList<ArrayList<Product>>();
	
	public NewBruteForce(Order order) {
		this.order = order;
		this.snelsteRoute = order.getOrder();
	}
	
	public ArrayList<Product> algoritme() {
		for (int i = 0; i < getTotaal(); i++) {
			createOrder();
		}
		System.out.println("snelste route = " + snelsteRoute);
		return snelsteRoute;
	}
	
	public int getAfstand(ArrayList<Product> o) {
		afstand = 0;
		for (int i = 0; i < aantalProducten - 1; i++) {
			afstand += o.get(i).meetAfstand(o.get(i + 1));
		}
		return afstand;
	}
	
	public ArrayList<Product> createOrder() {
		ArrayList<Product> newOrder = new ArrayList<>(order.getOrder());
		shuffleOrder(newOrder);
		while (visitedRoutes.contains(newOrder)) {
			Collections.shuffle(newOrder);
		}
		if (getAfstand(newOrder) < getAfstand(snelsteRoute)) {
			snelsteRoute = newOrder;
		}
		voegToeAanVisited(newOrder);
		return snelsteRoute;
	}
	
	public void voegToeAanVisited(ArrayList<Product> order) {
		visitedRoutes.add(order);
	}
	
	public ArrayList<Product> shuffleOrder(ArrayList<Product> order) {
		ArrayList<Product> shuffle = order;
		Collections.shuffle(shuffle);
		return shuffle;
	}
	
	public int getTotaal() {
		aantalProducten = order.getOrder().size();
		totaal = aantalProducten;
		for (int i = aantalProducten - 1; i > 1; i--) {
			totaal *= i;
		}
		return totaal;
	}
}
