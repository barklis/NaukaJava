package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MenuListener implements ActionListener{

	JFrame kopia;
	
	public MenuListener(JFrame kopia) {
		super();
		this.kopia = kopia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				kopia.setTitle("Paint 0.1");
	}

}
