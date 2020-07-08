package com.project.hit.controller.reportController;

import java.io.IOException;
import java.time.LocalDate;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.reportSystem.ReportCreator;
import com.project.hit.model.reportSystem.ReportEmptyExcption;
import com.project.hit.model.reportSystem.ReportSystemRepository;

public class ReportPageController implements ReportController{

	private ReportSystemRepository model;
	
	/**
	 * The controller constructor.
	 * @param model - The {@link ReportSystemRepository} model.
	 */
	public ReportPageController(ReportSystemRepository model) {
		this.model = model;
	}
	
	
	@Override
	public void excelExport(String location, LocalDate startDate, LocalDate endDate, int supplierNumber) throws IOException, ReportEmptyExcption, ClassNotFoundException {
		ReportCreator creator = model.genarateReport();
		if(startDate != null) {
			creator.startDate(startDate.getDayOfMonth(), startDate.getMonthValue(), startDate.getYear());
		}
		
		if(endDate != null) {
			creator.endDate(endDate.getDayOfMonth(), endDate.getMonthValue(), endDate.getYear());			
		}
		if(supplierNumber >= 0) {
			creator.supplierId(supplierNumber);
		}
		try {
			creator.createReport();
			model.exportToExcel(location);
		} catch (EnumNameNotFoundException e) {
			throw new ClassNotFoundException("Error in creating Report");
		}
	}
}
