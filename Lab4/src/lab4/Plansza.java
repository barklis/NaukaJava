package lab4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Plansza extends JPanel{
	private int width;
	private int height;
	private Figura figura;
	
	Graphics2D g2d;
	Color color;
	BasicStroke stroke;

	
	public Plansza(int x, int y)
	{
		super();
		width = x;
		height = y;
		this.setPreferredSize(new Dimension(width,height));
		int[] posX = {230,3,5,30};
		int[] posY = {123,5,145,2};
		figura = new Wielokat(posX, posY, 4);
		stroke = new BasicStroke(1);

		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.setStroke(stroke);
		g2d.drawPolygon( (Polygon) figura);
	}
	
	public void UmiescPolygon()
	{
		
	}
}
