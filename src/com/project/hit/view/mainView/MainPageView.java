package com.project.hit.view.mainView;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.project.hit.controller.mainController.MainController;
import com.project.hit.controller.mainController.NavigationFailedException;
import com.project.hit.details.User;
import com.project.hit.viewSwitcher.ViewSelect;

public class MainPageView implements MainView{
	
	private User user;
	private JFrame mainFrame;
	private MainController controller;
	private MainPanel panel;
	private MainManagerPanel managerPanel;
	private MessagePanel msgPanel;
	
	/**
	 * Constructor for the panel.
	 * @param user - {@link User} object that logged in.
	 */
	public MainPageView(User user) {
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
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	/**
	 * Create and show the Window.
	 */
	private void createAndShowGUI() {
		mainFrame = new JFrame("User: "+ user.getUserName());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MainPanel();
		msgPanel = new MessagePanel();
		addListenersToButtons(panel);
		setManagerAccess(mainFrame);
		
		mainFrame.add(msgPanel,BorderLayout.NORTH);
		mainFrame.add(panel, BorderLayout.CENTER);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	private void setManagerAccess(JFrame frame) {
		if(user.getManager()) {
			managerPanel = new MainManagerPanel();
			managerPanel.addSettingsListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						controller.navigateTo(ViewSelect.SETTINGS_VIEW, user);
					} catch (NavigationFailedException e1) {
						setError(e1.getMessage());
					}
				}
			});
			frame.add(managerPanel,BorderLayout.SOUTH);
		}
	}
	
	/**
	 * Creates and display an Error message to the user.
	 * @param msg - {@link String} Message to display.
	 */
	private void setError(String msg) {
		JOptionPane.showMessageDialog(new JFrame(),msg+"\nPlease contect your Administrator","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Sets the buttons listeners to {@link MainPanel}.
	 * @param panel - The panel to set the Listeners to.
	 */
	private void addListenersToButtons(MainPanel panel) {
		
		panel.addOrderListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.navigateTo(ViewSelect.ORDER_VIEW, user);
				} catch (NavigationFailedException e1) {
					setError(e1.getMessage());
				}
			}				
		});
		
		panel.addReportListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.navigateTo(ViewSelect.REPORT_VIEW, user);
				} catch (NavigationFailedException e1) {
					setError(e1.getMessage());
				}
			}				
		});
		
		panel.addSupplierListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.navigateTo(ViewSelect.SUPPLIER_VIEW, user);
				} catch (NavigationFailedException e1) {
					setError(e1.getMessage());
				}
			}
		});
	}

}
