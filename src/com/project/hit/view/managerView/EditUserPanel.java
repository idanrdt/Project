package com.project.hit.view.managerView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.model.managerSystem.details.User;

public class EditUserPanel extends JPanel {

	private JTextField usernameField;
	private JTextField nameField;
	private JTextField addressField;
	private JLabel userNameLabel;
	private JLabel nameLabel;
	private JLabel addressLabel;
	private JButton saveUserButton;
	private JCheckBox isManagerCheckBox;
	private JLabel idLabel;
	private JLabel userID;

	/**
	 * Create the panel.
	 */
	public EditUserPanel() {
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
		
		nameLabel = new JLabel("Name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 5, 5, 5);
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 1;
		add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		idLabel = new JLabel("ID:");
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.anchor = GridBagConstraints.WEST;
		gbc_idLabel.insets = new Insets(0, 5, 5, 5);
		gbc_idLabel.gridx = 0;
		gbc_idLabel.gridy = 2;
		add(idLabel, gbc_idLabel);
		
		userID = new JLabel("");
		GridBagConstraints gbc_userIDLabel = new GridBagConstraints();
		gbc_userIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userIDLabel.gridx = 1;
		gbc_userIDLabel.gridy = 2;
		add(userID, gbc_userIDLabel);
		
		addressLabel = new JLabel("Address:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.insets = new Insets(0, 5, 5, 5);
		gbc_addressLabel.anchor = GridBagConstraints.WEST;
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 3;
		add(addressLabel, gbc_addressLabel);
		
		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 3;
		add(addressField, gbc_addressField);
		addressField.setColumns(10);
		
		isManagerCheckBox = new JCheckBox("is Manager");
		GridBagConstraints gbc_isManagerCheckBox = new GridBagConstraints();
		gbc_isManagerCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_isManagerCheckBox.gridwidth = 3;
		gbc_isManagerCheckBox.gridx = 0;
		gbc_isManagerCheckBox.gridy = 4;
		add(isManagerCheckBox, gbc_isManagerCheckBox);
		
		saveUserButton = new JButton("Save");
		GridBagConstraints gbc_saveUserButton = new GridBagConstraints();
		gbc_saveUserButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveUserButton.gridwidth = 2;
		gbc_saveUserButton.gridx = 0;
		gbc_saveUserButton.gridy = 5;
		add(saveUserButton, gbc_saveUserButton);
	}
	
	public void addSaveActionListener(ActionListener al) {
		saveUserButton.addActionListener(al);
	}
	
	public String[] getUpdatedUser() {
		if((usernameField.getText().isEmpty() || addressField.getText().isEmpty()
				|| nameField.getText().isEmpty())) {
			throw new NullArgumentException();
		}
		else {
			return new String[] {
					userID.getText(),
					usernameField.getText(),
					nameField.getText(),
					addressField.getText(),
					String.valueOf(isManagerCheckBox.isSelected())
				};
		}
	}
	
	public void resetFields() {
		usernameField.setText("");
		nameField.setText("");
		addressField.setText("");
		isManagerCheckBox.setSelected(false);
	}
	
	public void updateUserDetails(User user) {
		userID.setText(user.getId());
		usernameField.setText(user.getUserName());
		nameField.setText(user.getName());
		addressField.setText(user.getAddress());
		isManagerCheckBox.setSelected(user.getManager());
	}
}
