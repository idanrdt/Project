package com.project.hit.view.mainView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainManagerPanel extends JPanel {

	private JButton settingsButton;
	
	/**
	 * Create the panel.
	 */
	public MainManagerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		settingsButton = new JButton("Settings");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 10, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		add(settingsButton, gbc_btnNewButton_3);
					
		}
	
	/**
	 * Adds new {@link ActionListener} to the settings button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addSettingsListener(ActionListener al) {
		settingsButton.addActionListener(al);
	}
}
