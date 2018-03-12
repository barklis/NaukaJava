package lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class RadioListener implements ActionListener 
{
	MultiListenerFrame kopia;
	AbstractButton box;
	
	public RadioListener(MultiListenerFrame kopia, AbstractButton box) {
		super();
		this.kopia = kopia;
		this.box = box;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(box.isSelected())
		{
			kopia.setRestart(true);
		}
		else
		{
			kopia.setRestart(false);
		}
	}

}
