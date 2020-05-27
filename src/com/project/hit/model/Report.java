package com.project.hit.model;

import com.project.hit.controller.OrderSystem;

import java.io.IOException;
import java.util.Calendar;

public class Report {
    protected Calendar startDate;
    protected Calendar endDate;
    protected int supplierId;
    protected OrderSystem orderSystem;

    public Report() throws IOException, ClassNotFoundException {
        orderSystem = new OrderSystem();
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
