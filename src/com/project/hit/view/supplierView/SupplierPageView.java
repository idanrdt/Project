package com.project.hit.view.supplierView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.project.hit.controller.supplierController.SupplierController;
import com.project.hit.model.managerSystem.details.User;

public class SupplierPageView implements SupplierView {
	
	private SupplierController controller;
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
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	/**
	 * Creates and display an Error message to the user.
	 * @param msg - {@link String} Message to display.
	 */
	private void setError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg+"\nPlease contect your Administrator","Error",JOptionPane.ERROR_MESSAGE);
	}
}
