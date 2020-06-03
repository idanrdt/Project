package com.project.hit.fileManager;

/**
 * Signals that the {@link FileNameSelect} parameter not exist.
 *
 */
public class EnumNameNotFoundException extends Exception {

    private String msg;

    public EnumNameNotFoundException(String msg) {

        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
