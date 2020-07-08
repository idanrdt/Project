package com.project.hit.model.reportSystem;



import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderSystem;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ReportCreator extends Report {

    private Set<Order> report;

    public ReportCreator(Set<Order> report) {
        this.report = report;
    }

    /**
     * Sets the start date. This function is related to genarateReport.
     * The function gets the start date you want to start to build the report (Optional)
     * @param day
     * @param month
     * @param year
     * @return ReportSystem
     */
    public ReportCreator startDate(int day, int month, int year) {
        super.setStartDate(day, month, year);
        return this;
    }

    /**
     * Sets the end date. This function is related to genarateReport.
     * The function gets the end date you want to build the report (Optional)
     * @param day
     * @param month
     * @param year
     * @return ReportSystem
     */
    public ReportCreator endDate(int day, int month, int year) {
        super.setEndDate(day, month, year);
        return this;
    }

    /**
     * Sets the {@link Supplier} ID. This function is related to genarateReport.
     * The function gets the supplier you want to build a report for him (Optional)
     * @param supplierId
     * @return
     */
    public ReportCreator supplierId(int supplierId) {
        super.setSupplierId(supplierId);
        return this;
    }

    /**
     * To end the function genarateReport process, this function must be called (Required)
     * @return {@link Set} of orders that in the report.
     * @throws ReportEmptyExcption If the {@link Report} is empty.
     * @throws EnumNameNotFoundException If the {@link Report} fails to save.
     * @throws IOException If the {@link Report} fails to Save in the DataBase.
     * @throws ClassNotFoundException If the {@link Report} fails to save.
     */
    public Set<Order> createReport() throws ReportEmptyExcption, EnumNameNotFoundException, IOException, ClassNotFoundException {
        Set<Order> orders = new HashSet<>();
        OrderSystem orderSystem = OrderSystem.getOrderSystem();
        if(this.getSupplierId() == 0){
            orders.addAll(OrderSystem.getOrderSystem().getOrders());
        } else{
            for (Order i : orderSystem.getOrders()){
                if(i.getSupplier().getSupplierId() == this.supplierId){
                    orders.add(i);
                }
            }
        }

        for (Order i : orders){
            if(i.getDate().compareTo(this.startDate) >= 0 && i.getDate().compareTo(this.endDate) <= 0)
            	this.report.add(i);
        }

        if(this.report.isEmpty())
            throw new ReportEmptyExcption("No reports to display due to the data entered");
        return this.report;
    }

}
