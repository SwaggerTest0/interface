package gestion_fichiers;

import java.io.File;

public class RepertoirePrincipale {

	private String path;
	File directory;
	
	public RepertoirePrincipale(String path) {
		this.path			= path;
		this.directory 		= new File("path");
		System.out.print(path);
		creerRep(directory);
		creerRepData();
	}
	
	public void creerRep(File dir) { 
		if(!dir.exists()) {
			try{
				System.out.print("dir ok");
				dir.mkdirs();
		    } 
		    catch(SecurityException se){}        
		}
	}
	
	public void creerFichier(String pathFile) { 
		File f = new File("pathFile");
		if(!f.exists()) {
			try{
				f.createNewFile();
		    } 
		    catch(Exception e){}        
		}
	}
	
	
	private void creerRepData() {
		String pathRepData  = this.path+"\\data";
		File repData 		= new File(pathRepData);
		creerRep(repData);
		creerFichier(pathRepData+"\\dataJSON.rbt");
		creerFichier(pathRepData+"\\dataYAML.rbt");
		creerFichier(pathRepData+"\\dataSQL.rbt");
		
		
	}
	
	public boolean exist() {
		return this.directory.exists() && this.directory.isDirectory();
	}
}