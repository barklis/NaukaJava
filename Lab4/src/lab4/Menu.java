package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JMenuBar {
	Okno kopia;
	JMenu opcje1;
	JMenuItem op1;
	JMenuItem otworz;
	JMenuItem zapisz;
	JMenu opcje2;
	JMenuItem op2;
	JMenu opcje3;
	JMenuItem op3;
	
	public Menu(Okno kopia)
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
		
		otworz = new JMenuItem("Otworz");
		otworz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser okienko = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Graphic files", "jpg", "gif", "png", "bmp");
				okienko.setFileFilter(filter);
				okienko.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal = okienko.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	BufferedImage wczytywany = null;
		            try {
		            	wczytywany = ImageIO.read(okienko.getSelectedFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
		            kopia.pole.setWidth(wczytywany.getWidth());
		            kopia.pole.setHeight(wczytywany.getHeight());
		            kopia.pole.setGrafika(wczytywany);
		            kopia.pole.repaint();
			    }
				
			}
			
		});
		
		zapisz = new JMenuItem("Zapisz");
		zapisz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		
		opcje1.add(otworz);
		opcje1.add(zapisz);
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
