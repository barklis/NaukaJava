package lab7;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PowerOfPass extends JPanel implements Runnable{

	boolean valid;
	int interval;
	JPanel Red, Yellow, Green;
	HashLabel copy;
	
	public PowerOfPass(HashLabel arg1) {
		super();
		this.valid = true;
		this.interval = 1000;
		this.copy = arg1;
		this.setLayout(new GridLayout(1,3));
		Red = new JPanel();
		Red.setBackground(Color.RED);
		this.add(Red);
		Yellow = new JPanel();
		Yellow.setBackground(Color.RED);
		this.add(Yellow);
		Green = new JPanel();
		Green.setBackground(Color.RED);
		this.add(Green);
	}

	public void run() {
		
		int i=0;
		String pass;
		int strenght=0;
		int digits=0;
		while (valid) {
			if(copy.proposals.size()>i)
			{
				pass=copy.proposals.get(copy.proposals.size()-1);
				if(pass.length()>=5)
					strenght++;
				for(int j=0;j<pass.length();j++) {
					if((int) pass.charAt(j) >= 48 && (int) pass.charAt(j) <= 57)
						digits++;
				}
				if(digits>5)
					strenght++;
				if(strenght>1) {
					Red.setBackground(Color.YELLOW);
					Yellow.setBackground(Color.GREEN);
					Green.setBackground(Color.GREEN);
				}
				else if(strenght==0){
					Red.setBackground(Color.RED);
					Yellow.setBackground(Color.RED);
					Green.setBackground(Color.RED);
				}
				else{
					Red.setBackground(Color.RED);
					Yellow.setBackground(Color.YELLOW);
					Green.setBackground(Color.YELLOW);
				}
				i++;
				strenght=0;
				digits=0;
			}
			
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
