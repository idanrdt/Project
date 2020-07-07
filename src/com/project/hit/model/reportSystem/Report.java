package com.project.hit.model.reportSystem;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Report {
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int supplierId;

    public Report(){
       this.startDate = LocalDate.of(1900,1,1);
       this.endDate = LocalDate.now();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(int day, int month, int year) {
        this.startDate = LocalDate.of(year, month, day);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(int day, int month, int year) {
        this.endDate = LocalDate.of(year, month, day);
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
