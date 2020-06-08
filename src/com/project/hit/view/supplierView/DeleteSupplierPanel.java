package com.project.hit.view.supplierView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import javax.swing.JButton;

public class DeleteSupplierPanel extends JPanel {
		 
	/**
	 * 
	 */
	private static final long serialVersionUID = 30L;
	private JButton removeButton;
	private JTable table;
	private Set<Supplier> set;
	private String[][] supData;
	private JButton refreshButton;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer centerRenderer;
	private String[] columnNames = {"Company Name",
            						"Supplier Number",
									"Supplier ID"};
	
    public DeleteSupplierPanel(Set<Supplier> set) {
 
    	setValues(set);
    	
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table = new JTable(supData, columnNames);        
        
        setTableCellToMiddle();
        
        table.setDefaultRenderer(String.class, centerRenderer);        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        setLayout(new BorderLayout(0, 0));
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        removeButton = new JButton("Remove Supplier");
        panel.add(removeButton);
        
        refreshButton = new JButton("Refresh");
        panel.add(refreshButton, BorderLayout.EAST);
    }
    
    public void addRemoveActionListener(ActionListener al) {
    	removeButton.addActionListener(al);
    }
    
    public void addRefreshActionListener(ActionListener al) {
    	refreshButton.addActionListener(al);
    }
    
    public Supplier removeSupplier() throws SupplierNotFoundException {
    	for(Supplier supplier : set) {
    		if(String.valueOf(supplier.getSupplierId()).equals(supData[table.getSelectedRow()][2])) {
    			return supplier;
    		}
    	}
    	throw new SupplierNotFoundException("Delete not possiable");
    }
    
    public void setValues(Set<Supplier> set) {
    	this.set = set;
    	supData = new String[set.size()][3];
        int i = 0;
        for(Supplier supplier : set) {
        	supData[i][0] = new String(supplier.getCompanyName());
        	supData[i][1] = new String(supplier.getSupplierNumber());		        	
        	supData[i][2] = new String(Integer.toString(supplier.getSupplierId()));
        	i++;
        }
        
        if(table != null) {
	        tableModel = new DefaultTableModel(supData, columnNames);
	        table.setModel(tableModel);
        	setTableCellToMiddle();
        }
    }
    
    private void setTableCellToMiddle() {
        for(int i = 0;i<columnNames.length;i++) {
        	table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}
