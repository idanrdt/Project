package com.project.hit.model.supplierSystem;
/**
 * Signals that the {@link Supplier} has not been found in the database.
 */
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
