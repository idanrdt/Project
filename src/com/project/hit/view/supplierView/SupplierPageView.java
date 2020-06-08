package com.project.hit.view.supplierView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.plaf.DimensionUIResource;
import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.details.User;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class SupplierPageView implements SupplierView {
	
	private SupplierController controller;
	private EditSearchSupplierPanel editPanel;
	private AddSupplierPanel addPanel;
	private DeleteSupplierPanel deletePanel;
	private JFrame mainFrame;
	private User user;
	
	/**
	 * Constructor of the view.
	 * @param user - the {@link User} that logged in.
	 */
	public SupplierPageView(User user) {
		this.user = user;
	}
	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void close() {
		mainFrame.dispose();
	}
	
	@Override
	public void setController(SupplierController controller) {
		this.controller = controller;
	}
	
	/**
	 * Create and show the Window.
	 */
	private void createAndShowGUI() {
		mainFrame = new JFrame("User: "+ user.getUserName());
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setPreferredSize(new DimensionUIResource(370, 450));
		
        addPanel = new AddSupplierPanel();
		editPanel = new EditSearchSupplierPanel();
		deletePanel = new DeleteSupplierPanel(controller.getSupplierSet());
		
		addEditListeners(editPanel);
		addAddSupplierListeners(addPanel);
		addDeleteSupplierListeners(deletePanel);
		
		JTabbedPane mainPanel = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.addTab("Edit Supplier", null, editPanel, null);
		mainPanel.addTab("Add Supplier", null, addPanel, null);
		mainPanel.addTab("Delete Supplier", null, deletePanel, null);
		
		mainFrame.add(mainPanel);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);		
	}
	
	/**
	 * Adds {@link ActionListeners} to the {@link EditSearchSupplierPanel}.
	 * @param edit - the panel.
	 */
	private void addEditListeners(EditSearchSupplierPanel edit) {
		edit.addFindButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					edit.setTextToFileds(controller.findSupplier(Integer.parseInt(edit.getSupplierNumberFromUser())));
				}
				catch(NumberFormatException | SupplierNotFoundException nfe) {
					setError("Supplier not found.");
				}
			}
		});
		
		edit.addSaveButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.updateSupplier(edit.getUpdatedSupplier());
					JOptionPane.showMessageDialog(new JFrame(),"Supplier updated!","Succsess",JOptionPane.INFORMATION_MESSAGE);
				} catch (SupplierNotFoundException e1) {
					setError(e1.getMessage());
				} 
			}
		});
		
		edit.addResetButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				edit.resetFields();
			}
		});
	}
	
	/**
	 * Adds {@link ActionListener} to the {@link AddSupplierPanel}.
	 * @param add - the panel.
	 */
	private void addAddSupplierListeners(AddSupplierPanel add) {
		add.addAddButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.addSupplier(add.getNewSupplier());
					JOptionPane.showMessageDialog(new JFrame(),"Supplier Created!","Succsess",JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException | EnumNameNotFoundException e1) {
					setError("There was a problem saving your supplier.\nPlease try again later.");
				} catch (NullArgumentException e1) {
					setError("One or more fields are empty.\nPlease fill all of the fields.");
				}
			}
		});
		
		add.addResetButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add.resetFields();
			}
		});
	}
	
	/**
	 * Adds {@link ActionListener} to the {@link DeleteSupplierPanel}.
	 * @param delete - the panel.
	 */
	private void addDeleteSupplierListeners(DeleteSupplierPanel delete) {
		delete.addRemoveActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.removeSupplier(delete.removeSupplier());
					delete.setValues(controller.getSupplierSet());
					JOptionPane.showMessageDialog(new JFrame(),"Supplier Deleted!","Succsess",JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException | EnumNameNotFoundException | SupplierNotFoundException e1) {
					setError(e1.getMessage());
				}
			}
		});
		
		delete.addRefreshActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete.setValues(controller.getSupplierSet());
			}
		});
	}
	
	/**
	 * Creates and display an Error message to the user.
	 * @param msg - {@link String} Message to display.
	 */
	private void setError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg,"Error",JOptionPane.ERROR_MESSAGE);
	}
}
