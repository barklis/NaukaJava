package lab4;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar {
	JMenu opcje1;
	JMenu opcje2;
	JMenu opcje3;
	public Menu()
	{
		opcje1 = new JMenu("Edycja");
		opcje2 = new JMenu("Zapisz");
		opcje3 = new JMenu("Wczytaj");
		
		this.add(opcje1);
		this.add(opcje2);
		this.add(opcje3);

	}
}
