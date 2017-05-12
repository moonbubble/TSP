package tspScherm;

import java.sql.Date;
import java.util.ArrayList;

public class Order
{
	private Date datum;
	private ArrayList<Product> order;
	private Klant klant;
	
	public Order(Date datum, Klant klant)
	{
		this.datum = datum;
		this.klant = klant;
	}
	
	public void voegProductToe(Product p)
	{
		order.add(p);
	}
	
	public ArrayList<Product> getOrder()
	{
		return order;
	}
	
	public Klant getKlant()
	{
		return klant;
	}
	
	public Date getDatum()
	{
		return datum;
	}
}
