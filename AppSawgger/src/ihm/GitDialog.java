package ihm;

public class GitDialog extends BaseDialog{

	public GitDialog(MainFrame mf, ProjectTree pt) {
		super(mf, pt);
		mode = "Git";
		setTitle("Swagger Project Git");
	}

}
