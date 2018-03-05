package pl.lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreeShapesPanel extends JPanel 
{
	float kolory[][];
	Random losowa;
	int jaka_figura;
	
	public ThreeShapesPanel()
	{
		
		kolory = new float[3][3];
		losowa = new Random();
		jaka_figura = losowa.nextInt() % 3;
		
		//Generownie RGB:
		for(int j=0; j<3; j++)
		{
			for(int i=0; i<3; i++)
			{
				kolory[j][i]=losowa.nextFloat();
			}
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Color c = new Color(kolory[0][0],kolory[0][1],kolory[0][2]);
		g.setColor(c);
		
		g.fillRect(50, 50, 150, 100);
		c = new Color(kolory[1][0],kolory[1][1],kolory[1][2]);
		g.setColor(c);
		
		g.fillOval(150, 150, 150, 100);
		c = new Color(kolory[2][0],kolory[2][1],kolory[2][2]);
		g.setColor(c);
		
		//Jakiś trójkąt:
		int ksztaltx[] = {50,150,150};
		int ksztalty[] = {200,250,150};
		g.fillPolygon(ksztaltx, ksztalty, 3);
		
		/*
		for(int j=0; j<3; j++)
		{
			
			//Tworzenie nowego losowego koloru:
			Color c = new Color(kolory[j][0],kolory[j][1],kolory[j][2]);
			g.setColor(c);
			
			switch(jaka_figura)
			{
				case 0:
					g.fillRect(50, 50, 150, 100);
					break;
				case 1:
					g.fillOval(150, 150, 150, 100);
					break;
				case 2:
					//Jakiś trójkąt:
					int ksztaltx[] = {50,150,150};
					int ksztalty[] = {200,250,150};
					g.fillPolygon(ksztaltx, ksztalty, 3);
					break;
			}
		}
		*/
	}
	
	public static void main(String[] args) {
		
		CloseableFrame closeable = new CloseableFrame();
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
