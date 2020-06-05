package com.project.hit.fileManager;


public class EnumNameNotFoundException extends Exception {

    private String msg;

    public EnumNameNotFoundException(String msg) {

        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
