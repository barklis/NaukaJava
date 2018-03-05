package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MultiListenerFrame extends JFrame
{
	JPanel lewy;
	JPanel srodek;
	JPanel prawy;
	int wybranyPanel;
	
	public MultiListenerFrame() throws HeadlessException
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setLayout(new GridLayout(1,3));
		wybranyPanel=0;
		
		lewy = new JPanel();
		lewy.setBackground(Color.BLUE);
		
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
        			  		  lewy.setBackground(Color.green);
        			  		  wybranyPanel=0;
        			  		  break;
        			  	  case "Środkowe okno":
        			  		  lewy.setBackground(Color.red);
        			  		  wybranyPanel=1;
        			  		  break;
        			  	  case "Prawe okno":
        			  		  lewy.setBackground(Color.blue);
        			  		  wybranyPanel=2;
        			  		  break;
        			 }
        		}
            	
            }
        }); //Implementacja pozwalająca na przekazanie informacji o wybranym Panelu
        
		this.add(lewy);
		
		srodek = new JPanel();
		srodek.setBackground(Color.RED);
		JSlider R = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		srodek.add(R, BorderLayout.PAGE_START);
		JSlider G = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		srodek.add(G, BorderLayout.PAGE_START);
		JSlider B = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
		srodek.add(B, BorderLayout.PAGE_START);
		this.add(srodek);
		
		prawy = new JPanel();
		prawy.setBackground(Color.GREEN);
		this.add(prawy);
	}
	
	public int getWybranyPanel() {
		return wybranyPanel;
	}


	public void setWybranyPanel(int wybranyPanel) {
		this.wybranyPanel = wybranyPanel;
	}
	
	/*@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			String tytul = (String) e.getItem();
			  switch(tytul) {
			  	  case "Lewe okno":
			  		  this.setBackground(Color.green);
			  		  wybranyPanel=0;
			  		  break;
			  	  case "Środkowe okno":
			  		  this.setBackground(Color.red);
			  		wybranyPanel=1;
			  		  break;
			  	  case "Prawe okno":
			  		  this.setBackground(Color.blue);
			  		wybranyPanel=2;
			  		  break;
			  }
		}

	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiListenerFrame okno = new MultiListenerFrame();
		okno.setVisible(true);
	}

}



