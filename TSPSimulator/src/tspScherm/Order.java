package tspScherm;

import java.util.ArrayList;

public class Order
{
	private int ordernr;
	private String datum;
	private ArrayList<Product> order = new ArrayList<>();
	private Klant klant;
	
	public Order()
	{
		this.ordernr = 999;
		this.datum = "01-01-2000";
		this.klant = new Klant("John", "Doe", "JohnDoeStreet 1", "1234 JD", "JohnDoeVille");
	}
	
	public Order(int ordernr, String datum, Klant klant)
	{
		this.ordernr = ordernr;
		this.datum = datum;
		this.klant = klant;
	}
	
	public void voegProductToe(Product p)
	{
		order.add(p);
	}
	
	public void setOrder(ArrayList<Product> o)
	{
		this.order = o;
	}
	
	public ArrayList<Product> getOrder()
	{
		return order;
	}
	
	public int getOrdernr()
	{
		return ordernr;
	}
	
	public Klant getKlant()
	{
		return klant;
	}
	
	public String getDatum()
	{
		return datum;
	}
}
