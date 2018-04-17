package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import gestion_fichiers.RepertoirePrincipale;

public class ActionProjectWriter implements ActionListener{

	private String path;
	private boolean mainProject;
	
	public ActionProjectWriter(String path, String name) {
		this.path=path;
		this.mainProject = isMainProject();
	}
	
	private boolean isMainProject() {
		String[] s = this.path.split("\\\\");
		return s[s.length-1].equals("SwaggerCompareProjects");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String write;
		if(mainProject) {
			new RepertoirePrincipale(path);
			write = "adresse:"+path;
			System.out.println(System.getProperty("user.home")+"\\donnees\\path.txt");
			
			try {
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
			              new FileOutputStream(System.getProperty("user.dir")+"\\donnees\\path.txt"), "utf-8"))) {
			   writer.write(write);
			}
			} catch(Exception e) {}
		} else {
			String[] s = this.path.split("\\\\");
			write = s[s.length-1];
			try {
				FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"\\donnees\\current.rbt");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print(write);
			    printWriter.close();
			} catch(Exception e) {}
		}

	}

}
