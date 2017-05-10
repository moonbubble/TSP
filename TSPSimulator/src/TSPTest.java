
public class TSPTest {

	public static void main(String[] args) {
		Product s = new Product(1, 4);
		Product v = new Product(3, 3);
		Product a = new Product(2, 2);
		Product c = new Product(4, 5);
		Product r = new Product(4, 2);
		Product q = new Product(2, 5);
		Product t = new Product(5, 4);
		Product u = new Product(3, 2);

		Order fietsFabriek = new Order();
		fietsFabriek.voegProductToe(v);
		fietsFabriek.voegProductToe(a);
		fietsFabriek.voegProductToe(c);
		fietsFabriek.voegProductToe(s);

		Order speeltuin = new Order();
		speeltuin.voegProductToe(r);
		speeltuin.voegProductToe(q);
		speeltuin.voegProductToe(t);
		speeltuin.voegProductToe(u);

		// fietsFabriek.printOrder();

		// System.out.println("Het aantal producten in deze order is: " +
		// fietsFabriek.telAantalProducten());

		// nearestneighbour zooi
		NearestNeighbour n1 = new NearestNeighbour(fietsFabriek);
		NearestNeighbour n2 = new NearestNeighbour(speeltuin);
		System.out.println("HIER KOMT HET ALGORITME ONDER");
		n1.algoritme();
		System.out.println();
		n2.algoritme();
	}

}
