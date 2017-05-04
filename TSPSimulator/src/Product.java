
public class Product {
	private int x;
	private int y;
	private int grootte;
	
	public Product(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Product(int x, int y, int grootte) {
		this.x = x;
		this.y = y;
		this.grootte = grootte;
		System.out.println("Grootte: " + grootte);
	}
	
	public String getLocatie() {
		return "De locatie is: " + x + "." + y;
	}
}
