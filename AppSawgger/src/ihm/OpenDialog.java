package ihm;

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

	protected JPanel pathPanel;
	protected String path;
	protected JTextField tf;
	
	public OpenDialog(MainFrame mf) {
		super(mf);
		setSize(400, 150);
		setLocation(mf.getSize().height/2,mf.getSize().width/2);
		this.setResizable(false);
		initPathPanel();
		setVisible(true);
	}
	
	public void initPathPanel() {
		this.pathPanel = new JPanel();
		
		JLabel text = new JLabel("Choisissez où vous voulez placer les projets");
		this.pathPanel.add(text);
		
		JPanel milieu = new JPanel();
		tf = new JTextField(System.getProperty("user.home"));
		JButton openFile = new JButton("Search");
		openFile.addActionListener(this);
		milieu.add(tf, "West");
		milieu.add(openFile, "East" );
		pathPanel.add(milieu, "Center");
	
		JButton ok = new JButton("OK");
		pathPanel.add(ok, "South");
		add(pathPanel);
		ok.addActionListener(new ActionProjectWriter(tf.getText()+"\\SwaggerCompareProjects",""));
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	    JFileChooser chooser = new JFileChooser();    
    	chooser = new JFileChooser(); 
    	chooser.setCurrentDirectory(new java.io.File("."));
    	chooser.setDialogTitle("");
    	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	//
    	// disable the "All files" option.
    	//
    	chooser.setAcceptAllFileFilterUsed(false);
    	//    
    	if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
    		tf.setText(chooser.getCurrentDirectory().getAbsolutePath());
    	}
	}

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}
}
