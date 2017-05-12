package tspScherm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class TspOrder extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JButton jbOpslaan;
	private JButton jbUpload;
	private JTextField jtRandom;
	private JButton jbRandom;
	
	private Object orderData[][];
	private Order order;
	
	final JFileChooser fc = new JFileChooser();
	
	public static int snelheid = 0;
	public static int aantalSimulaties = 1;
	
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
                
        jbOpslaan = new JButton("Opslaan");
        jbOpslaan.setBounds(570, 400, 100, 40);
        jbOpslaan.addActionListener(this);
        add(jbOpslaan);
        
        pack();
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
		}
		else if (e.getSource() == jbUpload) {
	        int returnVal = fc.showOpenDialog(this);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	        }
	   }
    }
}
