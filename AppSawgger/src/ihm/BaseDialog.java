package ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.ActionProjectWriter;
import reader.ReaderProject;

import javax.swing.JFileChooser;

public abstract class BaseDialog extends JDialog implements ActionListener{

	private JPanel mainPane;
	private JPanel pathPanel;
	private JPanel namePanel;
	
	private MainFrame mf;
	
	private ProjectTree pt;
	
	private JButton ok;
	
	protected String mode;
	protected String path;
	
	protected JTextField tfPath;
	protected JTextField tfName;
	
	public BaseDialog(MainFrame mf, ProjectTree pt) {
		super(mf);
		setSize(450, 220);
		setLocation(mf.getSize().height/2,mf.getSize().width/2);
		this.setResizable(false);
		this.pt = pt;
		this.mf = mf;
		initAll();
		setVisible(true);
	}
	
	public void initAll() {
		this.mainPane = new JPanel();
		this.mainPane.setLayout(new GridLayout(3,1));
		
		initPathPanel();
		initNamePanel();
		initPanelBas();
		
		add(this.mainPane);
	}
	
	
	public void initPathPanel() {
		this.pathPanel = new JPanel();
			
		JLabel text = new JLabel("Choisissez où vous voulez placer le projet");
		this.pathPanel.add(text);
		
		ReaderProject rP = new ReaderProject("path.rbt");
		tfPath = new JTextField(rP.getOutcome());
		tfPath.setColumns(25);
		JButton openFile = new JButton("Browse..");
		openFile.addActionListener(this);
		
		JPanel milieu = new JPanel();
		milieu.add(tfPath);
		milieu.add(openFile);
		this.pathPanel.add(milieu);
	
		this.mainPane.add(pathPanel);
	}
	
	public void initNamePanel() {
		this.namePanel = new JPanel();
		
		JLabel text = new JLabel("Choisissez le nom du projet");
		this.namePanel.add(text);
		
		this.tfName = new JTextField("");
		tfName.setColumns(30);
		this.namePanel.add(tfName);
		
		this.mainPane.add(this.namePanel, "Center");
		
		
		
	}
	
	
	public void initPanelBas() {
		JPanel panelBas = new JPanel();
		ok = new JButton("OK");
		JButton sortir = new JButton("Exit");
		panelBas.add(ok);
		panelBas.add(sortir);
		this.mainPane.add(panelBas);
		
		ok.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			new ActionProjectWriter(tfPath.getText(), this.tfName.getText(), mode);
			if(pt==null) 
				mf.createTree();
			else
				pt.refresh(tfName.getText());
			this.dispose();
		} else {
			JFileChooser chooser = new JFileChooser();    
	    	chooser = new JFileChooser(); 
	    	chooser.setCurrentDirectory(new java.io.File("."));
	    	chooser.setDialogTitle("");
	    	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

	    	chooser.setAcceptAllFileFilterUsed(false);
	    	
	    	if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    		tfPath.setText(chooser.getSelectedFile().getAbsolutePath());
	    	}
		}
	    
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTf() {
		return tfPath;
	}

	public void setTf(JTextField tf) {
		this.tfPath = tf;
	}

	
}
