package com.project.hit.controller;

public class OrderNotFoundExcption extends Exception {

    private String str;

    public OrderNotFoundExcption(String str) {
        this.str = str;
    }

    @Override
    public String getMessage() {
        return this.str;
    }
}
