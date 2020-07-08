package com.project.hit.controller.reportController;

import java.io.IOException;
import java.time.LocalDate;

import com.project.hit.model.reportSystem.ReportEmptyExcption;

public interface ReportController {
	
	/**
	 * Export the requested {@link Report} to excel.
	 * @param location - The saving path.
	 * @param startDate - The start date of the report.
	 * @param endDate - The end date of the report
	 * @param supplierNumber - the supplier related to the report.
	 * @throws IOException If the report fail to save.
	 * @throws ReportEmptyExcption If the report not contain any order.
	 * @throws ClassNotFoundException If the report fail to save.
	 */
	public void excelExport(String location, LocalDate startDate, LocalDate endDate, int supplierNumber) throws IOException, ReportEmptyExcption, ClassNotFoundException;
}
