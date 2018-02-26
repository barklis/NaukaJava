package pl.maxwell.okienko;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Przyklad2 {

	public static void main(String[] args) {
		Okno frame = new Okno();
		frame.setLayout(new GridLayout(1,2));
				
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		frame.add(panel1);
				
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.black);
		frame.add(panel2);
				
		JLabel leftLabel = new JLabel("Lewy panel");
		panel1.add(leftLabel);
		JLabel rightLabel = new JLabel("Prawy panel");
		rightLabel.setForeground(Color.white);
		panel2.add(rightLabel);

		frame.setVisible(true);

	}

}
