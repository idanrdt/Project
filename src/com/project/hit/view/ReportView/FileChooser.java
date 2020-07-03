package com.project.hit.view.ReportView;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooser extends JPanel {

	/**
	 * Create the panel.
	 */
	public FileChooser() {
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("choosertitle");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    add(chooser);
	}

}
