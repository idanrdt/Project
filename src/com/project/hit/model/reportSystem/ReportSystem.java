package com.project.hit.model.reportSystem;

import com.project.hit.model.orderSystem.Order;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReportSystem extends Report implements ReportSystemRepository {

    private Set<Order> report;

    public ReportSystem() throws IOException, ClassNotFoundException {
        super();
        this.report = new HashSet<>();
    }

    /**
     * the function generate report the function is built like builder design pattern
     * Generate the report dynamically.
     * The related functions are: startDate, endDate, supplierId
     * and for the generate the report the function createReport
     * @return ReportSystem
     */
    @Override
    public ReportCreator genarateReport() {
        this.report = new HashSet<>();
        return new ReportCreator(this.report);
    }

    public Set<Order> getReport() {
        return this.report;
    }

    /**
     * the function save a excel file from the report Set
     * @param Url path to save the file
     * @throws IOException If there is a problem opening the file
     */
    @Override
    public void exportToExcel(String Url) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        // Create a workbook instances
        Workbook wb = new XSSFWorkbook();
        Url = Url + "/"+sdf.format(new Date())+".xlsx";
        OutputStream os = new FileOutputStream(Url);

        // Creating a sheet using predefined class provided by Apache POI
        Sheet sheet = wb.createSheet("Report");

        // Creating a row at specific position
        // using predefined class provided by Apache POI
        String title[] = {"Order number", "Supplier name", "Supplier id", "Price", "Date", "Details"};
        int rowIndex = 0;

        Row row = sheet.createRow(rowIndex++);
        for (int i = 0; i <title.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }

        for (Order i : this.report){

            row = sheet.createRow(rowIndex++);

            Cell cell = row.createCell(0);
            cell.setCellValue(i.getOrderNumber());
            cell = row.createCell(1);
            cell.setCellValue(i.getSupplier().getCompanyName());
            cell = row.createCell(2);
            cell.setCellValue(i.getSupplier().getSupplierId());
            cell = row.createCell(3);
            cell.setCellValue(i.getPrice());
            cell = row.createCell(4);
            cell.setCellValue(sdf.format(i.getDate().getTime()));
            cell = row.createCell(5);
            cell.setCellValue(i.getDetails());
        }
        wb.write(os);
        File file = new File(Url);
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
}
