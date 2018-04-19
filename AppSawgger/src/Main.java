

import javax.swing.SwingUtilities;

import ihm.MainFrame;

public class Main {

	public static void main(String[] arg) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MainFrame();
			}
		});
	}
}
