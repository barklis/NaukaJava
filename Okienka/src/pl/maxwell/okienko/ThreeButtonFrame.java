package pl.maxwell.okienko;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreeButtonFrame extends JFrame {
	public ThreeButtonFrame()
	{
		super();
		this.setLayout(new GridLayout(3,1));
		JButton guzik1 = new JButton("Zmień tytuł");
		guzik1.addActionListener(tytulListener);
		this.add(guzik1);
		JButton guzik2 = new JButton("Zmień kolor");
		guzik2.addActionListener(kolorListener);
		this.add(guzik2);
		JButton guzik3 = new JButton("Zakończ");
		guzik3.addActionListener(exitListener);
		this.add(guzik3);
	}
	
	ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
					
		}
	};
	
	ActionListener kolorListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
					
		}
	};
	
	ActionListener tytulListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
					
		}
	};
	
	public static void main(String[] args) {
		ThreeButtonFrame nowe_okno = new ThreeButtonFrame();
		nowe_okno.setVisible(true);
	}

}
