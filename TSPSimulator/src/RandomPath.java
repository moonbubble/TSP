import java.util.ArrayList;
import java.util.Collections;

public class RandomPath implements Functies {
	private ArrayList<Product> order;
	private ArrayList<Product> route;

	public RandomPath(Order order) {
		this.order = order.getOrder();
		route = new ArrayList<Product>();
	}

	public RandomPath() {
		order = new ArrayList<Product>();
		route = new ArrayList<Product>();
	}

	@Override
	public void voegProductToeAanRoute(Product p) {
		this.route.add(p);
	}

	@Override
	public void printRoute() {
		System.out.println("--- ROUTE ---");
		for (Product p : route) {
			System.out.println(p.getLocatie());
		}
	}

	@Override
	public void printOrder() {
		System.out.println("--- ORDER ---");
		for (Product p : order) {
			System.out.println(p.getLocatie() );
		}
	}

	public int getRandom(int min, int max) {
		double randomDouble = Math.floor(Math.random() * (max - min)) + min;
		int randomInt = (int) randomDouble;
		return randomInt;
	}

	public Product maakRandomProduct() {
		int x = getRandom(1, 6);
		int y = getRandom(1, 6);
		// System.out.println("(" + x + ", " + y + ")");
		Product p = new Product(x, y);
		return p;
	}
	
	public void vergelijken(Product pro) {
		if (order.size() > 0) {
			for (int l = 0; l < order.size(); l++) { //doorloop de order
				int vergelijkX = order.get(l).getX(); //de locatie van een bepaalde index van de order
				int vergelijkY = order.get(l).getY();
				String vergelijkLocatie = order.get(l).getLocatie();
				while (pro.getX() == vergelijkX && pro.getY() == vergelijkY) {
//					System.out.println(pro.getX() + " | " + vergelijkX + " ||| " + pro.getY() + " | " + vergelijkY + " is gelijk");
					pro = maakRandomProduct();
//					System.out.println(pro.getX() + " | " + vergelijkX + " ||| " + pro.getY() + " | " + vergelijkY + " is lekker niet gelijk");
					System.out.println("	2e check: " + vergelijkLocatie + " is " + pro.getLocatie() + " geworden.");
				} 
			}
		}
	}

	public Order maakOrder(int aantalItems) {
		Order ord = new Order();
		for (int i = 0; i < aantalItems; i++) {
			Product pro = maakRandomProduct(); // maak één random product aan
			if (ord.getOrder().size() > 0) {
				for (int j = 0; j < ord.getOrder().size(); j++) { //doorloop de order
					int vergelijkX = ord.getOrder().get(j).getX(); //de locatie van een bepaalde index van de order
					int vergelijkY = ord.getOrder().get(j).getY();
					String vergelijkLocatie = ord.getOrder().get(j).getLocatie();
					while (pro.getX() == vergelijkX && pro.getY() == vergelijkY) {
//						System.out.println(pro.getX() + " | " + vergelijkX + " ||| " + pro.getY() + " | " + vergelijkY + " is gelijk");
						pro = maakRandomProduct();
//						System.out.println(pro.getX() + " | " + vergelijkX + " ||| " + pro.getY() + " | " + vergelijkY + " is lekker niet gelijk");
						System.out.println("1e check: " + vergelijkLocatie + " is " + pro.getLocatie() + " geworden.");	
					} 
				}
			}
			ord.getOrder().add(pro);
		}
		ord.printOrder();
		return ord;
	}

	public void algoritme() {
		while (order.size() > 0) {
			for (int i = 0; i < order.size(); i++) {
				voegProductToeAanRoute(order.get(0));
				order.remove(order.get(0));
			}
		}
		Collections.shuffle(route);
		printRoute();
	}

}
