package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderProject {

	private BufferedReader br;
	private FileReader fr;
	private String outcome;
	private String currentProject;
	private String mode;
	
	public ReaderProject(String name) {
		String filePath = System.getProperty("user.dir")+"\\donnees\\"+name;
		if(name.equals("path.rbt"))
			findPath(filePath);
		else
			currentProject(filePath);
		
	}
	
	private void findPath(String filePath) {
		try {
			
			this.fr = new FileReader(filePath);
			this.br = new BufferedReader(fr);

			for (int i=0;i<1;i++ ) {
				outcome = br.readLine();
			}
			
			String[] temp = outcome.split(":");
			outcome="";
			for (int i=1;i<temp.length;i++ ) {
				if(i==1)
					outcome += temp[i]+":"; 
				else
					outcome += temp[i]; 
			}

			System.out.println(outcome);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void currentProject(String filePath) {
try {
			
			this.fr = new FileReader(filePath);
			this.br = new BufferedReader(fr);

			for (int i=0;i<2;i++ ) {
				if(i==0)
					this.currentProject = br.readLine();
				if(i==1)
					this.mode =  br.readLine();
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
}
