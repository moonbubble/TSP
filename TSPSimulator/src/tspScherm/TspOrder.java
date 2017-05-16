package tspScherm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class TspOrder extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JButton jbOpslaan;
	private JButton jbUpload;
	private JTextField jtRandom;
	private JButton jbRandom;
	private JPanel jpTable;
	
	final JFileChooser fc = new JFileChooser();
	
	public static int snelheid = 0;
	public static int aantalSimulaties = 1;
	public Order order;
	
	public TspOrder(JFrame frame)
    {
		super(frame, true);
        setTitle("TSP instellingen");
        this.setPreferredSize(new Dimension(700, 500));        
        setLayout(null);
        
        jbUpload = new JButton("Upload XML");
        jbUpload.setBounds(20, 20, 150, 40);
        jbUpload.addActionListener(this);
        add(jbUpload);
        
        jtRandom = new JTextField();
        jtRandom.setText("5");
        jtRandom.setBounds(450, 20, 50, 40);
        jtRandom.setFont(new Font("roboto", Font.PLAIN, 15));
        add(jtRandom);
        
        jbRandom = new JButton("Random punten");
        jbRandom.setBounds(510, 20, 150, 40);
        jbRandom.addActionListener(this);
        add(jbRandom);
        
        jpTable = new JPanel();
        jpTable.setBounds(20,80,640,300);
        jpTable.setLayout(new BorderLayout());
        add(jpTable);
        
        jbOpslaan = new JButton("Opslaan");
        jbOpslaan.setBounds(560, 400, 100, 40);
        jbOpslaan.addActionListener(this);
        add(jbOpslaan);
        
        pack();        
    }
	
	private void makeTable(Order o)
	{
		String[] columnNames = {"Artikelnr", "X", "Y", "Gewicht", "Naam"};
				
		String orderData[][] = new String[o.getOrder().size()][5];
		
		for(int i = 0; i < o.getOrder().size(); i++)
		{
			orderData[i][0] = "" + o.getOrder().get(i).getArtikelnr();
			orderData[i][1] = "" + o.getOrder().get(i).getX();
			orderData[i][2] = "" + o.getOrder().get(i).getY();
			orderData[i][3] = "" + o.getOrder().get(i).getGewicht();
			orderData[i][4] = o.getOrder().get(i).getNaam();
		}
		
		NonEditableModel tableModel = new NonEditableModel(orderData, columnNames);
		JTable table = new JTable(tableModel);
		
		table.getTableHeader().setFont(new Font("Roboto", Font.PLAIN, 15));
		table.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
		
		jpTable.add(table.getTableHeader(), BorderLayout.PAGE_START);
		jpTable.add(table, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	private Order makeRandomOrder(int a)
	{
		Order randomOrder = new Order();	
		
		while(randomOrder.getOrder().size() < a)
		{
			int artikelnr = (int)(Math.random() * 25);
			System.out.println(artikelnr);
			
			if(randomOrder.getOrder().size() == 0)
			{
				randomOrder.voegProductToe(new Product(
						Integer.parseInt(Main.database[artikelnr][0]),
						Integer.parseInt(Main.database[artikelnr][1]),
						Integer.parseInt(Main.database[artikelnr][2]),
						Integer.parseInt(Main.database[artikelnr][3]),
						Main.database[artikelnr][4]
						));
			}
			else
			{
				for()
			}
			
		}
		return randomOrder;
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
		if(e.getSource().equals(jbOpslaan))
    	{
    		setVisible(false);
    	}
		else if(e.getSource().equals(jbRandom))
		{
			int aantalPunten = Integer.parseInt(jtRandom.getText());
			order = makeRandomOrder(aantalPunten);
			makeTable(order);
		}
		else if (e.getSource() == jbUpload) {
	        int returnVal = fc.showOpenDialog(this);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            XML parser = new XML();
	            order = parser.getData(file);
	            makeTable(order);
	        }
	   }
    }
}
