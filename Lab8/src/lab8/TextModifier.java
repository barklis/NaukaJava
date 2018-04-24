package lab8;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextModifier extends JFrame {
	
	TextField field;
	Menu menu;
	private boolean changed = false;
	
	public TextModifier() throws HeadlessException {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024,768);
		this.setTitle("edytor");
		this.setLayout(new BorderLayout());
		this.field = new TextField(this);
		
		this.menu = new Menu(this);
		
		this.add(field, BorderLayout.CENTER);
		this.setJMenuBar(menu);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (changed&&JOptionPane.showConfirmDialog(new JFrame(), 
		                "You made changes, save?", "Close window?",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			        	JFileChooser okienko = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter(
						        "Graphic files", "txt", "cpp");
						okienko.setFileFilter(filter);
						okienko.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						int returnVal = okienko.showOpenDialog(null);
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
				            try {
				            	
				    
				            	 //FileWriter out = new FileWriter(okienko.getSelectedFile());
				            	 PrintWriter out = new PrintWriter(okienko.getSelectedFile());
				            	 out.println(field.getText());
				            	 out.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
				           
					    }
		                System.exit(0);
		            }
		    }
});
		
	}

	public TextField getField() {
		return field;
	}

	public void setField(TextField field) {
		this.field = field;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public static void main(String[] args) {
		TextModifier editor = new TextModifier();
		editor.setVisible(true);
	}

}
