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
		 
	private static final long serialVersionUID = 101L;
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
	/**
	 * Create the panel.
	 */
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
    public Supplier removeSupplier() throws SupplierNotFoundException {
    	for(Supplier supplier : set) {
    		if(String.valueOf(supplier.getSupplierId()).equals(supData[table.getSelectedRow()][2])) {
    			return supplier;
    		}
    	}
    	throw new SupplierNotFoundException("Delete not possiable");
    }
    
    /**
     * Reset the {@link JTable} to the received {@link Set}.
     * @param set - the list of {@link Supplier}.
     */
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
    
    /**
     * Sets the cell data to the center.
     */
    private void setTableCellToMiddle() {
        for(int i = 0;i<columnNames.length;i++) {
        	table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
}
