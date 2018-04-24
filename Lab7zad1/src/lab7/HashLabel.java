package lab7;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.swing.JLabel;

public class HashLabel extends JLabel implements Runnable{
	List<String> proposals;
	int numChars;
	boolean valid;
	int interval;
	int maxElements;
	char[] actual;
	
	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";

	public HashLabel() {
		super("xxxxxxxx");
		this.proposals = new ArrayList<String>();
		this.numChars = 8;
		this.valid = true;
		this.interval = 1000;
		this.maxElements=20;
		this.actual=null;
	}
	
	public HashLabel(int numChars) {
		this();
		this.numChars = numChars;
	}
	
	

	public List<String> getProposals() {
		return proposals;
	}

	public void setProposals(List<String> proposals) {
		this.proposals = proposals;
	}

	public int getNumChars() {
		return numChars;
	}

	public void setNumChars(int numChars) {
		this.numChars = numChars;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public char[] getActual() {
		return actual;
	}

	public void setActual(char[] actual) {
		this.actual = actual;
	}

	public void run() {
		Random r = new Random();
		int i=-1;
		actual = new char[numChars];
		while (valid) {
			if(proposals.size()<maxElements){
				
				for(int j=0; j<actual.length; j++){
					if(r.nextBoolean())
						actual[j]=upper.charAt(r.nextInt(upper.length()));
					else
						actual[j]=digits.charAt(r.nextInt(digits.length()));
				}
				proposals.add(new String(actual));
				i++;
			}
			this.setText(proposals.get(i));
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
