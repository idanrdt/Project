package com.project.hit.view.ReportView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.project.hit.controller.reportController.ReportController;
import com.project.hit.model.managerSystem.NoUserExistsException;
import com.project.hit.model.reportSystem.ReportEmptyExcption;

public class ReportPageView implements ReportView{
	
	private ReportController controller;
	private JFrame mainFrame;
	private CreateReportPanel createReport;
	private FileChooser fileChoser;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(ReportController controller) {
		this.controller = controller;
	}
	
	private void createAndShowGUI() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		createReport = new CreateReportPanel();
		fileChoser = new FileChooser();
		
		addButtonsToCreateReportPanel();
		
		mainFrame.add(createReport);
		
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	private void addButtonsToCreateReportPanel() {
		createReport.AddCreateButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String supNumber = createReport.getSupplierNumber();
					if(supNumber.isEmpty()) {
						controller.excelExport(createReport.getSaveLocation(), createReport.getStartDate(), createReport.getEndDate(), -1);
					}
					else {
						controller.excelExport(createReport.getSaveLocation(), createReport.getStartDate(), createReport.getEndDate(), Integer.parseInt(supNumber));
					}
				} catch (ClassNotFoundException | IOException e1) {
					setError("There was a problem export your report.\nPlease try again later.");
				} catch (ReportEmptyExcption re) {
					setError("The requested report was empty");
				} catch (NumberFormatException nf) {
					setError("The requested supplier number is invalid");
				}
			}
		});
		createReport.AddChangeLocationButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createReport.changeSaveLocation(fileChoser.getSselectedLocation());
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
