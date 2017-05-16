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
		int orderGrootte = route.getOrder().size();	
		return (int) (route.getOrder().stream().mapToDouble(x -> {
			int productIndex = route.getOrder().indexOf(x);
			double returnValue = 0;
			if (productIndex < orderGrootte - 1) returnValue = x.meetAfstand(route.getOrder().get(productIndex + 1));
			return returnValue;
		}).sum() + route.getOrder().get(0).meetAfstand(route.getOrder().get(orderGrootte - 1)));
	}
	public String getTotaleAfstand(Route route) {
		String returnValue = Integer.toString(berekenTotaleAfstand(route));
		if (returnValue.length() == 4) returnValue = " " + returnValue;
		else if (returnValue.length() == 3) returnValue = " " + returnValue;
		return returnValue;
	}
	public void voegToeAanKortsteRoutes(Route route) {
		shortestRoutes.removeIf(x -> (int)berekenTotaleAfstand(x) > (int)berekenTotaleAfstand(route));
		shortestRoutes.add(route);
	}
}
