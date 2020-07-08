package com.project.hit.view.supplierView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.model.supplierSystem.BankAccount;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierBuilder;

public class AddSupplierPanel extends JPanel {
	
	private static final long serialVersionUID = 100L;
	private JButton addButton;
	private JButton resetButton;
	private JLabel welcomeTitle;
	private JLabel welcomeSubTitle;
	private JLabel supplierNumber;
	private JPanel panel;
	private JLabel companyLabel;
	private JTextField companyField;
	private JLabel supplierNumberLabel;
	private JTextField supplierNumberField;
	private JLabel addressLabel;
	private JTextField addressField;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel bankNameLabel;
	private JTextField bankField;
	private JLabel accountLabel;
	private JTextField accountNumberField;
	private JLabel branchLabel;
	private JTextField branchField;
	
	/**
	 * Create the panel.
	 */
	public AddSupplierPanel() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		welcomeTitle = new JLabel("Add new supplier");
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
		gbl_panel.columnWidths = new int[]{85, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		companyLabel = new JLabel("Company Name:");
		GridBagConstraints gbc_companyLabel = new GridBagConstraints();
		gbc_companyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_companyLabel.anchor = GridBagConstraints.WEST;
		gbc_companyLabel.insets = new Insets(0, 5, 0, 5);
		gbc_companyLabel.gridx = 0;
		gbc_companyLabel.gridy = 0;
		panel.add(companyLabel, gbc_companyLabel);
		
		companyField = new JTextField();
		companyField.setColumns(10);
		GridBagConstraints gbc_companyField = new GridBagConstraints();
		gbc_companyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_companyField.insets = new Insets(5, 0, 5, 0);
		gbc_companyField.gridx = 1;
		gbc_companyField.gridy = 0;
		panel.add(companyField, gbc_companyField);
		
		supplierNumberLabel = new JLabel("Supplier Numer:");
		GridBagConstraints gbc_supplierNumberLabel = new GridBagConstraints();
		gbc_supplierNumberLabel.anchor = GridBagConstraints.WEST;
		gbc_supplierNumberLabel.insets = new Insets(0, 5, 5, 5);
		gbc_supplierNumberLabel.gridx = 0;
		gbc_supplierNumberLabel.gridy = 1;
		panel.add(supplierNumberLabel, gbc_supplierNumberLabel);
		
		supplierNumberField = new JTextField();
		supplierNumberField.setColumns(10);
		GridBagConstraints gbc_supplierNumberField = new GridBagConstraints();
		gbc_supplierNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierNumberField.insets = new Insets(0, 0, 5, 0);
		gbc_supplierNumberField.gridx = 1;
		gbc_supplierNumberField.gridy = 1;
		panel.add(supplierNumberField, gbc_supplierNumberField);
		
		addressLabel = new JLabel("Address:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_addressLabel.insets = new Insets(0, 5, 5, 5);
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 2;
		panel.add(addressLabel, gbc_addressLabel);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.insets = new Insets(0, 0, 5, 0);
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 2;
		panel.add(addressField, gbc_addressField);
		
		phoneLabel = new JLabel("Phone Number:");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneLabel.insets = new Insets(0, 5, 5, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 3;
		panel.add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 3;
		panel.add(phoneField, gbc_phoneField);
		
		emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.insets = new Insets(0, 5, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 4;
		panel.add(emailLabel, gbc_emailLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 4;
		panel.add(emailField, gbc_emailField);
		
		bankNameLabel = new JLabel("Bank Name:");
		GridBagConstraints gbc_bankNameLabel = new GridBagConstraints();
		gbc_bankNameLabel.anchor = GridBagConstraints.WEST;
		gbc_bankNameLabel.insets = new Insets(0, 5, 5, 5);
		gbc_bankNameLabel.gridx = 0;
		gbc_bankNameLabel.gridy = 5;
		panel.add(bankNameLabel, gbc_bankNameLabel);
		
		bankField = new JTextField();
		bankField.setColumns(10);
		GridBagConstraints gbc_bankField = new GridBagConstraints();
		gbc_bankField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bankField.insets = new Insets(0, 0, 5, 0);
		gbc_bankField.gridx = 1;
		gbc_bankField.gridy = 5;
		panel.add(bankField, gbc_bankField);
		
		accountLabel = new JLabel("Account Number:");
		GridBagConstraints gbc_accountLabel = new GridBagConstraints();
		gbc_accountLabel.anchor = GridBagConstraints.WEST;
		gbc_accountLabel.insets = new Insets(0, 5, 5, 5);
		gbc_accountLabel.gridx = 0;
		gbc_accountLabel.gridy = 6;
		panel.add(accountLabel, gbc_accountLabel);
		
		accountNumberField = new JTextField();
		accountNumberField.setColumns(10);
		GridBagConstraints gbc_accountNumberField = new GridBagConstraints();
		gbc_accountNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountNumberField.insets = new Insets(0, 0, 5, 0);
		gbc_accountNumberField.gridx = 1;
		gbc_accountNumberField.gridy = 6;
		panel.add(accountNumberField, gbc_accountNumberField);
		
		branchLabel = new JLabel("Branch Number:");
		GridBagConstraints gbc_branchLabel = new GridBagConstraints();
		gbc_branchLabel.anchor = GridBagConstraints.WEST;
		gbc_branchLabel.insets = new Insets(0, 5, 0, 5);
		gbc_branchLabel.gridx = 0;
		gbc_branchLabel.gridy = 7;
		panel.add(branchLabel, gbc_branchLabel);
		
		branchField = new JTextField();
		branchField.setColumns(10);
		GridBagConstraints gbc_branchField = new GridBagConstraints();
		gbc_branchField.insets = new Insets(0, 0, 5, 0);
		gbc_branchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_branchField.gridx = 1;
		gbc_branchField.gridy = 7;
		panel.add(branchField, gbc_branchField);
		
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
		
		supplierNumber = new JLabel("New label");
		supplierNumber.setVisible(false);
		GridBagConstraints gbc_supplierNumber = new GridBagConstraints();
		gbc_supplierNumber.insets = new Insets(0, 0, 0, 5);
		gbc_supplierNumber.gridx = 0;
		gbc_supplierNumber.gridy = 4;
		add(supplierNumber, gbc_supplierNumber);
	}
	
	/**
	 * Adds new {@link ActionListener} to the add button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addAddButtonListener(ActionListener al) {
		addButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the reset button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addResetButtonListener(ActionListener al) {
		resetButton.addActionListener(al);
	}
	
	/**
	 * Reset all of the fields to empty.
	 */
	public void resetFields() {
		companyField.setText("");
		supplierNumberField.setText("");
		addressField.setText("");
		phoneField.setText("");
		emailField.setText("");
		bankField.setText("");
		accountNumberField.setText("");
		branchField.setText("");
		supplierNumber.setVisible(false);
	}
	
	/**
	 * Create new {@link Supplier} from the user details.
	 * @return a new {@link Supplier}.
	 * @throws NullArgumentException if one of the fields empty.
	 */
	public Supplier getNewSupplier() throws NullArgumentException {
		if(companyField.getText().isEmpty() ||	addressField.getText().isEmpty() ||
				phoneField.getText().isEmpty() || emailField.getText().isEmpty() ||
				bankField.getText().isEmpty() || accountNumberField.getText().isEmpty() ||
				branchField.getText().isEmpty() || phoneField.getText().isEmpty()) {
			throw new NullArgumentException();
		}
		Supplier supplier = new SupplierBuilder()
				.CompanyName(companyField.getText())
				.SupplierPhoneNumber(phoneField.getText())
				.SupplierAddress(addressField.getText())
				.SupplierNumber(phoneField.getText())
				.SupplierEmailAddress(emailField.getText())
				.BankAccount(new BankAccount(bankField.getText(), accountNumberField.getText(), branchField.getText()))
				.build();
		resetFields();
		supplierNumber.setText("Supplier ID: "+supplier.getSupplierId());
		supplierNumber.setVisible(true);
		return supplier;
	}
}
