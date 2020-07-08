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
    
    /**
     * Gets the {@link Report} date in {@link LocalDate} format.
     * @return the {@link Report} date in {@link LocalDate} format.
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    
    /**
     * Sets the {@link Report} start date.
     * @param day
     * @param month
     * @param year
     */
    public void setStartDate(int day, int month, int year) {
        this.startDate = LocalDate.of(year, month, day);
    }
    
    /**
     * Gets the {@link Report} end date in {@link LocalDate} format.
     * @return The {@link Report} date in {@link LocalDate} format.
     */
    public LocalDate getEndDate() {
        return endDate;
    }
    
    /**
     * Sets the {@link Report} end date.
     * @param day
     * @param month
     * @param year
     */
    public void setEndDate(int day, int month, int year) {
        this.endDate = LocalDate.of(year, month, day);
    }
    
    /**
     * Gets the {@link Report} {@link Supplier} ID.
     * @return the {@link Supplier} ID.
     */
    public int getSupplierId() {
        return supplierId;
    }
    
    /**
     * Sets the {@link Report} {@link Supplier} ID.
     * @param supplierId The {@link Supplier} ID.
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
