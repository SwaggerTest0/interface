package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import ihm.MainFrame;

public class ActionMenuItem implements ActionListener{
	
	private MainFrame mf;
	private String nomMenu;
	
	public ActionMenuItem(JMenuItem menu, MainFrame mf) {
		this.mf 	 = mf;
		this.nomMenu = menu.getText();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(this.nomMenu) {
		case "R�cup�rer � partir de Git":
			System.out.println("ff");
			mf.initDialog(this.nomMenu);
			break;
		case "R�cup�rer en ligne":
			
			break;
		case "SQL":
	
			break;
		}
		
		
	}

	
}
