package pl.lab2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButtonFrame extends JFrame 
{
	JPanel calosc;
	JPanel gora;
	JPanel dol;
	JButton guzik1;
	JButton guzik2;
	JButton guzik3;
	
	public ThreeButtonFrame()
	{
		super("ThreeButtonFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setResizable(false);
		
		calosc = new JPanel();
		calosc.setLayout(new BoxLayout(calosc, BoxLayout.PAGE_AXIS));
		calosc.setPreferredSize(new Dimension(400,400));
		this.add(calosc);
		
		gora = new JPanel();
		dol = new JPanel();
		gora.setLayout(new BoxLayout(gora, BoxLayout.LINE_AXIS));
		dol.setPreferredSize(new Dimension(400,350));
		gora.setPreferredSize(new Dimension(400,50));
		calosc.add(gora);
		calosc.add(dol);
		
		guzik1 = new JButton("Zmień tytuł");
		guzik1.addActionListener(tytulListener);
		gora.add(guzik1);
		guzik2 = new JButton("Zmień kolor");
		guzik2.addActionListener(kolorListener);
		gora.add(guzik2);
		guzik3 = new JButton("Zakończ");
		guzik3.addActionListener(exitListener);
		gora.add(guzik3);
	}
	
	//Z @Override nie dziala:
	ActionListener exitListener = new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			System.exit(0);
					
		}
	};
	ActionListener kolorListener = new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			Random losowa = new Random();
			float[] RGB = new float[3];
			for(int i=0; i<3; i++)
			{
				RGB[i]=losowa.nextFloat();
			}
			Color kolorek = new Color(RGB[0], RGB[1], RGB[2]);
			dol.setBackground(kolorek);		
		}
	};
	ActionListener tytulListener = new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			setTitle("Inny tytul");
		}
	};
	
	public static void main(String[] args) 
	{
		ThreeButtonFrame nowe_okno = new ThreeButtonFrame();
		//nowe_okno.pack();
		nowe_okno.setVisible(true);
	}

}
