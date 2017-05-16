import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	final static boolean VERBOSE_FLAG = false;
	private static ArrayList<Product> initialRoute = new ArrayList<Product>(Arrays.asList(
			new Product("a", 2, 5),
			new Product("b", 4, 3), 
			new Product("c", 2, 2), 
			new Product("d", 5, 1)
			));

	public static void main(String[] args) {

		Driver driver = new Driver();
		Instant startInstant = Instant.now();
		BruteForce bruteForce = new BruteForce();
		Route currentRoute = new Route(initialRoute);
		if (VERBOSE_FLAG) {
			driver.printHeading("Route", "Distance (in miles)   |   Shortest Distance   |    Permutation #");
		} else {
			System.out.println("permutations in progress ...");
		}
		driver.printResults(bruteForce, bruteForce.permuteProducts(0, currentRoute, new Route(currentRoute)));
		
		driver.printDuration(startInstant);
	}
	
	public void printDuration(Instant startInstant) {
		Duration permutationDuration = Duration.between(startInstant, Instant.now());
		long minutes = permutationDuration.toMinutes();
		long seconds = permutationDuration.getSeconds();
		if (seconds > 59) {
			long tempSeconds = seconds - 60*minutes;
			long tempMilliseconds = permutationDuration.toMillis() - seconds*1000;
			System.out.println("Duration: " + minutes + " minutes " + tempSeconds + " seconds " + tempMilliseconds + " milliseconds " + "(" + permutationDuration + ")");
		} else if (seconds > 0) {
			long tempmilliseconds = permutationDuration.toMillis() - seconds*1000;
			System.out.println("Duration: " + seconds + " seconds " + tempmilliseconds + " milliseconds " + "(" + permutationDuration);
		} else {
			System.out.println("Duration: " + permutationDuration.toMillis() + " milliseconds ("+ permutationDuration + ")");
		}
	}
	public void printResults(BruteForce bruteForce, ArrayList<Route> shortestRoutes) {
		if (VERBOSE_FLAG) {
			System.out.println("");
		}
		printHeading("ShortestRoute ", "Distance (in miles)");
		shortestRoutes.stream().forEach(x -> System.out.println(x + " | " + bruteForce.getTotaleAfstand(x)));
	}
	public void printHeading(String headingColumn1, String remainingHeadingColumns) {
		int productNaamLengte = 0;
		for (int i = 0; i < initialRoute.size(); i++) {
			productNaamLengte += initialRoute.get(i).getNaam().length();
		}
		int lijstLengte = productNaamLengte + + initialRoute.size()*2;
		int gedeeltelijkeLengte = (lijstLengte - headingColumn1.length())/2;
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
