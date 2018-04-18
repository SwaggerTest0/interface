package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.ActionProjectWriter;

public class OpenDialog extends JDialog implements ActionListener{

	private JPanel mainPane;
	private JPanel pathPanel;
	
	private JButton ok;
	
	protected String path;
	protected JTextField tf;
	
	public OpenDialog(MainFrame mf) {
		super(mf);
		setSize(400, 150);
		setLocation(mf.getSize().height/2,mf.getSize().width/2);
		this.setResizable(false);
		initAll();
		setVisible(true);
	}
	
	public void initAll() {
		this.mainPane = new JPanel();
		this.mainPane.setLayout(new GridLayout(2,1));
		
		initPathPanel();
		initPanelBas();
		
		add(this.mainPane);
	}
	
	public void initPathPanel() {
		this.pathPanel = new JPanel();
		
		JLabel text = new JLabel("Choisissez où vous voulez placer les projets");
		this.pathPanel.add(text);
		
		JPanel milieu = new JPanel();
		tf = new JTextField(System.getProperty("user.home"));
		tf.setColumns(25);
		
		JButton openFile = new JButton("Browse..");
		openFile.addActionListener(this);
		milieu.add(tf);
		milieu.add(openFile );
		this.pathPanel.add(milieu);
	
		this.mainPane.add(pathPanel);;
		
		
	}
	
	public void initPanelBas() {
		JPanel panelBas = new JPanel();
		ok = new JButton("OK");
		JButton sortir = new JButton("Exit");
		
		ok.addActionListener(this);
		
		panelBas.add(ok);
		panelBas.add(sortir);
		this.mainPane.add(panelBas);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			new ActionProjectWriter(tf.getText()+"\\SwaggerCompareProjects", "", "");
			this.dispose();
		} else {
			JFileChooser chooser = new JFileChooser();    
	    	chooser = new JFileChooser(); 
	    	chooser.setCurrentDirectory(new java.io.File("."));
	    	chooser.setDialogTitle("");
	    	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

	    	chooser.setAcceptAllFileFilterUsed(false);
	    	
	    	if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    		tf.setText(chooser.getCurrentDirectory().getAbsolutePath());
	    	}
		}
	    
	}
	    

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}
}
