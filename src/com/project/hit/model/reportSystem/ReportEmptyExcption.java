package com.project.hit.model.reportSystem;

public class ReportEmptyExcption extends Exception{

    private String msg;

    public ReportEmptyExcption( String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
