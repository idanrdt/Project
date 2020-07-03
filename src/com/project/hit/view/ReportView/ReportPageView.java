package com.project.hit.view.ReportView;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.project.hit.controller.reportController.ReportController;

public class ReportPageView implements ReportView{
	
	private ReportController controller;
	private JFrame mainFrame;
	private CreateReportPanel createReport;
	private JDialog fileChooserDialog;
	
	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});	
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(ReportController controller) {
		this.controller = controller;
	}
	
	private void createAndShowGUI() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		createReport = new CreateReportPanel();
		mainFrame.add(createReport);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
