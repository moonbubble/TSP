package tspScherm;

import javax.swing.*;
import java.awt.*;

public class TspGraphic extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public TspGraphic()
	{
		this.setPreferredSize(new Dimension(750,455));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(false);
	}
	
    public void paintPoints(Order o)
    {
    	Graphics g = this.getGraphics();
    	Graphics2D gg = (Graphics2D) g;
    	gg.drawOval(100, 100, 100, 100);
    	/*
    	for(Product p : o.getOrder())
    	{
    		int x = 50 + (p.getX() * 130);
    		int y = 15 + (p.getY() * 85);
    		System.out.println("(" + x + "," + y + ")");
    		g.setColor(Color.BLUE);
    		g.drawOval(x, y, 50, 50);
    	}*/
    	this.repaint();
    }
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.gray);
		g.drawLine(50, 15, 50, 440);
		g.drawLine(700, 15, 700, 440);
		g.drawLine(50, 15, 700, 15);
		g.drawLine(50, 440, 700, 440);
		
		g.drawLine(180, 15, 180, 440);
		g.drawLine(310, 15, 310, 440);
		g.drawLine(440, 15, 440, 440);
		g.drawLine(570, 15, 570, 440);
		
		g.drawLine(50, 100, 700, 100);
		g.drawLine(50, 185, 700, 185);
		g.drawLine(50, 270, 700, 270);
		g.drawLine(50, 355, 700, 355);
	}
}
