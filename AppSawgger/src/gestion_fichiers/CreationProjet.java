package gestion_fichiers;

import java.io.File;

public class CreationProjet {

	private String path;
	File directory;
	
	public CreationProjet(String path) {
		this.path			= path;
		this.directory 	= new File("path");
		creerRep();
	}
	
	public void creerRep() {
		if(!directory.exists()) {
			try{
				directory.mkdir();
		    } 
		    catch(SecurityException se){}        
		}
	}
	
	public boolean exist() {
		return this.directory.exists() && this.directory.isDirectory();
	}
}
