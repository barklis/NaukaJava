package lab8;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class MouseMenu implements MouseListener {
	TextModifier copy;
	MouseMenu(TextModifier copy){
		super();
		this.copy=copy;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.isPopupTrigger())
            doPop(arg0);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//if (arg0.isPopupTrigger())
            //doPop(arg0);

	}
	
	
	private void doPop(MouseEvent e){
        PopUpDemo menu = new PopUpDemo(copy);
        menu.show(e.getComponent(), e.getX(), e.getY());
        menu.run();
        
    }
	
	class PopUpDemo extends JPopupMenu implements Runnable{
	    JMenuBar menu;
	    JMenuItem option1, option2, option3, option4, option5;
	    boolean isdone;
	    public PopUpDemo(TextModifier copy){
	    	super();
	    	menu = new JMenuBar();
	    	menu.setLayout(new GridLayout(5,1));
	        option1 = new JMenuItem("Styl 1");
	        option1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					copy.getField().setFont(new Font("Bold",0, 20));
					isdone=true;
				}
	        	
	        });
	        menu.add(option1);
	        
	        option4 = new JMenuItem("Styl 2");
	        option4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					copy.getField().setFont(new Font("Cursive",0, 44));
					isdone=true;
				}
	        	
	        });
	        menu.add(option4);
	        
	        option5 = new JMenuItem("Styl 3");
	        option5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					copy.getField().setFont(new Font("Plain",0, 4));
					isdone=true;
				}
	        	
	        });
	        menu.add(option5);
	        
	        option2 = new JMenuItem("Sprawdź pisownię");
	        option2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					isdone=true;
					System.exit(0);
				}
	        	
	        });
	        menu.add(option2);
	        option3 = new JMenuItem("Zamknij");
	        option3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					isdone=true;
					System.exit(0);
				}
	        	
	        });
	        menu.add(option3);
	        
	        this.add(menu);
	    }

		@Override
		public void run() {
		/*	while(!isdone){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
			*/
			
		}
	}
}
