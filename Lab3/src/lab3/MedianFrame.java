package lab3;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MedianFrame extends JFrame {
	List<Double> liczby;
	JPanel naglowek, cialo, sterowanie;
	JTextField poleTekstowe;
	JButton guzik1, guzik2;
	JLabel wynik, skladowe;
	
	public MedianFrame() throws HeadlessException 
	{
		super();
		this.liczby = new ArrayList<Double>();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 240);
		this.setLayout(new GridLayout(2,1));
		this.setTitle("Obliczanie Mediany");
		
		this.naglowek = new JPanel();
		naglowek.setLayout(new BoxLayout(naglowek, BoxLayout.X_AXIS));
		this.poleTekstowe = new JTextField();
		poleTekstowe.setSize(100,50);
		naglowek.add(poleTekstowe);
		
		this.sterowanie = new JPanel();
		sterowanie.setLayout(new GridLayout(3,1));
		
		this.guzik1 = new JButton("Dodaj");
		guzik1.addActionListener(guzik1akcja);
		sterowanie.add(guzik1);
		this.guzik2 = new JButton("Mediana");
		guzik2.addActionListener(guzik2akcja);
		sterowanie.add(guzik2);
		this.wynik = new JLabel(String.format("Mediana wynosi: "));
		sterowanie.add(wynik);
		naglowek.add(sterowanie);
		this.add(naglowek);
		
		this.cialo = new JPanel();
		this.skladowe = new JLabel(String.format("Wprowadzone liczby: ", SwingConstants.CENTER));
		cialo.add(skladowe);
		cialo.setLayout(new GridBagLayout());
		this.add(cialo);
		
	}
	
	ActionListener guzik1akcja = new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{ 
			boolean dobrze = true;
			double number = 0;
			String text = poleTekstowe.getText();
			try{
			     number = Double.parseDouble(text);
			}
			catch(NumberFormatException exception){
			     System.out.println("Wrong number format.");
			     dobrze = false;
			     
			}
			if(dobrze)
			{
				liczby.add(number);
				skladowe.setText(skladowe.getText()+ " " + number);
			}
			
			
		}
	};
	
	ActionListener guzik2akcja = new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{ 
			double mediana=0;
			int polowa = liczby.size() / 2;
			Collections.sort(liczby);
			if(liczby.size() % 2 == 0)
			{
				mediana = ( liczby.get(polowa -1) + liczby.get(polowa) ) / 2;
			}
			else
			{
				mediana = liczby.get(polowa);
			}
			
			String doWypisania = new String();
			for(int i=0; i < liczby.size(); i ++)
			{
				doWypisania += liczby.get(i) + " ";
			}
			
			
			skladowe.setText("Wprowadzone liczby: " + doWypisania);
			wynik.setText("Mediana wynosi: " + mediana);
			//Liczenie Mediany
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFrame okno = new MedianFrame();
		okno.setVisible(true);
	}
	
}
