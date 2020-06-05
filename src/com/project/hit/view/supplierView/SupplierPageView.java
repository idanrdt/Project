package com.project.hit.view.supplierView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.model.managerSystem.details.User;

public class SupplierPageView implements SupplierView {
	
	private SupplierController controller;
	private EditSearchSupplierPanel editPanel;
	private JFrame mainFrame;
	private User user;
	
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
		editPanel = new EditSearchSupplierPanel();
		mainFrame.add(editPanel);
		addEditListeners(editPanel);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	private void addEditListeners(EditSearchSupplierPanel edit) {
		edit.addFindButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//edit.setTextToFileds(controller.findSupplier());
			}
		});
		
		edit.addSaveButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
	 * Creates and display an Error message to the user.
	 * @param msg - {@link String} Message to display.
	 */
	private void setError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg+"\nPlease contect your Administrator","Error",JOptionPane.ERROR_MESSAGE);
	}
}
