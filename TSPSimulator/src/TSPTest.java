
public class TSPTest {

	public static void main(String[] args) {
//		
//		Product s = new Product(1, 4);
//		Product v = new Product(1, 2);
//		Product a = new Product(1, 1);
//		Product c = new Product(1, 5);
//		Product r = new Product(1, 3);
//		Product q = new Product(2, 5);
//		Product t = new Product(5, 4);
//		Product u = new Product(3, 2);
//		Product a1 = new Product( 2, 5);
//		Product a2 = new Product( 4, 3);
//		Product a3 = new Product( 2, 2);
//		Product a4 = new Product( 5, 1);
//		Product a5 = new Product(4, 2);
//		Product a6 = new Product(2, 1);
//		
//		Order fietsen = new Order();
//		fietsen.voegProductToe(s);
//		fietsen.voegProductToe(v);
//		fietsen.voegProductToe(a);
//		fietsen.voegProductToe(c);
//		fietsen.voegProductToe(r);
//		Order speeltuin = new Order();
//		speeltuin.voegProductToe(r);
//		speeltuin.voegProductToe(q);
//		speeltuin.voegProductToe(t);
//		speeltuin.voegProductToe(u);
//		Order konijn = new Order();
//		konijn.voegProductToe(a1);
//		konijn.voegProductToe(a2);
//		konijn.voegProductToe(a3);
//		konijn.voegProductToe(a4);
//		konijn.voegProductToe(a5); 
//		konijn.voegProductToe(a6);
		
		Product a1 = new Product("a", 2, 5);
		Product b2 = new Product("b", 4, 3);
		Product c3 = new Product("c", 2, 2);
		Product d4 = new Product("d", 5, 1);
		Product e5 = new Product("e", 4, 2);
		Product f6 = new Product("f", 2, 1);
		Order maan = new Order();
		maan.voegProductToe(a1);
		maan.voegProductToe(b2);
		maan.voegProductToe(c3);
		maan.voegProductToe(d4);
//		maan.voegProductToe(e5);
//		maan.voegProductToe(f6);
		NewBruteForce nbf = new NewBruteForce(maan);
//		nbf.getTotaal();
		nbf.algoritme();
//		nbf.getAfstand();
		
//		//aco zooi
//		AntColonyOptimization driver = new AntColonyOptimization(konijn);
//		driver.algoritme();
//		
//		//brute force zooi
//		BruteForce bf = new BruteForce(konijn);
//		bf.algoritme();

	}

}
