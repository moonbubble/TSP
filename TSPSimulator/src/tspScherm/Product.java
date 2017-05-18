package tspScherm;

public class Product {
	private int x;
	private int y;
	private String naam;
	private int gewicht;
	private int artikelnr;
	private boolean visited;
	
	public Product(int artikelnr, int x, int y, int gewicht, String naam) {
		this.x = x;
		this.y = y;
		this.naam = naam;
		this.gewicht = gewicht;
		this.artikelnr = artikelnr;
		this.visited = false;
		
	}
	
	public void Visited()
	{
		this.visited = true;
	}
	
	public void resetVisited()
	{
		this.visited = false;
	}
	
	public String getLocatie() {
		return x + "-" + y;
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
	
	public int getGewicht() {
		return gewicht;
	}
	
	public int getArtikelnr() {
		return artikelnr;
	}
	
	public boolean getVisited()
	{
		return visited;
	}
	
	@Override
	public String toString()
	{
		return this.naam;
	}
}
