package com.project.hit.model.managerSystem;

public abstract class ManagerSystemException extends Exception {

    protected String msg;

    public ManagerSystemException(String msg) {
        this.msg = msg;
    }

    public abstract String getMessage();
}
