package com.project.hit.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;

import com.project.hit.controller.LoginController;
import com.project.hit.model.InvalidCredentialsException;

public class LoginPageView implements LoginView {
	
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private JFrame mainFrame;
	private LoginController loginController;

	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private void createAndShowGUI() {
        mainFrame = new JFrame("Login Page");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainFrame.setPreferredSize(new DimensionUIResource(370, 250));
        
        loginPanel = new LoginPanel(this);
        welcomePanel = new WelcomePanel();
        mainFrame.getContentPane().add(welcomePanel, BorderLayout.NORTH);
        mainFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        
        loginPanel.addButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				loginController.authenticate(loginPanel.getUserName(), loginPanel.getPassword());
				}
				catch(InvalidCredentialsException ice) {
					setLoginError(ice.getMessage());
				}
			}
        });
        
        mainFrame.pack();
        mainFrame.setVisible(true);
	}
	
	public void setController(LoginController controller) {
		this.loginController = controller;
	}

	@Override
	public void close() {
		mainFrame.dispose();
	}
	
	private void setLoginError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg,"Error",JOptionPane.ERROR_MESSAGE);
	}

}
