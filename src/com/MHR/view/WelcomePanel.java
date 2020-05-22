package com.MHR.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WelcomePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel welcomeTitle = new JLabel("Welcome to MHR");
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints  comp = new GridBagConstraints();
		comp.fill = GridBagConstraints.HORIZONTAL;
		comp.gridx = 0;
		comp.gridy = 0;
		add(welcomeTitle, comp);
		
		JLabel welcomeSubTitle = new JLabel("Please login to use the program");
		welcomeSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comp.gridx = 0;
		comp.gridy = 1;
		add(welcomeSubTitle, comp);

	}

}
