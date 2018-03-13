package lab4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Sterowanie extends JPanel {
	JPanel pole1;
	JPanel pole2;
	JPanel pole3;
	JTabbedPane okienka;
	
	public Sterowanie()
	{
		super();
		this.setLayout(new BorderLayout());
		
		okienka = new JTabbedPane();
		pole1 = new JPanel(new FlowLayout());
		pole2 = new JPanel(new FlowLayout());
		pole3 = new JPanel(new FlowLayout());
		
		okienka.addTab("Opcje1", pole1);
		okienka.addTab("Opcje2", pole2);
		okienka.addTab("Opcje3", pole3);
		
		this.add(okienka);
		
	}
}
