package com.project.hit.controller;

import com.project.hit.model.Order;

import java.util.Calendar;
import java.util.Set;

public interface ReportSystemRepository {

    public Set<Order> genarateReport();

    public Set<Order> genarateReport(Calendar startDate, Calendar endDate);

    public Set<Order> genarateReport(Calendar startDate, Calendar endDate,int supplierNumber);

    public Set<Order> genarateReport(Calendar startDate, Calendar endDate,String supplierName);
}
