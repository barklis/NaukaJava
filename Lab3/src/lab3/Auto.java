//Przykład 1
package lab3;

public class Auto implements Pojazd 
{

	double[] predkosc;
	
	public Auto() {
		predkosc = new double[3];
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ustawPredkosc(double[] v) {
		if(v.length>=3) {
			predkosc[0] = v[0];
			predkosc[1] = v[1];
			predkosc[2] = v[2];
		}
	}
	
}
