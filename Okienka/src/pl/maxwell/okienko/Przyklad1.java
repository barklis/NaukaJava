package pl.maxwell.okienko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Przyklad1 {

	public static void main(String[] args)
	{
		Okno okienko = new Okno();
		JButton przycisk1 = new JButton("Przycisk 1");
		JButton przycisk2 = new JButton("Przycisk 2");
		okienko.add(przycisk1, BorderLayout.PAGE_START);
		okienko.add(przycisk2, BorderLayout.PAGE_END);
		JLabel label = new JLabel("To jest etykieta");
		okienko.add(label);
		JTextField field = new JTextField("A to pole tekstowe");
		okienko.add(field);
		okienko.setLayout(new GridLayout(2,2));
		okienko.getContentPane().setBackground(Color.blue);
		
		okienko.setVisible(true);
		
	}

}
