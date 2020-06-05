package com.project.hit.model.managerSystem;

public class NoUserExistsException extends ManagerSystemException {

    public NoUserExistsException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
