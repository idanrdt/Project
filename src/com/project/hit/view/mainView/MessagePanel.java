package com.project.hit.view.mainView;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MessagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessagePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel welcomeTitleLabel = new JLabel("Welcome to MHR software");
		welcomeTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(welcomeTitleLabel, gbc_lblNewLabel);
		
		JLabel welcomeSubTitleLabel = new JLabel("Please select one of the systems to begin");
		welcomeSubTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 15, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(welcomeSubTitleLabel, gbc_lblNewLabel_1);

	}

}
