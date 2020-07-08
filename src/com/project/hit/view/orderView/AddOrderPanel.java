package com.project.hit.view.orderView;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.view.supplierView.NumberFilter;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class AddOrderPanel extends JPanel {
	
	private JButton addButton;
	private JButton resetButton;
	private JLabel welcomeTitle;
	private JLabel welcomeSubTitle;
	private JPanel panel;
	private JLabel supplierNumberLabel;
	private JLabel priceLabel;
	private JLabel descriptionLabel;
	private JTextField supplierNumberField;
	private JTextField priceField;
	private JTextField descriptionField;
	private DocumentFilter up8NumbersFilter;
	
	/**
	 * Create the panel.
	 */
	public AddOrderPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		up8NumbersFilter = new NumberFilter();
		
		welcomeTitle = new JLabel("Add new order");
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_welcomeTitle = new GridBagConstraints();
		gbc_welcomeTitle.gridwidth = 3;
		gbc_welcomeTitle.insets = new Insets(0, 0, 5, 0);
		gbc_welcomeTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_welcomeTitle.gridx = 0;
		gbc_welcomeTitle.gridy = 0;
		add(welcomeTitle, gbc_welcomeTitle);
		
		welcomeSubTitle = new JLabel("Please fill the form below to add");
		welcomeSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_welcomeSubTitle = new GridBagConstraints();
		gbc_welcomeSubTitle.insets = new Insets(0, 5, 5, 0);
		gbc_welcomeSubTitle.gridwidth = 3;
		gbc_welcomeSubTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_welcomeSubTitle.gridx = 0;
		gbc_welcomeSubTitle.gridy = 1;
		add(welcomeSubTitle, gbc_welcomeSubTitle);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		supplierNumberLabel = new JLabel("Supplier Number:");
		GridBagConstraints gbc_supplierNumberLabel = new GridBagConstraints();
		gbc_supplierNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_supplierNumberLabel.insets = new Insets(5, 5, 5, 5);
		gbc_supplierNumberLabel.gridx = 0;
		gbc_supplierNumberLabel.gridy = 0;
		panel.add(supplierNumberLabel, gbc_supplierNumberLabel);
		
		supplierNumberField = new JTextField();
		((AbstractDocument)supplierNumberField.getDocument()).setDocumentFilter(up8NumbersFilter);
		GridBagConstraints gbc_supplierNumberField = new GridBagConstraints();
		gbc_supplierNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierNumberField.insets = new Insets(5, 5, 5, 5);
		gbc_supplierNumberField.gridx = 1;
		gbc_supplierNumberField.gridy = 0;
		panel.add(supplierNumberField, gbc_supplierNumberField);
		
		priceLabel = new JLabel("Price:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_addressLabel.insets = new Insets(0, 5, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 1;
		panel.add(priceLabel, gbc_addressLabel);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.insets = new Insets(0, 5, 5, 5);
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 1;
		panel.add(priceField, gbc_addressField);
		
		descriptionLabel = new JLabel("Description:");
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_descriptionLabel.insets = new Insets(0, 5, 5, 5);
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 2;
		panel.add(descriptionLabel, gbc_descriptionLabel);
		
		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		GridBagConstraints gbc_descriptionField = new GridBagConstraints();
		gbc_descriptionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionField.insets = new Insets(0, 5, 5, 5);
		gbc_descriptionField.gridx = 1;
		gbc_descriptionField.gridy = 2;
		panel.add(descriptionField, gbc_descriptionField);
		
		//Upper Panel
		//<----------------------------------------------------->
		//Lower Panel
		
		addButton = new JButton("Add");
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.WEST;
		gbc_addButton.insets = new Insets(0, 0, 5, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 3;
		add(addButton, gbc_addButton);
		
		resetButton = new JButton("Reset");
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(0, 0, 5, 0);
		gbc_resetButton.anchor = GridBagConstraints.EAST;
		gbc_resetButton.gridx = 2;
		gbc_resetButton.gridy = 3;
		add(resetButton, gbc_resetButton);
	}
	
	/**
	 * Adds new {@link ActionListener} to the add button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void AddAddButtonListener(ActionListener al) {
		addButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the reset button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void AddResetButtonListener(ActionListener al) {
		resetButton.addActionListener(al);
	}
	
	/**
	 * Gets the {@link Supplier} number.
	 * @return The {@link Supplier} number.
	 */
	public String GetSupplierNumber() {
		if(supplierNumberField.getText().isEmpty())
			throw new NullArgumentException();
		return supplierNumberField.getText();
	}
	
	/**
	 * Gets the {@link Order} price.
	 * @return The {@link Order} price.
	 */
	public String getPrice() {
		if(priceField.getText().isEmpty())
			throw new NullArgumentException();
		return priceField.getText();
	}
	
	/**
	 * Gets the {@link Order} description.
	 * @return The {@link Order} description.
	 */
	public String getDescription() {
		if(descriptionField.getText().isEmpty())
			throw new NullArgumentException();
		return descriptionField.getText();
	}
	
	/**
	 * Reset the {@link JTxtFiled} of this {@link JPanel}.
	 */
	public void resetFields() {
		priceField.setText("");
		supplierNumberField.setText("");
		descriptionField.setText("");
	}
}
