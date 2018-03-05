package lab3;

public class Kolo implements Figura
{
	private double promien;
	
	public double obliczObwod()
	{
		double obwod;
		obwod = 2 * PI * promien;
		return obwod;
	}
	public double obliczPole()
	{
		double pole;
		pole = PI * promien * promien;
		return pole;
	}
	
	public Kolo(double promien) {
		super();
		this.promien = promien;
	}
	
}
