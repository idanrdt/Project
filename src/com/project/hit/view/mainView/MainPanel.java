package com.project.hit.view.mainView;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

	private JButton ordersButton;
	private JButton supplierButton;
	private JButton reportButton;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		ordersButton = new JButton("Manae Orders");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 5, 10, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(ordersButton, gbc_btnNewButton);
		
		supplierButton = new JButton("Manage Suppliers");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 5, 10, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		add(supplierButton, gbc_btnNewButton_1);
		
		reportButton = new JButton("Request Report");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 5, 10, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		add(reportButton, gbc_btnNewButton_2);
					
		}
	
	/**
	 * Adds new {@link ActionListener} to the add {@link Order} button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addOrderListener(ActionListener al) {
		ordersButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the add {@link Report} button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addReportListener(ActionListener al) {
		reportButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the add {@link Supplier} button. 
	 * @param al - the {@link ActionListener}.
	 */
	public void addSupplierListener(ActionListener al) {
		supplierButton.addActionListener(al);
	}

}
