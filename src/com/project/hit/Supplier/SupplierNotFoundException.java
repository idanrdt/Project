package com.project.hit.Supplier;

public class SupplierNotFoundException extends Exception {

    private String message;


    public SupplierNotFoundException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
