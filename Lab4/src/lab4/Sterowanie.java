package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Sterowanie extends JPanel {
	Plansza plansza;
	JPanel pole1;
	JSlider R, G, B;
	JLabel RLabel, GLabel, BLabel;
	JButton zatwierdz;
	Boolean linie;
	JPanel pole2;
	JPanel pole3;
	JTabbedPane okienka;
	
	public Sterowanie(Plansza plansza)
	{
		super();
		this.plansza = plansza;
		this.setLayout(new BorderLayout());
		
		okienka = new JTabbedPane();
		pole1 = new JPanel(new FlowLayout());
		pole1.setLayout(new GridLayout(5,1));
		
		R = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		R.addChangeListener(new RChangeListener());
		pole1.add(R, BorderLayout.PAGE_START);
		RLabel = new JLabel(String.format("Red: %d", R.getValue()));
		pole1.add(RLabel);
		
		G = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		G.addChangeListener(new GChangeListener());
		pole1.add(G, BorderLayout.PAGE_START);
		GLabel = new JLabel(String.format("Green: %d", G.getValue()));
		pole1.add(GLabel);
		
		B = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		B.addChangeListener(new BChangeListener());
		pole1.add(B, BorderLayout.PAGE_START);
		BLabel = new JLabel(String.format("Blue: %d", B.getValue()));
		pole1.add(BLabel);
		
		String[] tytul = {"Linie wielokąta", "Tło"};
		linie = true;
		JComboBox<String> wyborOkna = new JComboBox<String>(tytul);
		pole1.add(wyborOkna);
        wyborOkna.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e){
            	if(e.getStateChange()==ItemEvent.SELECTED) 
            	{
        			String tytul = (String) e.getItem();
        			switch(tytul) 
        			{
        			  	  case "Linie wielokąta":
        			  		  
        			  		  linie=true;
        			  		  break;
        			  	  case "Tło":
        			  		 
        			  		  linie=false;
        			  		  break;
        			  	  
        			 }
        		}
            	
            }
        }); //Implementacja pozwalająca na przekazanie informacji o wybranym Panelu 
		
		zatwierdz = new JButton("Zatwierdź");
		zatwierdz.addActionListener(guzikZatwierdz); 
		pole1.add(zatwierdz);
		
		pole2 = new JPanel(new FlowLayout());
		pole3 = new JPanel(new FlowLayout());
		
		okienka.addTab("Opcje1", pole1);
		okienka.addTab("Opcje2", pole2);
		okienka.addTab("Opcje3", pole3);
		
		this.add(okienka);
		
	}
	
	ActionListener guzikZatwierdz = new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{ 
				
				Color nowy = new Color(R.getValue(), G.getValue(), B.getValue());
				if(linie)
				{
					plansza.setColorline(nowy);
				}
				else
				{
					plansza.setBackground(nowy);
				}
		}
	};
	
public class RChangeListener implements ChangeListener{
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String value = String.format("Red: %d", R.getValue());
			RLabel.setText(value);
		}
		
	}
	
	public class GChangeListener implements ChangeListener{
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String value = String.format("Green: %d", G.getValue());
			GLabel.setText(value);
		}
		
	}

	public class BChangeListener implements ChangeListener{
	
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String value = String.format("Blue: %d", B.getValue());
			BLabel.setText(value);
		}
	
	}
}
