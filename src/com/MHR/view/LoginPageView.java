package com.MHR.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;

import com.MHR.controller.*;

public class LoginPageView implements View {
	
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private JFrame mainFrame;
	private Controller controller;
	
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
        
        mainFrame.setPreferredSize(new DimensionUIResource(300, 250));
        
        loginPanel = new LoginPanel(this);
        welcomePanel = new WelcomePanel();
        mainFrame.getContentPane().add(welcomePanel, BorderLayout.NORTH);
        mainFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        
        loginPanel.addButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((LoginPageController)controller).loginButtonClicked(loginPanel.getUserName(), loginPanel.getPassword());
			}
        });
        
        mainFrame.pack();
        mainFrame.setVisible(true);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void close() {
		mainFrame.dispose();
	}
	
	public void setLoginError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg,"Error",JOptionPane.ERROR_MESSAGE);
		}

}
