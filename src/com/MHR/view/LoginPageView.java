package com.MHR.view;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

public class LoginPageView implements View {
	
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	
	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}
	
	private void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Login Page");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new DimensionUIResource(300, 250));
        
        loginPanel = new LoginPanel();
        welcomePanel = new WelcomePanel();
        mainFrame.getContentPane().add(loginPanel);

        mainFrame.pack();
        mainFrame.setVisible(true);
	}
}
