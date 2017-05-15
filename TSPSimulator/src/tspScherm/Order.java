package tspScherm;

import java.util.ArrayList;

public class Order
{
	private int ordernr;
	private String datum;
	private ArrayList<Product> order;
	private Klant klant;
	
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
	
	public int getordernr()
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
