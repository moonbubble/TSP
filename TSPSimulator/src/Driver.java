import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
	static final int AANTAL_MIEREN = 500;
	static final double PROCESSING_CYCLE_PROBABILITY = 0.8;
	static ExecutorService eS = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	static ExecutorCompletionService<Mier> eCS = new ExecutorCompletionService<Mier>(eS);
	private Route shortestRoute = null;
	private int actieveMieren = 0;
	static ArrayList<Product> initialRoute = new ArrayList<Product>(Arrays.asList(
			new Product("a", 2, 5),
			new Product("b", 4, 3), 
			new Product("c", 2, 2), 
			new Product("d", 5, 1)));

	public static void main(String[] args) throws IOException {
		System.out.println("> " + AANTAL_MIEREN + " fake mieren ...");
		Driver driver = new Driver();
		driver.printHeading();
		AntColonyOptimization aco = new AntColonyOptimization();
//		System.out.println("> Driver.main: begin de loop...");
		for (int i = 1; i < AANTAL_MIEREN; i++) { 
//			System.out.println("\nDriver.main: eCS.submit(new Mier())"); 
			eCS.submit(new Mier(aco, i));
			driver.actieveMieren++;
//			System.out.println(i);
			if (Math.random() > PROCESSING_CYCLE_PROBABILITY) {
				driver.procesMieren();
			}
		}
		driver.procesMieren();
//		System.out.println("\n> Driver.main: eindig de loop...");
		eS.shutdownNow();
		System.out.println("\nOptimale Route : " + Arrays.toString(driver.shortestRoute.getOrder().toArray()));
		System.out.println("w/ Afstand   : " + driver.shortestRoute.getAfstand());
	}

	private void procesMieren() {
		while (actieveMieren > 0) {
//			System.out.println("Driver.main: eCS.take()");
			try {
				Mier mier = eCS.take().get();
				Route currentRoute = mier.getRoute();
				if (shortestRoute == null || currentRoute.getAfstand() < shortestRoute.getAfstand()) {
					shortestRoute = currentRoute;
					StringBuffer afstand = new StringBuffer(
							"      " + String.format("%.2f", currentRoute.getAfstand()));
					for (int i = 0; i < (20 - afstand.length()); i++) {
						afstand.append(" ");
					}
					System.out.println(Arrays.toString(shortestRoute.getOrder().toArray()) + "|" + afstand + "| "
							+ mier.getMierNumb());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			actieveMieren--;
		}
	}

	private void printHeading() {
		String headingColumn1 = "Route";
		String remainingHeadingColumns = "Afstand | mier #";
		int productNaamLengte = 0;
		for (int x = 0; x < initialRoute.size(); x++) {
			productNaamLengte += initialRoute.get(x).getNaam().length();
		}
		int lijstGrootte = productNaamLengte + initialRoute.size() * 2;
		int gedeeltelijkeLengte = (lijstGrootte - headingColumn1.length()) / 2;
		for (int x = 0; x < gedeeltelijkeLengte; x++) {
			System.out.print(" ");
		}
		System.out.print(headingColumn1);
		for (int i = 0; i < gedeeltelijkeLengte; i++) {
			System.out.print(" ");
		}
		if ((lijstGrootte % 2) == 0) {
			System.out.print(" ");
		}
		System.out.println(" | " + remainingHeadingColumns);
		productNaamLengte += remainingHeadingColumns.length() + 3;
		for (int i = 0; i < productNaamLengte + initialRoute.size() * 2; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
