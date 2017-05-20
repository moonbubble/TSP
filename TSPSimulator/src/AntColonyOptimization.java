import java.util.ArrayList;
import java.util.Random;

public class AntColonyOptimization {
	private AtomicDouble[][] feromoonLevelsMatrix = null;
	private double[][] afstandsMatrix = null;
	private ArrayList<Product> order = ACODriver.initialRoute;
	private int orderGrootte = ACODriver.initialRoute.size();
	
	public AntColonyOptimization(){
		initialiseerAfstanden();
		initialiseerFeromoonLevels();
	}
	
	public AtomicDouble[][] getFeromoonLevelsMatrix() {
		return feromoonLevelsMatrix;
	}

	public double[][] getAfstandsMatrix() {
		return afstandsMatrix;
	}
	private void initialiseerAfstanden(){
		afstandsMatrix = new double[orderGrootte][orderGrootte];
		for (int i = 0; i < orderGrootte; i++) {
			Product productY = order.get(i);
			for (int j = 0; j < orderGrootte; j++) {
				afstandsMatrix[i][j] = productY.meetAfstand(order.get(j)); // meet de afstand tussen de producten
			}
		}
	}
	private void initialiseerFeromoonLevels() {
		feromoonLevelsMatrix = new AtomicDouble[orderGrootte][orderGrootte];
		Random random = new Random();
		for (int i = 0; i < orderGrootte; i++) {
			for (int j = 0; j < orderGrootte; j++) {
				feromoonLevelsMatrix[i][j] = new AtomicDouble(random.nextDouble());  // initialiseer random de feromoonlevels
			}
		}
	}
}
