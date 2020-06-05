package com.project.hit.model.reportSystem;



import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.orderSystem.Order;
import com.project.hit.model.orderSystem.OrderSystem;

import java.io.IOException;
import java.util.Set;

public class ReportCreator extends Report {

    private Set<Order> report;

    public ReportCreator(Set<Order> report) {
        this.report = report;
    }

    /**
     * The function is related to genarateReport
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
     * The function is related to genarateReport
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
     * The function is related to genarateReport
     * The function gets the supplier you want to build a report for him (Optional)
     * @param supplierId
     * @return
     */
    public ReportCreator supplierId(int supplierId) {
        super.setSupplierId(supplierId);
        return this;
    }

    /**
     * The function is related to genarateReport
     * To end the function genarateReport process, the function createReport must be activated (Required)
     * @return
     * @throws ReportEmptyExcption
     * @throws EnumNameNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
            if(i.getDate().getTime() > this.endDate.getTime())
                this.report.remove(i);
            if(i.getDate().getTime() < this.startDate.getTime()){
                this.report.remove(i);
            }
        }

        if(this.report.isEmpty())
            throw new ReportEmptyExcption("No reports to display due to the data entered");
        return this.report;
    }

}
