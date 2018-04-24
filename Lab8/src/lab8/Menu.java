package lab8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JMenuBar {
	TextModifier kopia;
	JMenu opcje1;
	JMenuItem op1;
	JMenuItem otworz;
	JMenuItem zapisz;
	JMenu opcje2;
	JMenuItem op2;
	JMenu opcje3;
	JMenuItem op3;
	
	String text;
	
	public Menu(TextModifier kopia)
	{
		this.kopia = kopia;
		opcje1 = new JMenu("Plik");
		op1 = new JMenuItem("Zamknij");
		op1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		
		otworz = new JMenuItem("Otworz");
		otworz.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser okienko = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Graphic files", "txt", "cpp");
				okienko.setFileFilter(filter);
				okienko.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal = okienko.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            try {
		            	Scanner in = new Scanner(new InputStreamReader(
                                new FileInputStream(okienko.getSelectedFile()),
                                StandardCharsets.UTF_8 
                            ));
		     
		            	StringBuilder sb = new StringBuilder();
		            	while(in.hasNext()) {
		            	    sb.append(in.next() + ' ');
		            	}
		            	in.close();
		            	text = sb.toString();
		            	text = text.replaceAll("ą", "?").replaceAll("ę³", "?").replaceAll("ś", "?").replaceAll("ć", "?").replaceAll("ż‚", "?").replaceAll("ź", "?").replaceAll("ń", "?").replaceAll("ł", "?").replaceAll("ó", "?");
		            	
					} catch (IOException e) {
						e.printStackTrace();
					}
		            kopia.getField().setText(text);
		            kopia.setChanged(false);
			    }
				
			}
			
		});
		
		zapisz = new JMenuItem("Zapisz");
		zapisz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser okienko = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Graphic files", "txt", "cpp");
				okienko.setFileFilter(filter);
				okienko.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal = okienko.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            try {
		            	
		    
		            	 //FileWriter out = new FileWriter(okienko.getSelectedFile());
		            	 PrintWriter out = new PrintWriter(okienko.getSelectedFile());
		            	 out.println(kopia.getField().getText());
		            	 out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		            kopia.setChanged(false);
			    }
				
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
