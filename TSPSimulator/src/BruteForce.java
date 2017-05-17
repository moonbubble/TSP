import java.util.ArrayList;
import java.util.Collections;

public class BruteForce {
	static int permutationNumb = 1;
	ArrayList<Route> shortestRoutes = new ArrayList<Route>();
	public ArrayList<Route> permuteProducts(int x, Route currentRoute, Route shortestRoute) {
		currentRoute.getOrder().stream().filter(y -> currentRoute.getOrder().indexOf(y) >= x).forEach(y -> {
			int indexOfY = currentRoute.getOrder().indexOf(y);
			Collections.swap(currentRoute.getOrder(), indexOfY, x);
			permuteProducts(x + 1, currentRoute, shortestRoute);
			Collections.swap(currentRoute.getOrder(), x, indexOfY);
		});
		if (x == currentRoute.getOrder().size() - 1) {
			if (Driver.VERBOSE_FLAG) { 
				System.out.print(currentRoute + " |      " + getTotaleAfstand(currentRoute));
			}
			if ((int)berekenTotaleAfstand(currentRoute) <= (int)berekenTotaleAfstand(shortestRoute)) {
				shortestRoute.getOrder().clear();
				shortestRoute.getOrder().addAll(currentRoute.getOrder());
				voegToeAanKortsteRoutes(new Route(shortestRoute));
			}
			if (Driver.VERBOSE_FLAG) {
				System.out.println("      |    " + getTotaleAfstand(shortestRoute) + "     | " + permutationNumb++);
			}
		}
		return shortestRoutes;
	}

	public int berekenTotaleAfstand(Route route) {
		int orderGrootte = route.getOrder().size();	 // orderGrootte is hoeveel items er in de order zitten
		return (int) (route.getOrder().stream().mapToDouble(x -> { // DIT SNAP IK DUS NIET HELEMAAL
			int productIndex = route.getOrder().indexOf(x); //productIndex is de index van de order die bij item x van de order hoort
			int returnValue = 0; //returnvalue is 0 (dit was eerst een double)
			if (productIndex < orderGrootte - 1) { //als de index kleiner is dan de grootte van de order-1
				returnValue = x.meetAfstand(route.getOrder().get(productIndex + 1)); //returnvalue wordt de afstand vanaf item x tot het item dat na x in de order komt
			}
			return returnValue; 
		}).sum() 
//				+ route.getOrder().get(0).meetAfstand(route.getOrder().get(orderGrootte - 1)) //hier wordt de afstand gemeten tussen het eerste item uit de route en het laatste
						);
	}
	public String getTotaleAfstand(Route route) {  // wordt gewoon wat aan de value veranderd, namelijk een spatie
		String returnValue = Integer.toString(berekenTotaleAfstand(route));
		if (returnValue.length() == 1) returnValue = " " + returnValue;
		else if (returnValue.length() == 3) returnValue = " " + returnValue;
		return returnValue;
	}
	public void voegToeAanKortsteRoutes(Route route) {
		shortestRoutes.removeIf(x -> berekenTotaleAfstand(x) > berekenTotaleAfstand(route)); //als de totale afstand van x groter is dan de totale afstand van de route wordt  
			//eerst stond er removeIf(x -> (int)berekenTotaleAfstand(x) > (int)berekenTotaleAfstand(route))
		shortestRoutes.add(route);
	}
}
