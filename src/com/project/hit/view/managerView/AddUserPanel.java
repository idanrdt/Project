package com.project.hit.view.managerView;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.model.managerSystem.details.User;

import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class AddUserPanel extends JPanel {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField idField;
	private JTextField addressField;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel addressLabel;
	private JButton createNewUserButton;
	private JCheckBox isManagerCheckBox;

	/**
	 * Create the panel.
	 */
	public AddUserPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		userNameLabel = new JLabel("User Name:");
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.insets = new Insets(0, 5, 5, 5);
		gbc_userNameLabel.anchor = GridBagConstraints.WEST;
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 0;
		add(userNameLabel, gbc_userNameLabel);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		passwordLabel = new JLabel("Password:");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 5, 5, 5);
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 1;
		add(passwordLabel, gbc_passwordLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		add(passwordField, gbc_passwordField);
		
		nameLabel = new JLabel("Name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 5, 5, 5);
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 2;
		add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 2;
		add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		idLabel = new JLabel("ID:");
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.insets = new Insets(0, 5, 5, 5);
		gbc_idLabel.anchor = GridBagConstraints.WEST;
		gbc_idLabel.gridx = 0;
		gbc_idLabel.gridy = 3;
		add(idLabel, gbc_idLabel);
		
		idField = new JTextField();
		GridBagConstraints gbc_idField = new GridBagConstraints();
		gbc_idField.insets = new Insets(0, 0, 5, 5);
		gbc_idField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idField.gridx = 1;
		gbc_idField.gridy = 3;
		add(idField, gbc_idField);
		idField.setColumns(10);
		
		addressLabel = new JLabel("Address:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.insets = new Insets(0, 5, 5, 5);
		gbc_addressLabel.anchor = GridBagConstraints.WEST;
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 4;
		add(addressLabel, gbc_addressLabel);
		
		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 4;
		add(addressField, gbc_addressField);
		addressField.setColumns(10);
		
		isManagerCheckBox = new JCheckBox("is Manager");
		GridBagConstraints gbc_isManagerCheckBox = new GridBagConstraints();
		gbc_isManagerCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_isManagerCheckBox.gridwidth = 3;
		gbc_isManagerCheckBox.gridx = 0;
		gbc_isManagerCheckBox.gridy = 5;
		add(isManagerCheckBox, gbc_isManagerCheckBox);
		
		createNewUserButton = new JButton("Create New User");
		GridBagConstraints gbc_createNewUserButton = new GridBagConstraints();
		gbc_createNewUserButton.insets = new Insets(0, 0, 5, 0);
		gbc_createNewUserButton.gridwidth = 2;
		gbc_createNewUserButton.gridx = 0;
		gbc_createNewUserButton.gridy = 6;
		add(createNewUserButton, gbc_createNewUserButton);
	}
	
	/**
	 * Adds new {@link ActionListener} to the create button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addCreateActionListener(ActionListener al) {
		createNewUserButton.addActionListener(al);
	}
	
	/**
	 * Gets the user created.
	 * @return {@link User} with the corresponding details.
	 * @throws NullArgumentException if any of the fields is empty.
	 */
	public User getUser() throws NullArgumentException {
		if((usernameField.getText().isEmpty() || idField.getText().isEmpty()) ||
		addressField.getText().isEmpty() || nameField.getText().isEmpty() ||
		passwordField.getPassword().length == 0) {
			throw new NullArgumentException();
		}
		else {
			User user = new User(usernameField.getText(), String.valueOf(passwordField.getPassword()),
					nameField.getText(), addressField.getText(), idField.getText());
			user.setManagerAccess(isManagerCheckBox.isSelected());
			return user;
		}
	}
	
	/**
	 * Resets all the fields to empty.
	 */
	public void resetFields() {
		usernameField.setText("");
		passwordField.setText("");
		nameField.setText("");
		idField.setText("");
		addressField.setText("");
		isManagerCheckBox.setSelected(false);
	}
}
