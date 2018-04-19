package ihm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import reader.ReaderProject;

public class ProjectTree extends JPanel implements ActionListener{

	private JTree tree;
	
	private DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;
    
    private MainFrame mf;
	
	public ProjectTree(MainFrame mf) {
		ReaderProject rp = new ReaderProject("path.rbt");
		File fileRoot = new File(rp.getOutcome());
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);
        
        this.mf = mf;

        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);
        this.add(scrollPane);
        CreateChildNodes ccn = 
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
        
    }
	
	 public class CreateChildNodes implements Runnable {

	        private DefaultMutableTreeNode root;

	        private File fileRoot;

	        public CreateChildNodes(File fileRoot, 
	                DefaultMutableTreeNode root) {
	            this.fileRoot = fileRoot;
	            this.root = root;
	        }

	        @Override
	        public void run() {
	            createChildren(fileRoot, root);
	        }

	        private void createChildren(File fileRoot, 
	                DefaultMutableTreeNode node) {
	            File[] files = fileRoot.listFiles();
	            for(int i=0;i<files.length;i++) {
	            }
	            if (files == null) return;

	            for (File file : files) {
	                DefaultMutableTreeNode childNode = 
	                        new DefaultMutableTreeNode(new FileNode(file));
	                node.add(childNode);
	                if (file.isDirectory()) {
	                    createChildren(file, childNode);
	                }
	            }
	        }

	    }

	    public class FileNode {

	        private File file;

	        public FileNode(File file) {
	            this.file = file;
	        }

	        @Override
	        public String toString() {
	            String name = file.getName();
	            if (name.equals("")) {
	                return file.getAbsolutePath();
	            } else {
	                return name;
	            }
	        }
	    }
	    
	    public void refresh(String fileName) {
	    	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
	    	DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
	    	root.add(new DefaultMutableTreeNode(fileName));
	    	model.reload(root);
    		treeModel.reload(root);
    		mf.majIHM();
    		
	    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
