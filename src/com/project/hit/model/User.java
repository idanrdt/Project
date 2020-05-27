package com.project.hit.model;

public class User extends Person {

    private String userName, password;
    private boolean isManager, reportSystemAccsess, manageSupplierAccsess, orderSystemAccsess;

    public User(String firstName, String lastName, String id, String address) {
        super(firstName, lastName, id, address);

        this.isManager = this.reportSystemAccsess = this.manageSupplierAccsess = this.orderSystemAccsess = false;
    }

    @Override
    public String getFirstName() {
        return super.address;
    }

    @Override
    public void setFirstName(String firstName) {
        super.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return super.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        super.lastName = lastName;
    }

    @Override
    public String getId() {
        return super.id;
    }

    @Override
    public void setId(String id) {
        super.id = id;
    }

    @Override
    public String getAddress() {
        return super.address;
    }

    @Override
    public void setAddress(String address) {
        super.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        this.isManager = manager;

        if(this.isManager){
            setManageSupplierAccsess(true);
            setOrderSystemAccsess(true);
            setReportSystemAccsess(true);
        }

    }

    public boolean isReportSystemAccsess() {
        return reportSystemAccsess;
    }

    public void setReportSystemAccsess(boolean reportSystemAccsess) {
        this.reportSystemAccsess = reportSystemAccsess;
    }

    public boolean isManageSupplierAccsess() {
        return manageSupplierAccsess;
    }

    public void setManageSupplierAccsess(boolean manageSupplierAccsess) {
        this.manageSupplierAccsess = manageSupplierAccsess;
    }

    public boolean isOrderSystemAccsess() {
        return orderSystemAccsess;
    }

    public void setOrderSystemAccsess(boolean orderSystemAccsess) {
        this.orderSystemAccsess = orderSystemAccsess;
    }


}
