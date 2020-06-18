package com.project.hit.view.managerView;

import javax.swing.JFrame;

import com.project.hit.controller.managerController.ManagerController;

public class ManagerPageView implements ManagerView {
	
	private ManagerController controller;
	private JFrame mainFrame;
	private AddUserPanel addUser;
	private EditUserPanel editPanel;
	
	public ManagerPageView(ManagerController controller) {
		this.controller = controller;
	}
	
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
		mainFrame.dispose();
	}

	@Override
	public void setController(ManagerController controller) {
		this.controller = controller;
	}
	
	private void createAndShowGUI() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);	
	}

}
