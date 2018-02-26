package pl.maxwell.okienko;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JPanel;

public class DrawablePanel extends JPanel
{
	public DrawablePanel() throws HeadlessException
	{
		super();
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);	
		g.setColor(Color.red);
	    g.fillRect(50, 50, 150, 100);
			
		g.setColor(Color.blue);
	 	g.fillOval(250, 250, 150, 150);
			
	}
	
	public static void main(String[] args) {
		Okno frame = new Okno();
		
		DrawablePanel panel = new DrawablePanel();
		panel.setBackground(Color.green);
		frame.add(panel);
	  
	    frame.setVisible(true);

	}

}
