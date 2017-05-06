
public class TSPTest {

	public static void main(String[] args) {
		Product s = new Product(1, 4);
		Product v = new Product(3, 3);
		Product a = new Product(2, 2);

		Order fietsFabriek = new Order();
		fietsFabriek.voegProductToe(s);
		fietsFabriek.voegProductToe(v);
		fietsFabriek.voegProductToe(a);

		fietsFabriek.printOrder();
		System.out.println("Het aantal producten in deze order is: " + fietsFabriek.telAantalProducten());

		// nearestneighbour zooi
		NearestNeighbour n1 = new NearestNeighbour("5-5", "1-1");
		n1.algoritme();
		// s.yPlus();
		// n1.splitString(s);
	}

}
