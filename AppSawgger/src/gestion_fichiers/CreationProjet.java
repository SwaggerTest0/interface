package gestion_fichiers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreationProjet {

	private String path;
	File directory;
	
	public CreationProjet(String path) {
		System.out.println(path);
		this.path			= path;
		this.directory 	= new File(path);
		creerRep();
	}
	
	public void creerRep() {
		System.out.println(!directory.exists());
		if(!directory.exists() ) {
			try{
				
				directory.mkdirs();
		    } 
		    catch(Exception se){se.printStackTrace();}        
		}
	}
	
	public boolean exist() {
		return this.directory.exists() && this.directory.isDirectory();
	}
}
