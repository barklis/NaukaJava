package pl.lab2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButtonFrame extends JFrame 
{
	public ThreeButtonFrame()
	{
		super();
		this.setSize(640, 480);
		JPanel gora = new JPanel();
		
		gora.setLayout(new BoxLayout(gora, BoxLayout.PAGE_AXIS));
		this.add(gora);
		JButton guzik1 = new JButton("Zmień tytuł");
		guzik1.addActionListener(tytulListener);
		gora.add(guzik1);
		JButton guzik2 = new JButton("Zmień kolor");
		guzik2.addActionListener(kolorListener);
		gora.add(guzik2);
		JButton guzik3 = new JButton("Zakończ");
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
			
			getContentPane().setBackground(Color.BLUE);		
		}
	};
	ActionListener tytulListener = new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
					
		}
	};
	
	public static void main(String[] args) 
	{
		ThreeButtonFrame nowe_okno = new ThreeButtonFrame();
		
		nowe_okno.setVisible(true);
	}

}
