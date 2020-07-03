package com.project.hit.controller.reportController;

import java.io.IOException;
import java.time.LocalDate;

import com.project.hit.model.reportSystem.ReportEmptyExcption;

public interface ReportController {
	
	public void excelExport(String location, LocalDate startDate, LocalDate endDate, int supplierNumber) throws IOException, ReportEmptyExcption, ClassNotFoundException;
}
