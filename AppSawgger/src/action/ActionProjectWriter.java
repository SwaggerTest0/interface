package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JDialog;

import gestion_fichiers.CreationProjet;
import gestion_fichiers.RepertoirePrincipale;

public class ActionProjectWriter{

	private String path;
	private boolean mainProject;
	private String mode;
	
	public ActionProjectWriter(String path, String name, String mode) {
		this.mode = mode;
		this.path=path+"\\"+name;
		this.mainProject = isMainProject();
		initRep();
	}
	
	private boolean isMainProject() {
		String[] s = this.path.split("\\\\");
		return s[s.length-1].equals("SwaggerCompareProjects");
		
	}
	
	public void initRep() {
		String write;
		if(mainProject) {
			new RepertoirePrincipale(path);
			write = "adresse:"+path;
			
			try {
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
			              new FileOutputStream(System.getProperty("user.dir")+"\\donnees\\path.rbt"), "utf-8"))) {
			   writer.write(write);
			}
			} catch(Exception e) {}
		} else {
			String[] s = this.path.split("\\\\");
			write = s[s.length-1];
			try {
				if(!new File(path).exists())
					new CreationProjet(path);
				
				File file = new File(System.getProperty("user.dir")+"\\donnees\\current.rbt");
				
				if(file.exists()) {
					file.delete();
					file.createNewFile();
				} else
					file.createNewFile();

				FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"\\donnees\\current.rbt");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.println(write);
			    printWriter.println(mode);
			    printWriter.close();
			} catch(Exception e) {}
		}

	}

}
