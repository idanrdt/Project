package com.project.hit.controller;

import com.project.hit.model.Order;
import com.project.hit.model.Report;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class ReportSystem extends Report implements ReportSystemRepository {

    private Set<Order> report;

    public ReportSystem() throws IOException, ClassNotFoundException {
        super();
        this.report = new HashSet<>();
    }

    @Override
    public Set<Order> genarateReport() {
        this.report.addAll(orderSystem.getOrders());
        return this.report;
    }

    @Override
    public Set<Order> genarateReport(Calendar startDate, Calendar endDate) {

        for (Order i: orderSystem.getOrders()) {
            
        }
        return null;
    }

    @Override
    public Set<Order> genarateReport(Calendar startDate, Calendar endDate, int supplierNumber) {
        return null;
    }

    @Override
    public Set<Order> genarateReport(Calendar startDate, Calendar endDate, String supplierName) {
        return null;
    }
}
