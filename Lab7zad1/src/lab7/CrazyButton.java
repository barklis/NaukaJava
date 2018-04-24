package lab7;

import java.awt.Color;

import javax.swing.JButton;

public class CrazyButton extends JButton implements Runnable{

	String[] text = { "Stop", "if", "you", "like", "this", "one" };
	int interval = 1000;
	boolean valid = true;
	
	CrazyButton(){
		super();
	}
	CrazyButton(String[] arg1, int arg2){
		this();
		text=arg1;
		interval=arg2;
	}
	
	public void run() {
		
		int i=0;
		while (valid) {

			if (i < text.length - 1)
				i++;
			else
				i = 0;

			setText(text[i]);
			 setBackground(new Color(
			 (float)Math.random(),(float)Math.random(),(float)Math.random()
			 ));

			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
