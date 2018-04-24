import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MyChart extends JFrame {
	ChartFrame frame1;
	Menu menu;
	XYSeriesCollection dane;
	
	MyChart(){
		
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640,480);
		this.setTitle("Wykresy");
		this.setLayout(new BorderLayout());
		this.menu = new Menu(this);
		this.setJMenuBar(menu);
		/*
		XYSeries series = new XYSeries("Nazwa serii");
		series.add(1, 1);
		series.add(1, 2);
		series.add(2, 4);
		series.add(3, 4);
		series.add(4, 2);
		series.add(5, 9);
		series.add(6, 10);
		dane = new XYSeriesCollection();
		dane.addSeries(series);
		*/
		
		
		//this.add(frame1, BorderLayout.CENTER);
		
	}
	
	
	public ChartFrame getFrame1() {
		return frame1;
	}


	public void setFrame1(ChartFrame frame1) {
		this.frame1 = frame1;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public XYSeriesCollection getDane() {
		return dane;
	}


	public void setDane(XYSeriesCollection dane) {
		this.dane = dane;
	}


	public static void main(String[] args) {
		MyChart nowy = new MyChart();
		nowy.setVisible(true);
	}

}
