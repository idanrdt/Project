package com.project.hit.controller;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.Order;
import com.project.hit.model.Report;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

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

    @Override
    public ReportSystem genarateReport() {
        return this;
    }

    public ReportSystem startDate(int day, int month, int year) {
        super.setStartDate(day, month, year);
        return this;
    }


    public ReportSystem endDate(int day, int month, int year) {
        super.setEndDate(day, month, year);
        return this;
    }


    public ReportSystem supplierId(int supplierId) {
        super.setSupplierId(supplierId);
        return this;
    }

    public Set<Order> createReport() throws ReportEmptyExcption, EnumNameNotFoundException, IOException, ClassNotFoundException {
        Set<Order> orders = new OrderSystem().getOrders();

        if(this.getSupplierId() == 0){
            this.report.addAll(orders);
        } else{
            for (Order i : orders){
                if(i.getSupplier().getSupplierId() == this.supplierId){
                    this.report.add(i);
                }
            }
        }
        for (Order i : this.report){
            if(i.getDate().after(this.endDate) || i.getDate().before(this.startDate))
                this.report.remove(i);
        }
        if(this.report.isEmpty())
            throw new ReportEmptyExcption("No reports to display due to the data entered");
        return this.report;
    }

    @Override
    public void exportToExcel(String Url) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Create a workbook instances
        Workbook wb = new HSSFWorkbook();
        Url = Url.equals("") ? "" : Url + "/";
        OutputStream os = new FileOutputStream(Url + "report-" + sdf.format(new Date())+ "-.xlsx");

        // Creating a sheet using predefined class provided by Apache POI
        Sheet sheet = wb.createSheet("Report");

        // Creating a row at specific position
        // using predefined class provided by Apache POI

        String title[] = {"Order number", "Supplier name", "Supplier id", "Price", "Date", "Details"};
        int rowIndex =0;

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
    }
}
