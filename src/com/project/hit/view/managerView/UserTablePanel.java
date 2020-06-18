package com.project.hit.view.managerView;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.project.hit.model.managerSystem.details.User;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class UserTablePanel extends JPanel {
	
	private JTable table;
	private JButton refreshTableButton;
	private JButton deleteUserButton;
	private JButton addUserButton;
	private JButton editUserButton;
	private Set<User> set;
	private String[][] userData;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer centerRenderer;
	private String[] columnNames = {"User Name",
            						"Name",
									"is Manager"};
	
	/**
	 * Create the panel.
	 */
	public UserTablePanel() {
		
		setValues(set);
    	
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		table = new JTable(userData, columnNames);        
        
        setTableCellToMiddle();
        
        table.setDefaultRenderer(String.class, centerRenderer);        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
		
		setLayout(new BorderLayout(0, 0));		
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		table = new JTable();
		add(table, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		addUserButton = new JButton("Add User");
		GridBagConstraints gbc_addUserButton = new GridBagConstraints();
		gbc_addUserButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_addUserButton.insets = new Insets(0, 0, 0, 5);
		gbc_addUserButton.gridx = 0;
		gbc_addUserButton.gridy = 0;
		panel.add(addUserButton, gbc_addUserButton);
		
		editUserButton = new JButton("Edit User");
		GridBagConstraints gbc_editUserButton = new GridBagConstraints();
		gbc_editUserButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_editUserButton.insets = new Insets(0, 0, 0, 5);
		gbc_editUserButton.gridx = 1;
		gbc_editUserButton.gridy = 0;
		panel.add(editUserButton, gbc_editUserButton);
		
		deleteUserButton = new JButton("Delete User");
		GridBagConstraints gbc_deleteUserButton = new GridBagConstraints();
		gbc_deleteUserButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_deleteUserButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteUserButton.gridx = 2;
		gbc_deleteUserButton.gridy = 0;
		panel.add(deleteUserButton, gbc_deleteUserButton);
		
		refreshTableButton = new JButton("Refresh");
		GridBagConstraints gbc_refreshTableButton = new GridBagConstraints();
		gbc_refreshTableButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_refreshTableButton.gridx = 1;
		gbc_refreshTableButton.gridy = 1;
		panel.add(refreshTableButton, gbc_refreshTableButton);
	}
	
	/**
	 * Adds new {@link ActionListener} to the add button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addAddActionListener(ActionListener al){
		addUserButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the edit button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addEditActionListener(ActionListener al){
		editUserButton.addActionListener(al);
	}
	/**
	 * Adds new {@link ActionListener} to the remove button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addDeleteActionListener(ActionListener al){
		deleteUserButton.addActionListener(al);
	}
	
	/**
	 * Adds new {@link ActionListener} to the refresh button.
	 * @param al- the {@link ActionListener}.
	 */
	public void addRefreshActionListener(ActionListener al){
		refreshTableButton.addActionListener(al);
	}
	
    /**
     * Remove the selected row from the {@link JTable}
     * @return the {@link User} to remove.
     * @throws SupplierNotFoundException if the {@link Supplier} not found.
     */
    public User removeSupplier() throws SupplierNotFoundException {
    	for(User user : this.set) {
    		if(String.valueOf(user.getUserName()).equals(userData[table.getSelectedRow()][0])) {
    			return user;
    		}
    	}
    	throw new SupplierNotFoundException("Delete not possiable");
    }
	
	/**
     * Reset the {@link JTable} to the received {@link Set}.
     * @param set - the list of {@link User}.
     */
    public void setValues(Set<User> set) {
    	this.set = set;
    	userData = new String[set.size()][3];
        int i = 0;
        for(User user : set) {
        	userData[i][0] = new String(user.getUserName());
        	userData[i][1] = new String(user.getName());		        	
        	userData[i][2] = new String(String.valueOf(user.getManager()));
        	i++;
        }
        
        if(table != null) {
	        tableModel = new DefaultTableModel(userData, columnNames);
	        table.setModel(tableModel);
        	setTableCellToMiddle();
        }
    }
	
	/**
     * Sets the cell data to the center.
     */
    private void setTableCellToMiddle() {
        for(int i = 0;i<columnNames.length;i++) {
        	table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

}
