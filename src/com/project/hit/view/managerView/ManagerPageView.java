package com.project.hit.view.managerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.math3.exception.NullArgumentException;

import com.project.hit.controller.managerController.ManagerController;
import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.NoUserExistsException;
import com.project.hit.model.managerSystem.UserExistException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class ManagerPageView implements ManagerView {
	
	private ManagerController controller;
	private JFrame mainFrame;
	private AddUserPanel addUser;
	private EditUserPanel editPanel;
	private UserTablePanel userTable;
	private JDialog editDialog;
	private JDialog addDialog;
	
	public ManagerPageView() {
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
	public void setController(ManagerController controller) {
		this.controller = controller;
	}
	
	/**
	 * Show the UI.
	 */
	private void createAndShowGUI() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addUser = new AddUserPanel();
		editPanel = new EditUserPanel();
		userTable = new UserTablePanel(controller.getUserFile());
		
		addButtonsToAddPanel();
		addButtonsToEditPanel();
		addButtonsToTablePanel();
		
		mainFrame.add(userTable);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	/**
	 * add {@link ActionListener} to the {@link UserTablePanel} buttons.
	 */
	private void addButtonsToTablePanel() {
		userTable.addAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog = new JDialog();
				addUser.resetFields();
				addDialog.add(addUser);
				addDialog.pack();
				addDialog.setLocationRelativeTo(null);
				addDialog.setVisible(true);
			}
		});
		
		userTable.addEditActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editDialog = new JDialog();
				try {
					editPanel.updateUserDetails(userTable.getSelectedUser());
					editDialog.add(editPanel);
					editDialog.pack();
					editDialog.setLocationRelativeTo(null);
					editDialog.setVisible(true);
				} catch (NoUserExistsException e1) {
					setError(e1.getMessage());
				}
			}
		});
		
		userTable.addDeleteActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.deleteUser(userTable.getSelectedUser());
					userTable.setValues(controller.getUserFile());
				} catch (NoUserExistsException | IOException | EnumNameNotFoundException e1) {
					setError(e1.getMessage());
				} catch (NullArgumentException e1) {
					setError("One or more fields are empty");
				}
			}
		});
		
		userTable.addRefreshActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userTable.setValues(controller.getUserFile());
			}
		});
	}
	
	/**
	 * add {@link ActionListener} to the {@link AddUserPanel} buttons.
	 */
	private void addButtonsToAddPanel() {
		addUser.addCreateActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.addUser(addUser.getUser());
					userTable.setValues(controller.getUserFile());
					addDialog.dispose();
				} catch (UserExistException | IOException | EnumNameNotFoundException e1) {
					setError(e1.getMessage());
				} catch (NullArgumentException e1) {
					setError("One or more fields are empty");
				}
			}
		});
	}
	
	/**
	 * add {@link ActionListener} to the {@link EditUserPanel} buttons.
	 */
	private void addButtonsToEditPanel() {
		editPanel.addSaveActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.editUser(editPanel.getUpdatedUser());
					userTable.setValues(controller.getUserFile());
					editDialog.dispose();
				} catch (NoUserExistsException e1) {
					setError(e1.getMessage());
				}
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
