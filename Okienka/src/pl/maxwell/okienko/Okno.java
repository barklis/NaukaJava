package pl.maxwell.okienko;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;


class Okno extends JFrame 
{
	public Okno() throws HeadlessException
	{
		super();
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public Okno(GraphicsConfiguration gc) throws HeadlessException
	{
		super(gc);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public Okno(String tytul) throws HeadlessException
	{
		super(tytul);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public Okno(String tytul, GraphicsConfiguration gc) throws HeadlessException
	{
		super(tytul,gc);
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		Okno okienko = new Okno();
		okienko.setVisible(true);
	}
	
	
	
}
