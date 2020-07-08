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
    
    /**
     * Update the {@link User} name.
     * @param name - new name for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editName(String name){
        this.user.setName(name);
        return this;
    }
    
    /**
     * Update the {@link User} address.
     * @param name - new address for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editAddress(String address){
        this.user.setAddress(address);
        return this;
    }
    
    /**
     * Update the {@link User} UserName.
     * @param name - new UserName for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editUserName(String userName){
        this.user.setUsername(userName);
        return this;
    }
    
    /**
     * Update the {@link User} manager access.
     * @param name - new access for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editIsManager(boolean b){
        this.user.setManagerAccess(b);
        return this;
    }
    
    /**
     * Update the {@link User} report access.
     * @param name - new access for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editReportSystem(boolean b){
        this.user.setReportSystem(b);
        return this;
    }
    
    /**
     * Update the {@link User} supplier access.
     * @param name - new access for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editManageSupplierAccsess(boolean b){
        this.user.setManagerAccess(b);
        return this;
    }
    
    /**
     * Update the {@link User} order access.
     * @param name - new access for the {@link User}.
     * @return This {@link UserUpdater} instance
     */
    public UserUpdater editOrderSystemAccsess(boolean b){
        this.user.setOrderSysteMaccsess(b);
        return this;
    }
    
    /**
     * Save the updated user to the DataBase.
     * @return the {@link user} to that saves.
     * @throws IOException If the {@link User} fails to save in the DataBase.
     * @throws EnumNameNotFoundException If the {@link User} fails to save.
     */
    public User update() throws IOException, EnumNameNotFoundException {
        FileManger<User> fileManger = new FileManger<>();

        fileManger.saveToFile(this.users, FileNameSelect.USERFILE);

        return this.user;
    }
}
