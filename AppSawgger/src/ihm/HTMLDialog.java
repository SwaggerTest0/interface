package ihm;

public class HTMLDialog extends BaseDialog{

	public HTMLDialog(MainFrame mf, ProjectTree pt) {
		super(mf, pt);
		mode = "HTML";
		setTitle("Swagger Project en ligne");
	}
}
