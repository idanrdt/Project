package com.project.hit.model.managerSystem;
public class UserExistException extends ManagerSystemException {

    public UserExistException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
