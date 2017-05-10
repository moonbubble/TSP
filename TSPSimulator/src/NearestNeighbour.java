import java.util.ArrayList;

public class NearestNeighbour implements Functies {
	private ArrayList<Product> order;
	private ArrayList<Product> route;
	private String beginPunt;
	private String volgendePunt;
	private int stappen;
	private Product goeie;
	private int temp;

	public NearestNeighbour(Order order) {
		this.order = order.getOrder();
		route = new ArrayList<Product>();
	}

	public void voegProductToeAanRoute(Product p) {
		this.route.add(p);
	}

	public void printRoute() {
		System.out.println("--- ROUTE ---");
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

	public void routeBerekenen(Product bp, Product vp) {
		beginPunt = bp.getLocatie();
		volgendePunt = vp.getLocatie();
		String[] output1 = beginPunt.split("-");
		String[] output2 = volgendePunt.split("-");
		int posX1 = Integer.parseInt(output1[0]);
		int posY1 = Integer.parseInt(output1[1]);
		int posX2 = Integer.parseInt(output2[0]);
		int posY2 = Integer.parseInt(output2[1]);
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
		stappen = difX + difY;
//		System.out.println("aantal stappen = " + stappen);
	}

	public void algoritme() {
		goeie = order.get(0);
		while (order.size() > 0) {
			voegProductToeAanRoute(goeie);
			order.remove(goeie);
			Product kruisje = goeie;
			System.out.println(
					"(" + kruisje.getLocatie() + ") toegevoegd aan route en verwijderd uit order");
			temp = 1000;
			printRoute();
			printOrder();
			for (int i = 0; i < order.size(); i++) {
				Product rondje = order.get(i);
				routeBerekenen(kruisje, rondje);
				if (stappen < temp) {
					temp = stappen;
					goeie = rondje;
				}
			}

		}
		// voegProductToeAanRoute(goeie);
		// order.remove(goeie);
		// System.out.println(goeie.getLocatie() + " toegevoegd aan route en
		// verwijderd uit order");
		// printRoute();
		// printOrder();

		// int kortsteAantal = 1000;
		// for (int i = 0; i < order.size(); i++) {
		// Product ditProduct = route.get(route.size() - 1);
		// routeBerekenen(ditProduct, order.get(0)); //dit order.get(0) klopt
		// niet denk ik
		// if (stappen < kortsteAantal) {
		// kortsteAantal = stappen;
		// System.out.println(kortsteAantal);
		// voegProductToeAanRoute(order.get(i)); // die order.get(i) klopt ook
		// niet
		// order.remove(i);
		// }
		// }
		// printRoute();
	}

	// public void algoritme() {
	// voegProductToeAanRoute(order.get(0));
	// order.remove(0);
	// int kortsteAantal = 1000;
	// for (int i = 0; i < order.size(); i++) {
	// Product ditProduct = route.get(route.size() - 1);
	// routeBerekenen(ditProduct, order.get(0)); //dit order.get(0) klopt niet
	// denk ik
	// if (stappen < kortsteAantal) {
	// kortsteAantal = stappen;
	// System.out.println(kortsteAantal);
	// voegProductToeAanRoute(order.get(i)); // die order.get(i) klopt ook niet
	// order.remove(i);
	// }
	// }
	// printRoute();
	// }
}
