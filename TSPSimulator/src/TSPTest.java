
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
	}

}
