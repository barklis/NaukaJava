package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	JFrame kopia;
	JMenu opcje1;
	JMenuItem op1;
	JMenu opcje2;
	JMenuItem op2;
	JMenu opcje3;
	JMenuItem op3;
	
	public Menu(JFrame kopia)
	{
		this.kopia = kopia;
		opcje1 = new JMenu("Plik");
		op1 = new JMenuItem("Zamknij");
		op1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		opcje1.add(op1);
		
		opcje2 = new JMenu("Opcje");
		op2 = new JMenuItem("Zmien nazwę okna");
		op2.addActionListener(new MenuListener(kopia));
		opcje2.add(op2);
		
		opcje3 = new JMenu("Pomoc");
		op3 = new JMenuItem("Jakas opcja");
		opcje3.add(op3);
		
		this.add(opcje1);
		this.add(opcje2);
		this.add(opcje3);

	}
}
