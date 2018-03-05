package lab3;

public class Trojkat implements Figura
{
	private double dlugoscBoku1;
	private double dlugoscBoku2;
	private double dlugoscBoku3;
	
	public double obliczObwod()
	{
		double obwod;
		obwod = dlugoscBoku1 + dlugoscBoku2 + dlugoscBoku3;
		return obwod;
	}
	public double obliczPole()
	{
		double pole;
		//W oparciu o wrór Herona:
		double p = 0.5 * obliczObwod();
		pole = Math.sqrt( p * ( p - dlugoscBoku1 ) * ( p - dlugoscBoku2) * ( p - dlugoscBoku3 ) );
		return pole;
	}
	
	public Trojkat(double dlugoscBoku1, double dlugoscBoku2, double dlugoscBoku3) {
		super();
		this.dlugoscBoku1 = dlugoscBoku1;
		this.dlugoscBoku2 = dlugoscBoku2;
		this.dlugoscBoku3 = dlugoscBoku3;
	}
	
}
