package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Sterowanie extends JPanel {
	//Kolory:
	Plansza plansza;
	JPanel pole1;
	JSlider R, G, B;
	JLabel RLabel, GLabel, BLabel;
	JButton zatwierdz;
	Boolean linie;
	JPanel pole2;
	JPanel pole3;
	JTabbedPane okienka;
	//Linie:
	JLabel gruboscOpis;
	JSlider gruboscLinia;
	JTextField gruboscPX;
	//Typ:
	JRadioButton wielokatRandom;
	JRadioButton wielokatRegularny;
	JPanel katySekcja;
	JLabel katyOpis;
	JSlider katyWybor;
	JTextField katyPole;
	JPanel rozmiarSekcja;
	JLabel rozmiarOpis;
	JSlider rozmiarWybor;
	JTextField rozmiarPole;
	
	
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
		zatwierdz.setPreferredSize(new Dimension(200,50));
		this.add(zatwierdz,BorderLayout.PAGE_END);
		
		pole2 = new JPanel();
		pole2.setLayout(new BoxLayout(pole2,BoxLayout.Y_AXIS));
		gruboscOpis = new JLabel("Grubość lini:");
		pole2.add(gruboscOpis);
		gruboscLinia = new JSlider(JSlider.VERTICAL,0,100,12);
		gruboscLinia.setMajorTickSpacing(10);
		gruboscLinia.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				gruboscPX.setText(gruboscLinia.getValue()+"px");
			}
			
		});
		
		gruboscLinia.setMinorTickSpacing(2);
		gruboscLinia.setPaintTicks(true);
		gruboscPX = new JTextField("0px");
		gruboscPX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int value=0;
				String pole;
				pole = gruboscPX.getText();
				if(pole.isEmpty())
					pole="0px";
				value=Integer.parseInt(pole.replaceAll("[\\D]", ""));
				gruboscLinia.setValue(value);
				
			}
			
		});
		gruboscPX.setMaximumSize(new Dimension(100,50));
		pole2.add(gruboscLinia);
		pole2.add(gruboscPX);
		
		pole3 = new JPanel(new FlowLayout());
		pole3.setLayout(new GridLayout(4,1));
		wielokatRandom = new JRadioButton("Wielokąt losowy");
		wielokatRandom.setActionCommand("0");
		wielokatRandom.addActionListener(wielokatyListener);
		wielokatRegularny = new JRadioButton("Wielokąt regularny");
		wielokatRegularny.setActionCommand("1");
		wielokatRegularny.addActionListener(wielokatyListener);
		pole3.add(wielokatRandom);
		pole3.add(wielokatRegularny);
		ButtonGroup group = new ButtonGroup();
		group.add(wielokatRandom);
		group.add(wielokatRegularny);
		
		katySekcja = new JPanel();
		katySekcja.setLayout(new BoxLayout(katySekcja, BoxLayout.Y_AXIS));
		katyOpis = new JLabel("Ile kątów:");
		katySekcja.add(katyOpis);
		katyWybor = new JSlider(JSlider.HORIZONTAL,3,50,4);
		katyWybor.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				katyPole.setText( String.valueOf(katyWybor.getValue()));
			}
			
		});
		katySekcja.add(katyWybor);
		katyPole = new JTextField("4");
		katyPole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int value=0;
				String pole;
				pole = katyPole.getText();
				if(pole.isEmpty())
					pole="3";
				value=Integer.parseInt(pole.replaceAll("[\\D]", ""));
				katyWybor.setValue(value);
				
			}
			
		});
		katyPole.setMaximumSize(new Dimension(50,25));
		katySekcja.add(katyPole);
		pole3.add(katySekcja);
		
		rozmiarSekcja = new JPanel();
		rozmiarSekcja.setLayout(new BoxLayout(rozmiarSekcja, BoxLayout.Y_AXIS));
		rozmiarOpis = new JLabel("Rozmiar tworzonego wielokąta:");
		rozmiarSekcja.add(rozmiarOpis);
		rozmiarWybor = new JSlider(JSlider.HORIZONTAL,0,100,10);
		rozmiarWybor.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				rozmiarPole.setText( String.valueOf(rozmiarWybor.getValue()));
			}
			
		});
		rozmiarSekcja.add(rozmiarWybor);
		rozmiarPole = new JTextField("10");
		rozmiarPole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int value=0;
				String pole;
				pole = rozmiarPole.getText();
				if(pole.isEmpty())
					pole="10";
				value=Integer.parseInt(pole.replaceAll("[\\D]", ""));
				rozmiarWybor.setValue(value);
				
			}
			
		});
		rozmiarPole.setMaximumSize(new Dimension(50,25));
		rozmiarSekcja.add(rozmiarPole);
		pole3.add(rozmiarSekcja);
		
		okienka.addTab("Kolory", pole1);
		okienka.addTab("Linie", pole2);
		okienka.addTab("Typ", pole3);
		
		this.add(okienka,BorderLayout.CENTER);
		
	}
	
	ActionListener wielokatyListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int wybor = Integer.parseInt(arg0.getActionCommand());
			switch(wybor)
			{
			case 0:
				((Wielokat) plansza.getFigura()).UstalPunkty(false, katyWybor.getValue(), (float) rozmiarWybor.getValue()/100,plansza.getWidth(), plansza.getHeight());
				plansza.paintComponent(plansza.getGraphics());
				break;
			case 1:
				((Wielokat) plansza.getFigura()).UstalPunkty(true, katyWybor.getValue(), (float) rozmiarWybor.getValue()/100,plansza.getWidth(), plansza.getHeight());
				plansza.paintComponent(plansza.getGraphics());
				break;
			}
		}
		
	};
	
	ActionListener guzikZatwierdz = new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{ 
				
				Color nowy = new Color(R.getValue(), G.getValue(), B.getValue());
				if(linie)
				{
					plansza.getFigura().setLiniaColor(nowy);
					plansza.setColorline(nowy);
				}
				else
				{
					plansza.setBackground(nowy);
				}
				plansza.getFigura().setLiniaSize(gruboscLinia.getValue());
				plansza.paintComponent(plansza.getGraphics());
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
