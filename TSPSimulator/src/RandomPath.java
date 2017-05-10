import java.util.ArrayList;

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
		System.out.println("--- RANDOM ORDER ---");
		for (Product p : order) {
			System.out.println(p.getLocatie());
		}
	}

	// public int getRandom() {
	// double randomDouble = Math.random();
	// randomDouble = randomDouble * 10;
	// int randomInt = (int)randomDouble;
	// if (randomInt == 0) {
	//
	// }
	// return randomInt;
	// }

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

	public Order maakOrder(int aantalItems) {
		Order o = new Order();
		for (int i = 0; i < aantalItems; i++) {
			Product pro = maakRandomProduct();
			o.voegProductToe(pro);
		}
		return o;
	}

	public void rpAlgoritme() {
		while (order.size() > 0) {
			for (int i = 0; i < order.size(); i++) {
				voegProductToeAanRoute(order.get(0));
				order.remove(order.get(0));
			}
		}
		printRoute();
	}

}
