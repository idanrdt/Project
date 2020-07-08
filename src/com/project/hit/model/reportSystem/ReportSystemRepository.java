package com.project.hit.model.reportSystem;

import java.io.IOException;
import java.util.Set;

import com.project.hit.model.orderSystem.Order;

public interface ReportSystemRepository {
	
    /**
     * the function generate report the function is built like builder design pattern
     * Generate the report dynamically.
     * The related functions are: startDate, endDate, supplierId
     * and for the generate the report the function createReport
     * @return ReportSystem
     */
    public ReportCreator genarateReport();
    
    /**
     * Export the {@link Report} to excel and save it.
     * @param Url path to save the file
     * @throws IOException If there is a problem opening the file
     */
    public void exportToExcel(String Url) throws IOException;
    
    /**
     * Gets the {@link Report} {@link Order} {@link Set}.
     * @return The {@link Order} {@link Set}.
     */
    public Set<Order> getReport();
}
