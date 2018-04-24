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
	private Graphics2D g2d;
	private BufferedImage grafika;
	private Color colorline;
	private BasicStroke stroke;

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Color getColorline() {
		return colorline;
	}

	public void setColorline(Color colorline) {
		this.colorline = colorline;
	}

	public Graphics2D getG2d() {
		return g2d;
	}

	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}

	public BufferedImage getGrafika() {
		return grafika;
	}

	public void setGrafika(BufferedImage grafika) {
		this.grafika = grafika;
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public Plansza(int x, int y)
	{
		super();
		width = x;
		height = y;
		colorline = Color.BLACK;
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.WHITE);
		
		int[] posX = {0,0,0,0};
		int[] posY = {0,0,0,0};
		figura = new Wielokat(posX, posY, 4);
		stroke = new BasicStroke(1);

		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setColor(colorline);
		g2d.setStroke(new BasicStroke(figura.getLiniaSize()));
		g2d.drawPolygon( (Wielokat) figura);
		g2d.drawImage(grafika, 0, 0, this);
	}
	
	
	@Override
	public void repaint() {
		
		super.repaint();
	}

	public void UmiescPolygon()
	{
		
	}
}
