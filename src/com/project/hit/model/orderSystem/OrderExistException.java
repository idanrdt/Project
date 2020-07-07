package com.project.hit.model.orderSystem;

public class OrderExistException extends Exception {
	
	private String str;

    public OrderExistException(String str) {
        this.str = str;
    }

    @Override
    public String getMessage() {
        return this.str;
    }
}
