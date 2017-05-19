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
		for (Product p : route) {
			System.out.println(p.getLocatie());
		}
	}

	public void printOrder() {
		for (Product p : orderList)
		{
			System.out.println(p.getLocatie());
		}
	}

	private int routeBerekenen(Product bp, Product vp) {
		stappen = bp.meetAfstand(vp);
		return stappen;
	}
	
	public ArrayList<Product> algoritme() {
		printOrder();
		goeie = orderList.get(0);
		while (orderList.size() > 0) {
			voegProductToeAanRoute(goeie);
			orderList.remove(goeie);
			Product kruisje = goeie;
//			System.out.println(
//					"(" + kruisje.getLocatie() + ") toegevoegd aan route en verwijderd uit order");
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
