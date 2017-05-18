//import java.time.Duration;
//import java.time.Instant;
import java.util.ArrayList;
//import java.util.Arrays;

public class Driver {
	private static ArrayList<Product> initialRoute;
	
	final static boolean VERBOSE_FLAG = true;
	
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
		Driver driver = new Driver(konijn);
		BruteForce bruteForce = new BruteForce();
		Route currentRoute = new Route(initialRoute);
		if (VERBOSE_FLAG) {
			driver.printHeading("Route", "Afstand   |   Kortste Afstand   |    #");
		} else {
			System.out.println("in progress ...");
		}
		
		driver.printResults(bruteForce, bruteForce.permuteProducts(0, currentRoute, new Route(currentRoute)));
		
	}
	public void ontvangRoute(ArrayList<Route> shortestRoutes) {
		for (Route r : shortestRoutes) {
			System.out.println(r);
		}
	}
	
	public void printResults(BruteForce bruteForce, ArrayList<Route> shortestRoutes) {
		if (VERBOSE_FLAG) {
			System.out.println("");
		}
		printHeading("Kortste route ", "Afstand");
//		for (int i = 0; i < shortestRoutes.size(); i++) {
//			System.out.println(shortestRoutes.get(i) + " | " + bruteForce.getTotaleAfstand(shortestRoutes.get(i)));
//		}
		
		for(Route r : shortestRoutes) {
			System.out.println(r +" | " + bruteForce.getTotaleAfstand(r));
		}
		
//		shortestRoutes.stream().forEach(p -> System.out.println(p +" | " + bruteForce.getTotaleAfstand(p)));
	}
	public void printHeading(String headingColumn1, String remainingHeadingColumns) {
		int productNaamLengte = 0; // productnaamlengte = 0
		for (int i = 0; i < initialRoute.size(); i++) { // de initialRoute wordt doorlopen
			productNaamLengte += initialRoute.get(i).getNaam().length(); // productnaamlengte krijgt de lengte van de naam van het item i mee
		}
		int lijstLengte = productNaamLengte + initialRoute.size()*2; // lijstlengte productnaamlengte + het aantal items van initialRoute keer twee
		int gedeeltelijkeLengte = (lijstLengte - headingColumn1.length())/2; // gedeeltelijke lengte is de lijstlengte - de lengte van de headingcolumn en dat gedeeld door twee
		for (int i = 0; i < gedeeltelijkeLengte; i++) {
			System.out.print(" ");
		}
		System.out.print(headingColumn1);
		for (int i = 0; i < gedeeltelijkeLengte; i++) {
			System.out.print(" ");
		}
		if ((lijstLengte % 2) == 0) {
			System.out.println(" ");
		}
		productNaamLengte += remainingHeadingColumns.length() + 3;
		for (int i = 0; i < productNaamLengte + initialRoute.size()*2; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
