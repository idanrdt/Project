package com.project.hit.view;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooser extends JPanel {

	private JFileChooser chooser;
	/**
	 * Create the panel.
	 */
	public FileChooser() {
		chooser = new JFileChooser();

	}
	
	/**
	 * Return the selected path.
	 * @return The selected saving path.
	 */
	public String getSselectedLocation() {
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose diffrent save location");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    add(chooser);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	return chooser.getSelectedFile().toString();
	      } else {
	    	  return null;
	      }
	}

}
