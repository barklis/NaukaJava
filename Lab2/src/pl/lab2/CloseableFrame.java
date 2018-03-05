package pl.lab2;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class CloseableFrame extends JFrame {

	public CloseableFrame() throws HeadlessException
	{
		super();
		this.setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //DISPONSE_ON_CLOSE nie konczy programu!
	}
	public CloseableFrame(GraphicsConfiguration gc) throws HeadlessException
	{
		super(gc);
		this.setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public CloseableFrame(String tytul) throws HeadlessException
	{
		super(tytul);
		this.setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public CloseableFrame(String tytul, GraphicsConfiguration gc) throws HeadlessException
	{
		super(tytul,gc);
		this.setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		CloseableFrame okienko = new CloseableFrame();
		okienko.setVisible(true);
	}

}
