
public class Product {
	private int x;
	private int y;
	
	public Product(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocatie() {
		return x + "." + y;
	}
}
