package lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;


public class CheckListener implements ActionListener{
	MultiListenerFrame kopia;
	AbstractButton box;
	CheckListener(AbstractButton c, MultiListenerFrame dane)
	{
		super();
		kopia = dane;
		box = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(box.isSelected())
		{
			kopia.setNegacja(true);
		}
		else
		{
			kopia.setNegacja(false);
		}
	}

}
