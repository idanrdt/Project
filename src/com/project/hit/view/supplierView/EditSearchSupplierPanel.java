package com.project.hit.view.supplierView;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.project.hit.model.supplierSystem.BankAccount;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierBuilder;

import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EditSearchSupplierPanel extends JPanel {
	
	private static final long serialVersionUID = 103L;
	private JTextField supplierIDField;
	private JTextField companyField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField bankField;
	private JTextField accoundnumberField;
	private JTextField branchField;
	private JTextField expencesField;
	private DocumentFilter up8NumbersFilter;
	
	private JButton findButton;
	private JButton saveButton;
	private JButton resetButton;
	private JLabel welcomeTitle;
	private JLabel welcomeSubTitle;

	/**
	 * Create the panel.
	 */
	public EditSearchSupplierPanel() {
		
		up8NumbersFilter = new NumberFilter();
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		welcomeTitle = new JLabel("Edit supplier details");
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_welcomeTitle = new GridBagConstraints();
		gbc_welcomeTitle.gridwidth = 3;
		gbc_welcomeTitle.insets = new Insets(0, 0, 5, 0);
		gbc_welcomeTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_welcomeTitle.gridx = 0;
		gbc_welcomeTitle.gridy = 0;
		add(welcomeTitle, gbc_welcomeTitle);
		
		welcomeSubTitle = new JLabel("Please insert a valid supplier ID");
		welcomeSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_welcomeSubTitle = new GridBagConstraints();
		gbc_welcomeSubTitle.insets = new Insets(0, 5, 5, 5);
		gbc_welcomeSubTitle.gridwidth = 3;
		gbc_welcomeSubTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_welcomeSubTitle.gridx = 0;
		gbc_welcomeSubTitle.gridy = 1;
		add(welcomeSubTitle, gbc_welcomeSubTitle);
		
		JLabel supplierIDLabel = new JLabel("Supplier ID:");
		GridBagConstraints gbc_supplierIDLabel = new GridBagConstraints();
		gbc_supplierIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_supplierIDLabel.gridx = 0;
		gbc_supplierIDLabel.gridy = 2;
		add(supplierIDLabel, gbc_supplierIDLabel);

		supplierIDField = new JTextField();
		((AbstractDocument)supplierIDField.getDocument()).setDocumentFilter(up8NumbersFilter);
		GridBagConstraints gbc_supplierIDField = new GridBagConstraints();
		gbc_supplierIDField.insets = new Insets(0, 0, 5, 5);
		gbc_supplierIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierIDField.gridx = 1;
		gbc_supplierIDField.gridy = 2;
		add(supplierIDField, gbc_supplierIDField);
		supplierIDField.setColumns(10);
				
		findButton = new JButton("Find");
		GridBagConstraints gbc_findButton = new GridBagConstraints();
		gbc_findButton.anchor = GridBagConstraints.EAST;
		gbc_findButton.insets = new Insets(0, 0, 5, 0);
		gbc_findButton.gridx = 2;
		gbc_findButton.gridy = 2;
		add(findButton, gbc_findButton);
		
		//Upper Panel
		//<----------------------------------------------------->
		//Middle Panel
		
		JPanel innerDetailsPanel = new JPanel();
		innerDetailsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_innerDetailsPanel = new GridBagConstraints();
		gbc_innerDetailsPanel.gridwidth = 3;
		gbc_innerDetailsPanel.gridheight = 2;
		gbc_innerDetailsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_innerDetailsPanel.fill = GridBagConstraints.BOTH;
		gbc_innerDetailsPanel.gridx = 0;
		gbc_innerDetailsPanel.gridy = 3;
		add(innerDetailsPanel, gbc_innerDetailsPanel);
		GridBagLayout gbl_innerDetailsPanel = new GridBagLayout();
		gbl_innerDetailsPanel.columnWidths = new int[]{85, 0};
		gbl_innerDetailsPanel.columnWeights = new double[]{0.0, 1.0};
		innerDetailsPanel.setLayout(gbl_innerDetailsPanel);
		
		JLabel companyLabel = new JLabel("Company Name:");
		GridBagConstraints gbc_companyLabel = new GridBagConstraints();
		gbc_companyLabel.anchor = GridBagConstraints.WEST;
		gbc_companyLabel.insets = new Insets(0, 5, 0, 5);
		gbc_companyLabel.gridx = 0;
		gbc_companyLabel.gridy = 0;
		innerDetailsPanel.add(companyLabel, gbc_companyLabel);
		
		companyField = new JTextField();
		companyField.setEnabled(false);
		GridBagConstraints gbc_companyField = new GridBagConstraints();
		gbc_companyField.insets = new Insets(5, 0, 5, 5);
		gbc_companyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_companyField.gridx = 1;
		gbc_companyField.gridy = 0;
		innerDetailsPanel.add(companyField, gbc_companyField);
		companyField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_addressLabel.insets = new Insets(0, 5, 0, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 1;
		innerDetailsPanel.add(addressLabel, gbc_addressLabel);
		
		addressField = new JTextField();
		addressField.setEnabled(false);
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 1;
		innerDetailsPanel.add(addressField, gbc_addressField);
		addressField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Phone Number:");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneLabel.insets = new Insets(0, 5, 0, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 2;
		innerDetailsPanel.add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setEnabled(false);
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 2;
		innerDetailsPanel.add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.insets = new Insets(0, 5, 0, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 3;
		innerDetailsPanel.add(emailLabel, gbc_emailLabel);
		
		emailField = new JTextField();
		emailField.setEnabled(false);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 3;
		innerDetailsPanel.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel bankLabel = new JLabel("Bank Name:");
		GridBagConstraints gbc_bankLabel = new GridBagConstraints();
		gbc_bankLabel.anchor = GridBagConstraints.WEST;
		gbc_bankLabel.insets = new Insets(0, 5, 0, 5);
		gbc_bankLabel.gridx = 0;
		gbc_bankLabel.gridy = 4;
		innerDetailsPanel.add(bankLabel, gbc_bankLabel);
		
		bankField = new JTextField();
		bankField.setEnabled(false);
		GridBagConstraints gbc_bankField = new GridBagConstraints();
		gbc_bankField.insets = new Insets(0, 0, 5, 5);
		gbc_bankField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bankField.gridx = 1;
		gbc_bankField.gridy = 4;
		innerDetailsPanel.add(bankField, gbc_bankField);
		bankField.setColumns(10);
		
		JLabel accountNumberLabel = new JLabel("Account Number:");
		GridBagConstraints gbc_accountNumberLabel = new GridBagConstraints();
		gbc_accountNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_accountNumberLabel.insets = new Insets(0, 5, 0, 5);
		gbc_accountNumberLabel.gridx = 0;
		gbc_accountNumberLabel.gridy = 5;
		innerDetailsPanel.add(accountNumberLabel, gbc_accountNumberLabel);
		
		accoundnumberField = new JTextField();
		accoundnumberField.setEnabled(false);
		GridBagConstraints gbc_accoundnumberField = new GridBagConstraints();
		gbc_accoundnumberField.insets = new Insets(0, 0, 5, 5);
		gbc_accoundnumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_accoundnumberField.gridx = 1;
		gbc_accoundnumberField.gridy = 5;
		innerDetailsPanel.add(accoundnumberField, gbc_accoundnumberField);
		accoundnumberField.setColumns(10);
		
		JLabel branchLabel = new JLabel("Branch Number:");
		GridBagConstraints gbc_branchLabel = new GridBagConstraints();
		gbc_branchLabel.anchor = GridBagConstraints.WEST;
		gbc_branchLabel.insets = new Insets(0, 5, 0, 5);
		gbc_branchLabel.gridx = 0;
		gbc_branchLabel.gridy = 6;
		innerDetailsPanel.add(branchLabel, gbc_branchLabel);
		
		branchField = new JTextField();
		branchField.setEnabled(false);
		GridBagConstraints gbc_branchField = new GridBagConstraints();
		gbc_branchField.insets = new Insets(0, 0, 5, 5);
		gbc_branchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_branchField.gridx = 1;
		gbc_branchField.gridy = 6;
		innerDetailsPanel.add(branchField, gbc_branchField);
		branchField.setColumns(10);
		
		JLabel expensesLabel = new JLabel("Total Expenses:");
		GridBagConstraints gbc_expensesLabel = new GridBagConstraints();
		gbc_expensesLabel.anchor = GridBagConstraints.WEST;
		gbc_expensesLabel.insets = new Insets(0, 5, 0, 5);
		gbc_expensesLabel.gridx = 0;
		gbc_expensesLabel.gridy = 7;
		innerDetailsPanel.add(expensesLabel, gbc_expensesLabel);
		
		expencesField = new JTextField();
		expencesField.setEnabled(false);
		GridBagConstraints gbc_expencesField = new GridBagConstraints();
		gbc_expencesField.insets = new Insets(0, 0, 5, 5);
		gbc_expencesField.fill = GridBagConstraints.HORIZONTAL;
		gbc_expencesField.gridx = 1;
		gbc_expencesField.gridy = 7;
		innerDetailsPanel.add(expencesField, gbc_expencesField);
		expencesField.setColumns(10);
		
		//Middle Panel
		//<----------------------------------------------------->
		//Lower Panel
		
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.WEST;
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 5;
		add(saveButton, gbc_saveButton);
		
		resetButton = new JButton("Reset");
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.anchor = GridBagConstraints.EAST;
		gbc_resetButton.gridx = 2;
		gbc_resetButton.gridy = 5;
		add(resetButton, gbc_resetButton);
	}
	
	/**
	 * Adds new {@link ActionListener} to the find button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addFindButtonListener(ActionListener al) {
		findButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the save button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addSaveButtonListener(ActionListener al) {
		saveButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the reset button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addResetButtonListener(ActionListener al) {
		resetButton.addActionListener(al);
	}
	
	/**
	 * Sets all the text fields to the {@link Supplier} values.
	 * @param supplier - the {@link Supplier} that contain the values.
	 */
	public void setTextToFileds(Supplier supplier) {
		if(supplier != null) {
			companyField.setText(supplier.getCompanyName());
			addressField.setText(supplier.getSupplierAddress());
			phoneField.setText(supplier.getSupplierNumber());
			emailField.setText(supplier.getSupplierEmailAddress());
			bankField.setText(supplier.getBankAccount().getBankNumber());
			accoundnumberField.setText(supplier.getBankAccount().getAccount());
			branchField.setText(supplier.getBankAccount().getBankBranchNumber());
			expencesField.setText(String.valueOf(supplier.getTotalExpenses()));
			setEditFieldPanelEnable(true);
		}
	}
	
	/**
	 * Reset all the text fields to empty.
	 */
	public void resetFields() {
		supplierIDField.setText("");
		companyField.setText("");
		addressField.setText("");
		phoneField.setText("");
		emailField.setText("");
		bankField.setText("");
		accoundnumberField.setText("");
		branchField.setText("");
		expencesField.setText("");
		saveButton.setEnabled(false);
		setEditFieldPanelEnable(false);
	}
	
	/**
	 * Gets the {@link Supplier} id from the user.
	 * @return the {@link Supplier} id recived from the user.
	 */
	public String getSupplierNumberFromUser() {
		return supplierIDField.getText();
	}
	
	/**
	 * Create new {@link Supplier} from the user values.
	 * @return a new {@link Supplier} object.
	 */
	public Supplier getUpdatedSupplier() {
		return new SupplierBuilder()
				.SupplierAddress(addressField.getText())
				.SupplierNumber(phoneField.getText())
				.SupplierEmailAddress(emailField.getText())
				.BankAccount(new BankAccount(bankField.getText(), accoundnumberField.getText(), branchField.getText()))
				.build();
	}
	
	/**
	 * Enable or disable the text fields.
	 * @param enable - the parameter to enable or disable.
	 */
	private void setEditFieldPanelEnable(Boolean enable) {
		addressField.setEnabled(enable);
		phoneField.setEnabled(enable);
		emailField.setEnabled(enable);
		bankField.setEnabled(enable);
		accoundnumberField.setEnabled(enable);
		branchField.setEnabled(enable);
		saveButton.setEnabled(enable);
	}
}
