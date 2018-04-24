package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Okno extends JFrame{
	
	Menu pasekWyboru;
	JPanel srodek;
	JPanel poleEdytora;
	Narzedzia stopka;
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
		this.setSize(1024,768);
		this.setLayout(new BorderLayout());
		//this.setBackground(Color.RED);
		
		//this.gora = new JPanel();
		//gora.setLayout(new FlowLayout());
		//gora.setBackground(Color.GREEN); //Testy polozenia
		this.pasekWyboru = new Menu(this);
		this.setJMenuBar(pasekWyboru);
		//this.add(gora, BorderLayout.PAGE_START);
		
		this.srodek = new JPanel();
		SpringLayout styl = new SpringLayout(); //Pozycjonowanie elementów
		srodek.setLayout(styl);
		srodek.setBackground(Color.BLUE); //Testy polozenia
		
		poleEdytora = new JPanel();
		poleEdytora.setBackground(Color.gray);
		poleEdytora.setLayout(new FlowLayout());
		poleEdytora.setPreferredSize(new Dimension(500,500));
		
		pole = new Plansza(350,400);
		pole.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		pole.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		//pole.setSize(200, 200);
		
		opcje = new Sterowanie(pole);
		opcje.setMaximumSize(new Dimension(300,768));
		
		poleEdytora.add(pole, BorderLayout.CENTER);
		srodek.add(opcje);
		srodek.add(poleEdytora);
		
		styl.putConstraint(SpringLayout.WEST, opcje, 5, SpringLayout.WEST, srodek);
		styl.putConstraint(SpringLayout.SOUTH, opcje, -5, SpringLayout.SOUTH, srodek);
		styl.putConstraint(SpringLayout.NORTH, opcje, 5, SpringLayout.NORTH, srodek);
		styl.putConstraint(SpringLayout.EAST, poleEdytora, -5, SpringLayout.EAST, srodek);
		styl.putConstraint(SpringLayout.SOUTH, poleEdytora, -5, SpringLayout.SOUTH, srodek);
		styl.putConstraint(SpringLayout.NORTH, poleEdytora, 5, SpringLayout.NORTH, srodek);
		styl.putConstraint(SpringLayout.EAST, opcje, -5, SpringLayout.WEST, poleEdytora);
		
		
		this.add(srodek, BorderLayout.CENTER);
		
		this.stopka = new Narzedzia(pole);
		stopka.setBackground(Color.YELLOW); //Testy polozenia
		
		this.add(stopka, BorderLayout.PAGE_END);
		
	}


	public static void main(String[] args) {
		Okno program = new Okno();
		program.setVisible(true);
	}
}
