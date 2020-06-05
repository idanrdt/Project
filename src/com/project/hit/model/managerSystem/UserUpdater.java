package com.project.hit.model.managerSystem;
import com.project.hit.fileManager.*;
import com.project.hit.model.managerSystem.details.User;


import java.io.IOException;
import java.util.Set;

public class UserUpdater {

    private User user;
    private Set<User> users;

    public UserUpdater(User user, Set<User> users) {
        this.user = user;
        this.users = users;
    }

    public UserUpdater editName(String name){
        this.user.setName(name);
        return this;
    }

    public UserUpdater editAddress(String address){
        this.user.setAddress(address);
        return this;
    }

    public UserUpdater editUserName(String userName){
        this.user.setUsername(userName);
        return this;
    }

    public UserUpdater editIsManager(boolean b){
        this.user.setManagerAccess(b);
        return this;
    }

    public UserUpdater editReportSystem(boolean b){
        this.user.setReportSystem(b);
        return this;
    }

    public UserUpdater editManageSupplierAccsess(boolean b){
        this.user.setManagerAccess(b);
        return this;
    }

    public UserUpdater editOrderSystemAccsess(boolean b){
        this.user.setOrderSysteMaccsess(b);
        return this;
    }

    public User update() throws IOException, EnumNameNotFoundException {
        FileManger<User> fileManger = new FileManger<>();

        fileManger.saveToFile(this.users, FileNameSelect.USERFILE);

        return this.user;
    }
}
