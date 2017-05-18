package tspScherm;
import java.util.ArrayList;

public class NearestNeighbour implements Functies {
	private ArrayList<Product> orderList;
	private ArrayList<Product> route;
	private int stappen;
	private Product goeie;
	private int temp;

	public NearestNeighbour(ArrayList<Product> orderList) {
		this.orderList = orderList;
		route = new ArrayList<Product>();
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
		for (Product p : orderList) {
			System.out.println(p.getLocatie());
		}
	}

	private int routeBerekenen(Product bp, Product vp) {
		stappen = meetAfstand(bp, vp);
		System.out.println("aantal stappen naar " + vp.getLocatie() + " = " + stappen);
		return stappen;
	}

	private int meetAfstand(Product product1, Product product2) {
		int deltaLongitude = 0;
		int deltaLatitude = 0;
		if (product2.getY() > product1.getY()) {
			deltaLongitude = (product2.getY() - product1.getY());
		} else {
			deltaLongitude = (product1.getY() - product2.getY());
		}
		
		if (product2.getX() > product1.getX()) {
			deltaLatitude = (product2.getX() - product1.getX());
		} else {
			deltaLatitude = (product1.getX() - product2.getX());
		}
		return deltaLongitude + deltaLatitude;
	}
	
	public ArrayList<Product> algoritme() {
		printOrder();
		goeie = orderList.get(0);
		while (orderList.size() > 0) {
			voegProductToeAanRoute(goeie);
			orderList.remove(goeie);
			Product kruisje = goeie;
			System.out.println(
					"(" + kruisje.getLocatie() + ") toegevoegd aan route en verwijderd uit order");
			temp = 1000;
			for (int i = 0; i < orderList.size(); i++) {
				Product rondje = orderList.get(i);
				routeBerekenen(kruisje, rondje);
				if (stappen < temp) {
					temp = stappen;
					goeie = rondje;
				}
			}
		}
		return route;
	}
}
