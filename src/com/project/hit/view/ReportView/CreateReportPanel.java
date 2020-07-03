package com.project.hit.view.ReportView;

import javax.swing.JPanel;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;
import java.awt.Font;

public class CreateReportPanel extends JPanel {
	
	private JButton createButton;
	private JButton changeLocationButton;
	private JTextField supplierTextField;
	private JDatePicker startDatePicker;
	private JDatePicker endDatePicker;
	private JLabel saveLocationLabel;
	private String saveLocation;
	/**
	 * Create the panel.
	 */
	public CreateReportPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel startDateLabel = new JLabel("Start Date");
		GridBagConstraints gbc_startDateLabel = new GridBagConstraints();
		gbc_startDateLabel.insets = new Insets(5, 0, 5, 5);
		gbc_startDateLabel.gridx = 0;
		gbc_startDateLabel.gridy = 0;
		add(startDateLabel, gbc_startDateLabel);
		
		JLabel endDateLabel = new JLabel("End Date");
		GridBagConstraints gbc_endDateLabel = new GridBagConstraints();
		gbc_endDateLabel.insets = new Insets(5, 0, 5, 5);
		gbc_endDateLabel.gridx = 1;
		gbc_endDateLabel.gridy = 0;
		add(endDateLabel, gbc_endDateLabel);
		
		JLabel supplierNumberLabel = new JLabel("Supplier Number");
		GridBagConstraints gbc_supplierNumberLabel = new GridBagConstraints();
		gbc_supplierNumberLabel.insets = new Insets(5, 0, 5, 5);
		gbc_supplierNumberLabel.gridx = 2;
		gbc_supplierNumberLabel.gridy = 0;
		add(supplierNumberLabel, gbc_supplierNumberLabel);
		
		supplierTextField = new JTextField();
		GridBagConstraints gbc_supplierNumberTextField = new GridBagConstraints();
		gbc_supplierNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_supplierNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_supplierNumberTextField.gridx = 2;
		gbc_supplierNumberTextField.gridy = 1;
		add(supplierTextField, gbc_supplierNumberTextField);
		supplierTextField.setColumns(10);
		
		createButton = new JButton("Create Report");
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.insets = new Insets(5, 5, 5, 5);
		gbc_createButton.gridx = 0;
		gbc_createButton.gridy = 4;
		add(createButton, gbc_createButton);
		
		changeLocationButton = new JButton("Change Save Location");
		GridBagConstraints gbc_changeLocationButton = new GridBagConstraints();
		gbc_changeLocationButton.insets = new Insets(5, 5, 5, 5);
		gbc_changeLocationButton.gridx = 2;
		gbc_changeLocationButton.gridy = 4;
		add(changeLocationButton, gbc_changeLocationButton);
		
		startDatePicker = new JDateComponentFactory().createJDatePicker();
		startDatePicker.setTextEditable(false);
		startDatePicker.setShowYearButtons(true);
		startDatePicker.getModel().setValue(null);
		GridBagConstraints gbc_startDatePicker = new GridBagConstraints();
		gbc_startDatePicker.insets = new Insets(0, 0, 0, 5);
		gbc_startDatePicker.gridx = 0;
		gbc_startDatePicker.gridy = 1;
		add((JComponent)startDatePicker, gbc_startDatePicker);
		
		endDatePicker = new JDateComponentFactory().createJDatePicker();
		endDatePicker.setTextEditable(false);
		endDatePicker.setShowYearButtons(true);
		endDatePicker.getModel().setValue(null);
		GridBagConstraints gbc_endDatePicker = new GridBagConstraints();
		gbc_endDatePicker.insets = new Insets(0, 0, 0, 5);
		gbc_endDatePicker.gridx = 1;
		gbc_endDatePicker.gridy = 1;
		add((JComponent)endDatePicker, gbc_endDatePicker);
		
		saveLocation = "C:\\temp";
		saveLocationLabel = new JLabel("Saving Location: " + saveLocation);
		saveLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_saveLocationLabel = new GridBagConstraints();
		gbc_saveLocationLabel.insets = new Insets(5, 0, 5, 5);
		gbc_saveLocationLabel.gridx = 1;
		gbc_saveLocationLabel.gridy = 3;
		add(saveLocationLabel, gbc_saveLocationLabel);
	}
	
	public void AddCreateButtonListener(ActionListener al) {
		createButton.addActionListener(al);
	}
	
	public void AddChangeLocationButtonActionListener(ActionListener al) {
		changeLocationButton.addActionListener(al);
	}
	
	public void changeSaveLocation(String location) {
		saveLocation = location;
		saveLocationLabel.setText("Saving location:" + saveLocation);
	}
	
	public String getSupplierNumber() {
		return supplierTextField.getText();
	}
	
	public LocalDate getStartDate() {
		return LocalDate.of(startDatePicker.getModel().getYear(), startDatePicker.getModel().getMonth(), startDatePicker.getModel().getDay());
	}
	
	public LocalDate getEndDate() {
		return LocalDate.of(endDatePicker.getModel().getYear(), endDatePicker.getModel().getMonth(), endDatePicker.getModel().getDay());
	}
	
	
}
