package com.project.hit.view.loginPage;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {
	
	protected JTextField userNameField;
	protected JPasswordField passwordField;
	protected LoginPageView view;
	protected JButton loginButton;

	/**
	 * Create the panel.
	 */
	public LoginPanel(LoginPageView gui) {
		view = gui;
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel userNameLabel = new JLabel("User Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(userNameLabel, gbc_lblNewLabel);
		
		userNameField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(userNameField, gbc_textField);
		userNameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(passwordLabel, gbc_lblNewLabel_1);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		add(passwordField, gbc_passwordField);
		
		loginButton = new JButton("Login");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		add(loginButton, gbc_btnNewButton);
	}
	
	/**
	 * Set action listener to the button.
	 * @param al - The Action listener.
	 */
	public void addButtonListener(ActionListener al) {
		loginButton.addActionListener(al);
	}
	
	/**
	 * Gets the User name inserted by the user.
	 * @return {@link String} element that represent the user name.
	 */
	public String getUserName() {
		return userNameField.getText();
	}
	
	/**
	 * Gets the User name inserted by the user.
	 * @return {@link char} array element that represent the user password.
	 */
	public char[] getPassword() {
		return passwordField.getPassword();
	}
}
