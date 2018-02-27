package pl.maxwell.okienko;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

public class ThreeShapesPanel extends JPanel {

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Random losowa = new Random(); 
		float kolory[][] = new float[3][3];
		for(int j=0; j<3; j++)
		{
			//Generownie RGB:
			for(int i=0; i<3; i++)
			{
				kolory[j][i]=losowa.nextFloat();
			}
			//Tworzenie nowego losowego koloru:
			Color c = new Color(kolory[j][0],kolory[j][1],kolory[j][2]);
			g.setColor(c);
			int jaka_figura = losowa.nextInt() % 3;
			switch(jaka_figura)
			{
				case 0:
					g.fillRect(50, 50, 150, 100);
					break;
				case 1:
					g.fillOval(50, 50, 150, 100);
					break;
				case 2:
					//Jakiś trójkąt:
					int ksztaltx[] = {50,150,150};
					int ksztalty[] = {50,150,50};
					g.fillPolygon(ksztaltx, ksztalty, 3);
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Okno closeable = new Okno();
		closeable.setLayout(new GridLayout(1,2));
		ThreeShapesPanel wlasny = new ThreeShapesPanel();
		closeable.add(wlasny);
		
		JPanel orginal = new JPanel();
		orginal.setLayout(new GridLayout(4,1));
		JLabel napis = new JLabel("Witaj w prostym okienku!");
		orginal.add(napis);
		JButton guzik1 = new JButton("Cześć");
		orginal.add(guzik1);
		JButton guzik2 = new JButton("Narazie");
		orginal.add(guzik2);
		JTextField pole_tekstowe = new JTextField();
		orginal.add(pole_tekstowe);
		closeable.add(orginal);
		
		closeable.setVisible(true);
	}

}
