package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetPassAction implements ActionListener {
	HashLabel copy;
	ResultField textfield;
	String password;
	GetPassAction(HashLabel pass,ResultField text)
	{
		this.copy=pass;
		this.textfield=text;
		password="xxxxxxxx";
	}
	public void actionPerformed(ActionEvent arg0) {
		password=copy.getProposals().get(copy.getProposals().size()-1);
		textfield.setText(password);

	}

}
