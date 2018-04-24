package lab7;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class KeyGen extends JFrame {

	CrazyButton textbutton;
	HashLabel password;
	PowerOfPass power;
	ResultField result;
	GreatGraphics dumbanimation;
	
	public CrazyButton getTextbutton() {
		return textbutton;
	}
	
	public void setTextbutton(CrazyButton textbutton) {
		this.textbutton = textbutton;
	}

	public HashLabel getPassword() {
		return password;
	}

	public void setPassword(HashLabel password) {
		this.password = password;
	}

	public PowerOfPass getPower() {
		return power;
	}

	public void setPower(PowerOfPass power) {
		this.power = power;
	}

	public ResultField getResult() {
		return result;
	}

	public void setResult(ResultField result) {
		this.result = result;
	}

	public GreatGraphics getDumbanimation() {
		return dumbanimation;
	}

	public void setDumbanimation(GreatGraphics dumbanimation) {
		this.dumbanimation = dumbanimation;
	}

	public KeyGen() throws HeadlessException {
		super("KeyGen little edition");
		this.setLayout(new GridLayout(4,1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,200);
		
		this.textbutton = new CrazyButton();
		textbutton.addActionListener(new GetPassAction(this.getPassword(),this.getResult()));
		this.password = new HashLabel();
		
		this.power = new PowerOfPass(this.getPassword());
		
		this.result = new ResultField();
		
		this.dumbanimation = new GreatGraphics();
		
		this.add(password);
		this.add(power);
		this.add(textbutton);
		this.add(result);
		
		ExecutorService exec = Executors.newFixedThreadPool(3);
		exec.execute(password);
		exec.execute(textbutton);
		exec.execute(power);

		exec.shutdown();
		
	}

	public static void main(String[] args) {
		KeyGen keygen= new KeyGen();
		keygen.setVisible(true);
		try 
		{
		   Thread.sleep(20000);
		} 
		catch (InterruptedException e) 
		{
		   e.printStackTrace();
		}
		System.exit(0);
	}
}
