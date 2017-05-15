package tspScherm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML
{
	private Order order;
	private ArrayList<Product> orderList;
	
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document document;
	
	public Order getData(File file) throws ParserConfigurationException, SAXException, IOException
	{
		dbf = DocumentBuilderFactory.newInstance();
		
		db = dbf.newDocumentBuilder();
		document = db.parse(file);

		NodeList nList = document.getElementsByTagName("bestelling");
		NodeList aList = document.getElementsByTagName("artikelnr");

		 for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					Klant k = new Klant(
							(eElement.getElementsByTagName("voornaam").item(0).getTextContent()),
							(eElement.getElementsByTagName("achternaam").item(0).getTextContent()),
							(eElement.getElementsByTagName("adres").item(0).getTextContent()),
							(eElement.getElementsByTagName("postcode").item(0).getTextContent()),
							(eElement.getElementsByTagName("plaats").item(0).getTextContent())
							);
					order = new Order(
							Integer.parseInt((eElement.getElementsByTagName("ordernummer").item(0).getTextContent())),
							(eElement.getElementsByTagName("datum").item(0).getTextContent()),
							k
							);
					for (int a = 0; a < aList.getLength(); a++) {
						artikelnummer = artikelnummer + (aList.item(a).getTextContent());
						System.out.println(artikelnummer);
					}
				}
		 }
		 return order;
	}
	
	public ArrayList<Product> getDatabase(File file)
	{
		dbf = DocumentBuilderFactory.newInstance();
		
		db = dbf.newDocumentBuilder();
		document = db.parse(file);

		NodeList aList = document.getElementsByTagName("artikelnr");

		for (int a = 0; a < aList.getLength(); a++) {
			artikelnummer = artikelnummer + (aList.item(a).getTextContent());
			System.out.println(artikelnummer);
		}
		 
		return orderList;
	}
}
