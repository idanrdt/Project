package com.project.hit.controller;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Set;

public interface ReportSystemRepository {

    public ReportSystem genarateReport();
    public ReportSystem startDate(int day, int month, int year);
    public ReportSystem endDate(int day, int month, int year);
    public ReportSystem supplierId(int supplierId);

    public Set<Order> createReport() throws ReportEmptyExcption, EnumNameNotFoundException, IOException, ClassNotFoundException;

    public void exportToExcel(String Url) throws IOException;

}
