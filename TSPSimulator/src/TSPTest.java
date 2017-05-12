
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
		
		// randompath zooi
		RandomPath rp1 = new RandomPath();
		Order random = rp1.maakOrder(28);
//		NearestNeighbour n3 = new NearestNeighbour(random);
//		n3.nnAlgoritme();
		
//		
//		System.out.println();
//		// nearestneighbour zooi
//		RandomPath n1 = new RandomPath(fietsFabriek);
//		RandomPath n2 = new RandomPath(random);
//		n2.algoritme();
//		NearestNeighbour n4 = new NearestNeighbour(random);
//		n4.algoritme();
//		System.out.println("HIER KOMT HET ALGORITME ONDER");
//		n1.printOrder();
//		n1.algoritme();
//		System.out.println();
//		n2.algoritme();

	}

}
