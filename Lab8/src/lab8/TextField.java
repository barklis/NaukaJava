package lab8;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;

public class TextField extends JEditorPane {

	public TextField(TextModifier copy)
	{
		super();
		this.addMouseListener(new MouseMenu(copy));
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				copy.setChanged(true);
			}
		});
	}
	
	
}
