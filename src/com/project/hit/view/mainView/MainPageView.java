package com.project.hit.view.mainView;

import javax.swing.JFrame;

import com.project.hit.controller.mainController.MainController;

public class MainPageView implements MainView{
	
	//private User user;
	
	public MainPageView(/*User user*/) {
		//this.user = user;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(MainController controller) {
		// TODO Auto-generated method stub
		
	}
	
	private void createAndShowGUI() {
		JFrame mainFrame = new JFrame("User: "/*,user.getUsername*/);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
