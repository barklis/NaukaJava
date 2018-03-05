package lab3;

public class ZadanieA {

	public static void main(String[] args) 
	{
		Kolo kolko1 = new Kolo(3);
		System.out.println("Wygenerowano kolo o obwodzie: " + kolko1.obliczObwod() + " oraz polu: " + kolko1.obliczPole());
		Trojkat trojkat1 = new Trojkat(3,5,6);
		System.out.println("Wygenerowano trójkąt o obwodzie: " + trojkat1.obliczObwod() + " oraz polu: " + trojkat1.obliczPole());
	}

}
