package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Okno extends JFrame{
	
	Menu pasekWyboru;
	JPanel gora, srodek, stopka;
	Sterowanie opcje;
	Plansza pole;
	
	public Menu getPasekWyboru() {
		return pasekWyboru;
	}


	public void setPasekWyboru(Menu pasekWyboru) {
		this.pasekWyboru = pasekWyboru;
	}


	public Sterowanie getOpcje() {
		return opcje;
	}


	public void setOpcje(Sterowanie opcje) {
		this.opcje = opcje;
	}


	public Plansza getPole() {
		return pole;
	}


	public void setPole(Plansza pole) {
		this.pole = pole;
	}


	public Okno() throws HeadlessException {
		super("Rysownik v.2.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,480);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.RED);
		
		this.gora = new JPanel();
		gora.setLayout(new FlowLayout());
		gora.setBackground(Color.GREEN); //Testy polozenia
		this.pasekWyboru = new Menu(this);
		this.setJMenuBar(pasekWyboru);
		this.add(gora, BorderLayout.PAGE_START);
		
		this.srodek = new JPanel();
		SpringLayout styl = new SpringLayout(); //Pozycjonowanie elementów
		srodek.setLayout(styl);
		srodek.setBackground(Color.BLUE); //Testy polozenia
		
		pole = new Plansza(350,400);
		opcje = new Sterowanie(pole);
		srodek.add(opcje);
		srodek.add(pole);
		
		styl.putConstraint(SpringLayout.WEST, opcje, 5, SpringLayout.WEST, srodek);
		styl.putConstraint(SpringLayout.SOUTH, opcje, -5, SpringLayout.SOUTH, srodek);
		styl.putConstraint(SpringLayout.NORTH, opcje, 5, SpringLayout.NORTH, srodek);
		styl.putConstraint(SpringLayout.EAST, pole, -5, SpringLayout.EAST, srodek);
		styl.putConstraint(SpringLayout.SOUTH, pole, -5, SpringLayout.SOUTH, srodek);
		styl.putConstraint(SpringLayout.NORTH, pole, 5, SpringLayout.NORTH, srodek);
		styl.putConstraint(SpringLayout.EAST, opcje, -5, SpringLayout.WEST, pole);
		pole.setSize(200, 200);
		
		this.add(srodek, BorderLayout.CENTER);
		
		this.stopka = new JPanel();
		stopka.setBackground(Color.YELLOW); //Testy polozenia
		this.add(stopka, BorderLayout.PAGE_END);
		
	}


	public static void main(String[] args) {
		Okno program = new Okno();
		program.setVisible(true);
	}
}
