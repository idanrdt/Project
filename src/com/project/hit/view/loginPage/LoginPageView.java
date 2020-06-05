package com.project.hit.view.loginPage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;

import com.project.hit.controller.loginController.LoginController;
import com.project.hit.model.authenticationSystem.InvalidCredentialsException;

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
	
	/**
	 * Showing the page.
	 */
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
					showError(ice.getMessage());
				}
				catch(ClassNotFoundException | IOException ex) {
					showError(ex.getMessage()+"\nPlease Contect your Administrator!");
				}
			}
        });
        
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
	}
	
	@Override
	public void setController(LoginController controller) {
		this.loginController = controller;
	}

	@Override
	public void close() {
		mainFrame.dispose();
	}
	
	/**
	 * Shows error to the user.
	 * @param msg - The message that is shown.
	 */
	private void showError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg,"Error",JOptionPane.ERROR_MESSAGE);
	}

}
