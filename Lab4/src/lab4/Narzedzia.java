package lab4;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Narzedzia extends JPanel {
	Plansza obraz;
	JButton Olowek;
	JButton Gumka;
	JButton Linia;
	JButton Wielokat;
	JButton Spray;
	public Narzedzia(Plansza kopia) {
		super();
		obraz = kopia;
		this.setLayout(new FlowLayout());
		Olowek = new JButton("Olowek");
		Gumka = new JButton("Gumka");
		Linia = new JButton("Linia");
		Wielokat =  new JButton("Wielokąt");
		Spray = new JButton("Spray");
		
		this.add(Olowek);
		this.add(Gumka);
		this.add(Linia);
		this.add(Wielokat);
		this.add(Spray);
	}
	
	
	
}

class MyszListener implements MouseListener, MouseMotionListener{

	Plansza obraz;
	public MyszListener(Plansza kopia) {
		obraz = kopia;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
