
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
import java.util.Locale;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;

public class Menu extends JMenuBar {
	MyChart kopia;
	JMenu opcje1;
	JMenuItem op1;
	JMenuItem otworz;
	JMenuItem zapisz;
	JMenu opcje2;
	JMenuItem op2;
	JMenu opcje3;
	JMenuItem op3;
	
	XYSeries series;
	String[] pliki = {"txt","dat"};
	public Menu(MyChart copy)
	{
		this.kopia = copy;
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
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic files", pliki);
				okienko.setFileFilter(filter);
				okienko.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal = okienko.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
		            try {
		            	Scanner in = new Scanner(new InputStreamReader(
                                new FileInputStream(okienko.getSelectedFile())
                            )).useLocale(Locale.US); //Są jakieś dziwne problemy z tym :(
		            	series = new XYSeries("Wczytana z pliku");;
		            	double X, Y;
		            	
		            	while(in.hasNext()) {
		            		X=in.nextDouble();
		            		Y=in.nextDouble();
		            		series.add(X,Y);
		            	}
		            	in.close();
		            	
		            	
					} catch (IOException e) {
						e.printStackTrace();
					}
		            
		            kopia.getDane().addSeries(series);
		    		JFreeChart chart = ChartFactory.createXYLineChart(
		    				"Wykres XY",//Tytul
		    				"Opis osi X", // opisy osi
		    				"Opis osi Y", 
		    				kopia.getDane(), // Dane 
		    				PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
		    				true, // legenda
		    				true, // tooltips
		    				false
		    			);
		    		
		    		kopia.setFrame1(new ChartFrame("Wykres",chart));
		    		
		    		kopia.getFrame1().setVisible(true);
		    		kopia.getFrame1().setSize(500,400);
			    }
				
			}
			
		});
		
		
		
		opcje1.add(otworz);
		opcje1.add(op1);
		
		opcje2 = new JMenu("Opcje");
		
		opcje3 = new JMenu("Pomoc");
		op3 = new JMenuItem("Jakas opcja");
		opcje3.add(op3);
		
		this.add(opcje1);
		this.add(opcje2);
		this.add(opcje3);

	}
}
