
public class Product {
	private int x;
	private int y;
	private String naam;
	
	public Product(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Product(String naam, int x, int y) {
		this.naam = naam;
		this.x = x;
		this.y = y;
	}
	
	public String getLocatie() {
		return x + "-" + y;
	}
	
	public int meetAfstand(Product product) {
		int deltaLongitude = 0;
		int deltaLatitude = 0;
		if (product.getY() > this.getY()) {
			deltaLongitude = (product.getY() - this.getY());
		} else {
			deltaLongitude = (this.getY() - product.getY());
		}
		
		if (product.getX() > this.getX()) {
			deltaLatitude = (product.getX() - this.getX());
		} else {
			deltaLatitude = (this.getX() - product.getX());
		}
		return deltaLongitude + deltaLatitude;
	}
	
	public Product xPlus(Product p) {
		int getal = x;
		getal++;
		int y = p.getY();
//		System.out.println(getal);
		Product pro = new Product(getal, y);
//		System.out.println("test: " + pro.getLocatie());
		return pro;
	}
	
	public Product yPlus(Product p) {
		int getal = y;
		getal++;
		int x = p.getX();
//		System.out.println(getal);
		Product pro = new Product(x, getal);
//		System.out.println("test: " + pro.getLocatie());
		return pro;
	}
	
	public Product xMin(Product p) {
		int getal = x;
		getal--;
		int y = p.getY();
		Product pro = new Product(getal, y);
//		System.out.println("test: " + pro.getLocatie());
		return pro;
	}
	
	public Product yMin(Product p) {
		int getal = y;
		getal--;
		int x = p.getX();
		Product pro = new Product(x, getal);
//		System.out.println("test: " + pro.getLocatie());
		return pro;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String getNaam() {
		return naam;
	}
}
