package ihm;

public class GitDialog extends BaseDialog{

	public GitDialog(MainFrame mf) {
		super(mf);
		String projectName = "\\SwaggerComparasonProjects";
		setSize(400, 150);
		setLocation(mf.getSize().height/2,mf.getSize().width/2);
		this.setResizable(false);
		setVisible(true); 
	}

}
