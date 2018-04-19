package ihm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import action.ActionMenuItem;
import gestion_fichiers.RepertoirePrincipale;
import reader.ReaderProject;

public class MainFrame extends JFrame implements WindowListener{
	

	private static final long serialVersionUID = 1L;
	
	private ReaderProject 	rp;
	private ProjectTree		pt;
	private boolean treeCreated;
	
	public MainFrame(){
		super("App Swagger");
	    setSize(700, 700);
	    
	    firstDialog();
	    initMenu();
	    createTree();
	    this.addWindowListener(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public void firstDialog() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\donnees\\path.rbt"));
			if (br.readLine() == null) {
				 new OpenDialog(this, true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	
	public void createTree() {
	    rp = new ReaderProject("path.rbt");
	    RepertoirePrincipale repP = new RepertoirePrincipale(rp.getOutcome());
	    this.treeCreated = repP.isDirEmpty();
	    
	    if(!treeCreated) {
	    	this.pt = new ProjectTree(this);
	    	add(pt, "West");
	    }
	    majIHM();
	}
	
	public void initMenu(){
		JMenuBar menuBar = new JMenuBar();
		/**Mode de récupération de data
		 * - XML/JSON : - En ligne
		 * 				- Sur git
		 * - SQL **/
		
		JMenu mode = new JMenu("New");
		JMenu ouvrir = new JMenu("Open");
		
		
		JMenu xml_json = new JMenu("YAML/JSON");
		
		JMenuItem optionGit = new JMenuItem("Récupérer à partir de Git");
		ActionMenuItem amiGit = new ActionMenuItem(optionGit, this);
		optionGit.addActionListener(amiGit);
		
		JMenuItem optionHTML = new JMenuItem("Récupérer en ligne");
		optionHTML.addActionListener(new ActionMenuItem(optionGit, this));
		
		xml_json.add(optionGit);
		xml_json.add(optionHTML);
		mode.add(xml_json);
		
		JMenuItem sql = new JMenuItem("SQL");
		mode.add(sql);
		
		JMenuItem openProject = new JMenuItem("Project..");
		openProject.addActionListener(new ActionMenuItem(openProject, this));
		ouvrir.add(openProject);
		
		menuBar.add(mode);
		menuBar.add(ouvrir);
		add(menuBar, "North");
		
	}
	
	public void initHTMLDialog() {
		HTMLDialog dHTML = new HTMLDialog(this, pt);
	}
	
	public void initGitDialog() {
		GitDialog gd = new GitDialog(this, pt);
	}
	
	public void initOpenProjectDialog() {
		OpenDialog od = new OpenDialog(this, false);
	}

	public void majIHM() {
		this.invalidate();
		this.validate();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		File file = new File(System.getProperty("user.dir")+"\\donnees\\current.rbt");
		try {
			if(file.exists()) {
				file.delete();
				file.createNewFile();
			}
			else {
				file.createNewFile();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
		if (JOptionPane.showConfirmDialog(this, 
	            "Are you sure to close this window?", "Really Closing?", 
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){System.exit(0);}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
