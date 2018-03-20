package lab4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;
//import java.util.ArrayList;

public class Wielokat extends Polygon implements Figura {

	int liniaSize;
	Color kolor;
	
	public Wielokat(int[] xPos, int[] yPos, int rozmiar) {
		super(xPos, yPos, rozmiar);
		
		kolor=Color.black;
		liniaSize=10;
		
	}
	
	public void UstalPunkty(Boolean czyRegularny, int katy, float rozmiar, int width, int height)
	{
		if(czyRegularny){
			double promien = 0.3*rozmiar*Math.sqrt(width*width+height*height);
			npoints=katy;
			xpoints = new int[katy];
			ypoints = new int[katy];
			for(int i=0; i<katy; i++)
			{
				xpoints[i]=(int) (promien*Math.cos((double) (PI/2+2*PI*(i+1))/katy)+width/2);
				ypoints[i]=(int) (promien*Math.sin((double) (PI/2+2*PI*(i+1))/katy)+height/2);
			}
		}
		else {
			
			Random generator = new Random();
			npoints=katy;
			xpoints = new int[katy];
			ypoints = new int[katy];
			for(int i=0; i<katy; i++)
			{
				xpoints[i]=(int) (rozmiar*(width/2)*Math.cos(2*PI*generator.nextFloat())+width/2);
				ypoints[i]=(int) (rozmiar*(height/2)*Math.cos(2*PI*generator.nextFloat())+height/2);
			}
		}
	}

	public int getLiniaSize() {
		return liniaSize;
	}

	public void setLiniaSize(int size) {
		liniaSize=size;
		
	}

	public Color getLiniaColor() {
		return kolor;
	}

	public void setLiniaColor(Color kolor) {
		this.kolor=kolor;
		
	}

}
