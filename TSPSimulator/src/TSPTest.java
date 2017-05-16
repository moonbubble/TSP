
public class TSPTest {

	public static void main(String[] args) {
		Product s = new Product(1, 4);
		Product v = new Product(1, 2);
		Product a = new Product(1, 1);
		Product c = new Product(1, 5);
		Product r = new Product(1, 3);
		Product q = new Product(2, 5);
		Product t = new Product(5, 4);
		Product u = new Product(3, 2);
		
		Product a1 = new Product("a", 2, 5);
		Product a2 = new Product("b", 4, 3);
		Product a3 = new Product("c", 2, 2);
		Product a4 = new Product("d", 5, 1);
//		Product a5 = new Product(4, 2);
//		Product a6 = new Product(2, 1);
		
		int distance1to2 = a2.meetAfstand(a1);
		System.out.println(distance1to2);
		

		Order fietsen = new Order();
		fietsen.voegProductToe(s);
		fietsen.voegProductToe(v);
		fietsen.voegProductToe(a);
		fietsen.voegProductToe(c);
		fietsen.voegProductToe(r);

		Order speeltuin = new Order();
		speeltuin.voegProductToe(r);
		speeltuin.voegProductToe(q);
		speeltuin.voegProductToe(t);
		speeltuin.voegProductToe(u);
		
		Order konijn = new Order();
		konijn.voegProductToe(a2);
		konijn.voegProductToe(a1);
		konijn.voegProductToe(a4);
		konijn.voegProductToe(a3);
//		konijn.voegProductToe(a5); 
//		konijn.voegProductToe(a6);
		
		//brute force zooi
//		konijn.printOrder();
//		BruteForce idee = new BruteForce(konijn);
//		idee.algoritme();
		
		// fietsFabriek.printOrder();

		// System.out.println("Het aantal producten in deze order is: " +
		// fietsFabriek.telAantalProducten());
		
		// randompath zooi
//		RandomPath rp1 = new RandomPath();
//		Order random = rp1.maakOrder(6);
//		random.printOrder();
		NearestNeighbour n7 = new NearestNeighbour(konijn);
		n7.algoritme();
//		OptExchange n6 = new OptExchange(fietsen);
//		n6.algoritme();
//		rp1.buurmanMol("gooi hem eruit");
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
