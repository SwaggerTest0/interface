package ihm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import action.ActionMenuItem;
import action.ActionProjectWriter;
import gestion_fichiers.RepertoirePrincipale;

public class MainFrame extends JFrame{
	
	
	public MainFrame(){
		super("App Swagger");
		
	    setSize(700, 700);
	    firstDialog();
	    this.initMenu();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	public void firstDialog() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\donnees\\path.txt"));
			if (br.readLine() == null) {
				 new OpenDialog(this);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	
	public void initMenu(){
		JMenuBar menuBar = new JMenuBar();
		/**Mode de récupération de data
		 * - XML/JSON : - En ligne
		 * 				- Sur git
		 * - SQL **/
		
		JMenu mode = new JMenu("Mode");
		
		
		JMenu xml_json = new JMenu("XML/JSON");
		JMenuItem optionGit = new JMenuItem("Récupérer à partir de Git");
		ActionMenuItem amiGit = new ActionMenuItem(optionGit, this);
		optionGit.addActionListener(amiGit);
		
		JMenuItem optionHTML = new JMenuItem("Récupérer en ligne");
		xml_json.add(optionGit);
		xml_json.add(optionHTML);
		mode.add(xml_json);
		
		JMenuItem sql = new JMenuItem("SQL");
		mode.add(sql);
		
		menuBar.add(mode);
		add(menuBar, "North");
		
	}
	
	
	public void initDialog(String name) {
		GitDialog gd = new GitDialog(this);
	}

}
