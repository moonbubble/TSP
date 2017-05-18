//import java.time.Duration;
//import java.time.Instant;
import java.util.ArrayList;
//import java.util.Arrays;

public class Driver {
	private static ArrayList<Product> initialRoute;
	
//	final static boolean VERBOSE_FLAG = false;
	
	public Driver(Order order) {
		Driver.initialRoute = order.getOrder();
	}
	
	public static void main(String[] args) {
		Product a1 = new Product("a", 2, 5);
		Product a2 = new Product("b", 4, 3);
		Product a3 = new Product("c", 2, 2);
		Product a4 = new Product("d", 5, 1);
		Product a5 = new Product("e", 5, 5);
		Order konijn = new Order();
		konijn.voegProductToe(a1);
		konijn.voegProductToe(a2);
		konijn.voegProductToe(a3);
		konijn.voegProductToe(a4);
		konijn.voegProductToe(a5);
		Product b1 = new Product(3, 2);
		Product b2 = new Product(5, 4);
		Product b3 = new Product(2, 1);
		Product b4 = new Product(1, 3);
		Order banaan = new Order();
		banaan.voegProductToe(b1);
		banaan.voegProductToe(b2);
		banaan.voegProductToe(b3);
		banaan.voegProductToe(b4);
//		Driver driver = new Driver(konijn);
		Driver driver = new Driver(banaan);
		BruteForce bruteForce = new BruteForce();
		Route currentRoute = new Route(initialRoute);
		driver.ontvangRoute(bruteForce, bruteForce.permuteProducts(0, currentRoute, new Route(currentRoute)));
//		driver.printResults(bruteForce, bruteForce.permuteProducts(0, currentRoute, new Route(currentRoute)));
		
	}
	public ArrayList<Product> ontvangRoute(BruteForce bruteForce, ArrayList<Route> shortestRoutes) {
		int index = 0;
		ArrayList<Product> route = new ArrayList<Product>();
		for (Route r : shortestRoutes) {
			if(index == 0) {
				route = r.getOrder();
			}
//			System.out.println((index++) + ": " + r);
		}
//		System.out.println(route + " | " + bruteForce.getTotaleAfstand(shortestRoutes.get(0)));
		return route;
	}
	

}
