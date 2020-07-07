package com.project.hit.view.orderView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import com.project.hit.model.orderSystem.Order;
import com.project.hit.view.supplierView.NumberFilter;

public class EditSearchOrderPanel extends JPanel {

	private JTextField orderNumberField;
	private JTextField supplierCompanyNameField;
	private JTextField priceField;
	private JTextField descriptionField;
	private JTextField dateField;
	private DocumentFilter up8NumbersFilter;
	
	private JButton findButton;
	private JButton saveButton;
	private JButton resetButton;
	private JButton exportToPdfButton;
	private JLabel welcomeTitle;
	private JLabel welcomeSubTitle;
	
	private Order order;

	/**
	 * Create the panel.
	 */
	public EditSearchOrderPanel() {
		
		up8NumbersFilter = new NumberFilter();
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		setLayout(gridBagLayout);
		
		welcomeTitle = new JLabel("Edit order details");
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_welcomeTitle = new GridBagConstraints();
		gbc_welcomeTitle.gridwidth = 3;
		gbc_welcomeTitle.insets = new Insets(0, 0, 5, 0);
		gbc_welcomeTitle.gridx = 0;
		gbc_welcomeTitle.gridy = 0;
		add(welcomeTitle, gbc_welcomeTitle);
		
		welcomeSubTitle = new JLabel("Please insert a valid order number");
		welcomeSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_welcomeSubTitle = new GridBagConstraints();
		gbc_welcomeSubTitle.insets = new Insets(0, 5, 5, 5);
		gbc_welcomeSubTitle.gridwidth = 3;
		gbc_welcomeSubTitle.gridx = 0;
		gbc_welcomeSubTitle.gridy = 1;
		add(welcomeSubTitle, gbc_welcomeSubTitle);
		
		JLabel orderNumberLabel = new JLabel("Order number:");
		GridBagConstraints gbc_orderNumberLabel = new GridBagConstraints();
		gbc_orderNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_orderNumberLabel.gridx = 0;
		gbc_orderNumberLabel.gridy = 2;
		add(orderNumberLabel, gbc_orderNumberLabel);

		orderNumberField = new JTextField();
		((AbstractDocument)orderNumberField.getDocument()).setDocumentFilter(up8NumbersFilter);
		GridBagConstraints gbc_orderNumberField = new GridBagConstraints();
		gbc_orderNumberField.insets = new Insets(0, 0, 5, 5);
		gbc_orderNumberField.gridx = 1;
		gbc_orderNumberField.gridy = 2;
		add(orderNumberField, gbc_orderNumberField);
		orderNumberField.setColumns(10);
				
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
		gbc_innerDetailsPanel.fill = GridBagConstraints.VERTICAL;
		gbc_innerDetailsPanel.gridx = 0;
		gbc_innerDetailsPanel.gridy = 3;
		add(innerDetailsPanel, gbc_innerDetailsPanel);
		GridBagLayout gbl_innerDetailsPanel = new GridBagLayout();
		gbl_innerDetailsPanel.columnWidths = new int[]{85, 0};
		gbl_innerDetailsPanel.columnWeights = new double[]{0.0, 1.0};
		innerDetailsPanel.setLayout(gbl_innerDetailsPanel);
		
		JLabel supplierCompanyNameLabel = new JLabel("Supplier Company Name:");
		GridBagConstraints gbc_supplierCompanyNameLabel = new GridBagConstraints();
		gbc_supplierCompanyNameLabel.anchor = GridBagConstraints.WEST;
		gbc_supplierCompanyNameLabel.insets = new Insets(0, 5, 0, 5);
		gbc_supplierCompanyNameLabel.gridx = 0;
		gbc_supplierCompanyNameLabel.gridy = 0;
		innerDetailsPanel.add(supplierCompanyNameLabel, gbc_supplierCompanyNameLabel);
		
		supplierCompanyNameField = new JTextField();
		supplierCompanyNameField.setEditable(false);
		GridBagConstraints gbc_supplierCompanyNameField = new GridBagConstraints();
		gbc_supplierCompanyNameField.insets = new Insets(5, 0, 5, 5);
		gbc_supplierCompanyNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierCompanyNameField.gridx = 1;
		gbc_supplierCompanyNameField.gridy = 0;
		innerDetailsPanel.add(supplierCompanyNameField, gbc_supplierCompanyNameField);
		supplierCompanyNameField.setColumns(10);
		
		JLabel priceLabel = new JLabel("Price:");
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_priceLabel.insets = new Insets(0, 5, 0, 5);
		gbc_priceLabel.gridx = 0;
		gbc_priceLabel.gridy = 1;
		innerDetailsPanel.add(priceLabel, gbc_priceLabel);
		
		priceField = new JTextField();
		priceField.setEnabled(false);
		GridBagConstraints gbc_priceField = new GridBagConstraints();
		gbc_priceField.insets = new Insets(0, 0, 5, 5);
		gbc_priceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceField.gridx = 1;
		gbc_priceField.gridy = 1;
		innerDetailsPanel.add(priceField, gbc_priceField);
		priceField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description:");
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_descriptionLabel.insets = new Insets(0, 5, 0, 5);
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 2;
		innerDetailsPanel.add(descriptionLabel, gbc_descriptionLabel);
		
		descriptionField = new JTextField();
		descriptionField.setEnabled(false);
		GridBagConstraints gbc_descriptionField = new GridBagConstraints();
		gbc_descriptionField.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionField.gridx = 1;
		gbc_descriptionField.gridy = 2;
		innerDetailsPanel.add(descriptionField, gbc_descriptionField);
		descriptionField.setColumns(10);
		
		JLabel dateLabel = new JLabel("Date:");
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.WEST;
		gbc_dateLabel.insets = new Insets(0, 5, 0, 5);
		gbc_dateLabel.gridx = 0;
		gbc_dateLabel.gridy = 3;
		innerDetailsPanel.add(dateLabel, gbc_dateLabel);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		GridBagConstraints gbc_dateField = new GridBagConstraints();
		gbc_dateField.insets = new Insets(0, 0, 5, 5);
		gbc_dateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateField.gridx = 1;
		gbc_dateField.gridy = 3;
		innerDetailsPanel.add(dateField, gbc_dateField);
		dateField.setColumns(10);
		
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
		
		exportToPdfButton = new JButton("Export To PDF");
		exportToPdfButton.setEnabled(false);
		GridBagConstraints gbc_exportToPDFButton = new GridBagConstraints();
		gbc_exportToPDFButton.anchor = GridBagConstraints.CENTER;
		gbc_exportToPDFButton.gridx = 1;
		gbc_exportToPDFButton.gridy = 5;
		add(exportToPdfButton,gbc_exportToPDFButton);
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
	
	public void addExportPDFButtonListener(ActionListener al) {
		exportToPdfButton.addActionListener(al);
	}
	
	/**
	 * Sets all the text fields to the {@link Order} values.
	 * @param order - the {@link Order} that contain the values.
	 */
	public void setTextToFileds(Order order) {
		if(order != null) {
			this.order = order;
			supplierCompanyNameField.setText(order.getSupplier().getCompanyName());
			priceField.setText(String.valueOf(order.getPrice()));
			descriptionField.setText(order.getDetails());
			dateField.setText(order.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			setEditFieldPanelEnable(true);
		}
	}
	
	/**
	 * Reset all the text fields to empty.
	 */
	public void resetFields() {
		orderNumberField.setText("");
		supplierCompanyNameField.setText("");
		priceField.setText("");
		descriptionField.setText("");
		dateField.setText("");
		saveButton.setEnabled(false);
		setEditFieldPanelEnable(false);
	}
	
	/**
	 * Gets the {@link Order} id from the user.
	 * @return the {@link Order} id received from the user.
	 */
	public String getOrderNumberFromUser() {
		return orderNumberField.getText();
	}
	
	/**
	 * Create {@link String} array that contains all details inserted by the user.
	 * @return {@link String} array.
	 */
	public String[] getUpdatedOrder() {
		return new String[] {
				priceField.getText(),
				descriptionField.getText(),
				};
	}
	
	public Order getCurrentOrder() {
		return this.order;
	}
	
	/**
	 * Enable or disable the text fields.
	 * @param enable - the parameter to enable or disable.
	 */
	private void setEditFieldPanelEnable(Boolean enable) {
		priceField.setEnabled(enable);
		descriptionField.setEnabled(enable);
		saveButton.setEnabled(enable);
		exportToPdfButton.setEnabled(enable);
	}
}
