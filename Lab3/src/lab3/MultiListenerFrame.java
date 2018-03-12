package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lab3.InnerClassListenerFrame.SliderChangeListener;

public class MultiListenerFrame extends JFrame
{
	JPanel lewy;
	JPanel srodek;
	JPanel prawy;
	int wybranyPanel;
	JSlider R, G, B;
	JLabel RLabel, GLabel, BLabel;
	JCheckBox wybor;
	boolean negacja;
	JButton zatwierdz;
	JRadioButton opcja1, opcja2;
	boolean restart;
	
	public MultiListenerFrame() throws HeadlessException
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setLayout(new GridLayout(1,3));
		wybranyPanel=0;
		negacja = false;
		
		lewy = new JPanel();
		lewy.setBackground(Color.red);
		
		String[] tytul = {"Lewe okno", "Środkowe okno", "Prawe okno"};
		JComboBox<String> wyborOkna = new JComboBox<String>(tytul);
		lewy.add(wyborOkna, BorderLayout.PAGE_START);
        wyborOkna.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e){
            	if(e.getStateChange()==ItemEvent.SELECTED) 
            	{
        			String tytul = (String) e.getItem();
        			switch(tytul) 
        			{
        			  	  case "Lewe okno":
        			  		  //lewy.setBackground(Color.red);
        			  		  //srodek.setBackground(Color.green);
        			  		 // prawy.setBackground(Color.green);
        			  		  wybranyPanel=0;
        			  		  break;
        			  	  case "Środkowe okno":
        			  		 // lewy.setBackground(Color.green);
        			  		 // srodek.setBackground(Color.red);
        			  		 // prawy.setBackground(Color.green);
        			  		  wybranyPanel=1;
        			  		  break;
        			  	  case "Prawe okno":
        			  		 // lewy.setBackground(Color.green);
        			  		 // srodek.setBackground(Color.green);
        			  		 // prawy.setBackground(Color.red);
        			  		  wybranyPanel=2;
        			  		  break;
        			 }
        		}
            	
            }
        }); //Implementacja pozwalająca na przekazanie informacji o wybranym Panelu 
		this.add(lewy);
		
		srodek = new JPanel();
		srodek.setBackground(Color.green);
		R = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		R.addChangeListener(new RChangeListener());
		srodek.add(R, BorderLayout.PAGE_START);
		RLabel = new JLabel(String.format("Red: %d", R.getValue()));
		srodek.add(RLabel);
		
		G = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		G.addChangeListener(new GChangeListener());
		srodek.add(G, BorderLayout.PAGE_START);
		GLabel = new JLabel(String.format("Green: %d", G.getValue()));
		srodek.add(GLabel);
		
		B = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		B.addChangeListener(new BChangeListener());
		srodek.add(B, BorderLayout.PAGE_START);
		BLabel = new JLabel(String.format("Blue: %d", B.getValue()));
		srodek.add(BLabel);
		
		wybor = new JCheckBox("Negacja");
		wybor.addActionListener(new CheckListener(wybor, this));
		srodek.add(wybor);
		
		this.add(srodek);
		
		prawy = new JPanel();
		prawy.setBackground(Color.blue);
		opcja1 = new JRadioButton("Restart");
		opcja1.addActionListener(new RadioListener(this, opcja1));
		opcja2 = new JRadioButton("Praca");
		//opcja2.addActionListener(new RadioListener(this, opcja2));
		ButtonGroup grupaRadio = new ButtonGroup();
		grupaRadio.add(opcja1);
		grupaRadio.add(opcja2);
		prawy.add(opcja1);
		prawy.add(opcja2);
		zatwierdz = new JButton("Zatwierdź");
		zatwierdz.addActionListener(guzikZatwierdz); 
		prawy.add(zatwierdz);
		
		this.add(prawy);
	}
	
	ActionListener guzikZatwierdz = new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{ 
			if(restart)
			{
				lewy.setBackground(Color.red);
		  		srodek.setBackground(Color.green);
		  		prawy.setBackground(Color.blue);
			
			}
			else
			{
				Color nowy = new Color(R.getValue(), G.getValue(), B.getValue());
				 switch(wybranyPanel)
				 {
				  case 0:
					  lewy.setBackground(nowy);
					  break;
				  case 1:
					  srodek.setBackground(nowy);
					  break;
				  case 2:
					  prawy.setBackground(nowy);
					  break;
				 }
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiListenerFrame okno = new MultiListenerFrame();
		okno.setVisible(true);
	}



	public JCheckBox getWybor() {
		return wybor;
	}



	public void setWybor(JCheckBox wybor) {
		this.wybor = wybor;
	}



	public boolean isNegacja() {
		return negacja;
	}



	public void setNegacja(boolean negacja) {
		this.negacja = negacja;
	}



	public JButton getZatwierdz() {
		return zatwierdz;
	}



	public void setZatwierdz(JButton zatwierdz) {
		this.zatwierdz = zatwierdz;
	}



	public boolean isRestart() {
		return restart;
	}



	public void setRestart(boolean restart) {
		this.restart = restart;
	}
	
	

}



