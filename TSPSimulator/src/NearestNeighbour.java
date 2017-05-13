import java.util.ArrayList;

public class NearestNeighbour implements Functies {
	private ArrayList<Product> order;
	private ArrayList<Product> route;
	private ArrayList<Product> bezocht;
	private int stappen;
	private Product goeie;
	private int temp;

	public NearestNeighbour(Order order) {
		this.order = order.getOrder();
		route = new ArrayList<Product>();
		bezocht = new ArrayList<Product>();
	}

	public void voegProductToeAanRoute(Product p) {
		this.route.add(p);
	}

	public void printRoute() {
		System.out.println("--- NEARESTNEIGHBOUR ROUTE ---");
		for (Product p : route) {
			System.out.println(p.getLocatie());
		}
	}

	public void printOrder() {
		System.out.println("--- ORDER ---");
		for (Product p : order) {
			System.out.println(p.getLocatie());
		}
	}

	public int routeBerekenen(Product bp, Product vp) {
		int posX1 = bp.getX();
		int posY1 = bp.getY();
		int posX2 = vp.getX();
		int posY2 = vp.getY();
		int difX = 0;
		int difY = 0;
		if (posX1 > posX2) {
			difX = posX1 - posX2;
//			System.out.println(difX + " naar links");
		} else if (posX1 < posX2) {
			difX = posX2 - posX1;
//			System.out.println(difX + " naar rechts");
		}

		if (posY1 > posY2) {
			difY = posY1 - posY2;
//			System.out.println(difY + " naar beneden");
		} else if (posY1 < posY2) {
			difY = posY2 - posY1;
//			System.out.println(difY + " naar boven");
		}
		return stappen = difX + difY;
//		System.out.println("aantal stappen = " + stappen);
	}

	public void algoritme() {
		printOrder();
		goeie = order.get(0);
		while (order.size() > 0) {
			voegProductToeAanRoute(goeie);
			order.remove(goeie);
			Product kruisje = goeie;
//			System.out.println(
//					"(" + kruisje.getLocatie() + ") toegevoegd aan route en verwijderd uit order");
			temp = 1000;
			for (int i = 0; i < order.size(); i++) {
				Product rondje = order.get(i);
				routeBerekenen(kruisje, rondje);
				if (stappen < temp) {
					temp = stappen;
					goeie = rondje;
				}
			}
		}
		printRoute();
	}
}
