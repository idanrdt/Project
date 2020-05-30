package com.project.hit.model;

import com.project.hit.controller.OrderSystem;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Report {
    protected Date startDate;
    protected Date endDate;
    protected int supplierId;

    public Report(){
       this.startDate = Calendar.getInstance().getTime();
       this.endDate = Calendar.getInstance().getTime();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(int day, int month, int year) {
        this.startDate = new GregorianCalendar(year,month,day).getTime();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(int day, int month, int year) {
        this.endDate = new GregorianCalendar(year,month,day).getTime();
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
