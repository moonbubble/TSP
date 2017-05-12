package tspScherm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TspGraphic extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public TspGraphic()
	{
		this.setPreferredSize(new Dimension(750,455));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(false);
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
