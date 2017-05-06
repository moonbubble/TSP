
public class Product {
	private int x;
	private int y;
	
	public Product(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocatie() {
		return x + "-" + y;
	}
	
	public void xPlus() {
		int getal = x;
		getal++;
		System.out.println(getal);
	}
	
	public void yPlus() {
		int getal = y;
		getal++;
		System.out.println(getal);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
