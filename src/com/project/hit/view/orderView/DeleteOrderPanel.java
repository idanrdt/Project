package com.project.hit.view.orderView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class DeleteOrderPanel extends JPanel {

	private static final long serialVersionUID = 101L;
	private JTable table;
	private Set<Order> set;
	private String[][] orderData;
	private JButton refreshButton;
	private JButton removeButton;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer centerRenderer;
	private String[] columnNames = {"Order Number",
            						"Price",
									"Date"};
	/**
	 * Create the panel.
	 */
    public DeleteOrderPanel(Set<Order> set) {
 
    	setValues(set);
    	
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table = new JTable(orderData, columnNames);        
        
        setTableCellToMiddle();
        
        table.setDefaultRenderer(String.class, centerRenderer);        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        setLayout(new BorderLayout(0, 0));
 
        JScrollPane scrollPane = new JScrollPane(table);
 
        add(scrollPane);
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        removeButton = new JButton("Remove Supplier");
        panel.add(removeButton);
        
        refreshButton = new JButton("Refresh");
        panel.add(refreshButton, BorderLayout.EAST);
    }
    
    /**
	 * Adds new {@link ActionListener} to the remove button.
	 * @param al- the {@link ActionListener}.
	 */
    public void addRemoveActionListener(ActionListener al) {
    	removeButton.addActionListener(al);
    }
    
    /**
	 * Adds new {@link ActionListener} to the refresh button.
	 * @param al- the {@link ActionListener}.
	 */
    public void addRefreshActionListener(ActionListener al) {
    	refreshButton.addActionListener(al);
    }
    
    /**
     * Remove the selected row from the {@link JTable}
     * @return the {@link Supplier} to remove.
     * @throws SupplierNotFoundException if the {@link Supplier} not found.
     */
    public Order removeOrder() throws SupplierNotFoundException {
    	for(Order order : set) {
    		if(order.getOrderNumber() == Integer.parseInt(orderData[table.getSelectedRow()][0])) {
    			return order;
    		}
    	}
    	throw new SupplierNotFoundException("Delete not possiable");
    }
    
    /**
     * Reset the {@link JTable} to the received {@link Set}.
     * @param set - the list of {@link Supplier}.
     */
    public void setValues(Set<Order> set) {
    	this.set = set;
    	orderData = new String[set.size()][3];
        int i = 0;
        for(Order order : set) {
        	orderData[i][0] = new String(String.valueOf(order.getOrderNumber()));
        	orderData[i][1] = new String(String.valueOf(order.getPrice()));
        	orderData[i][2] = new String(order.getDate().toString());
        	i++;
        }
        
        if(table != null) {
	        tableModel = new DefaultTableModel(orderData, columnNames);
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
