package com.project.hit.model.managerSystem;

import com.project.hit.fileManager.*;
import com.project.hit.model.managerSystem.details.*;

import java.io.IOException;
import java.util.Set;

public class ManagerProperties implements ManagerPropertiesRepository {

    private Set<User> users;
    private FileManger<User> userFileManger;
    static ManagerProperties managerProperties;

    private ManagerProperties() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        this.userFileManger = new FileManger<>();
        this.users = this.userFileManger.loadFromFile( FileNameSelect.USERFILE);
    }

    public static ManagerProperties getManagerProperties() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        if(managerProperties == null)
            managerProperties = new ManagerProperties();
        return managerProperties;
    }

    @Override
    public void createNewUse(User user) throws UserExistException, IOException, EnumNameNotFoundException {
        try {
        	this.users.contains(managerProperties.findUser(user.getId()));
        }
        catch(NoUserExistsException e) {
        	if(!(this.users.contains(user))){
        		this.users.add(user);
            	this.userFileManger.saveToFile(this.users,FileNameSelect.USERFILE);
            	return;
        	}
        }
        throw new UserExistException("User with ID: " + user.getId() + " already exists in the system ");
    }

    @Override
    public void deleteUser(User user) throws NoUserExistsException, IOException, EnumNameNotFoundException {
        if(!(this.users.contains(user))){
            throw new NoUserExistsException("User with ID: " + user.getId()+ " does not exist in the system");
        }
        this.users.remove(user);
        this.userFileManger.saveToFile(this.users,FileNameSelect.USERFILE);
    }

    @Override
    public User findUser(String userId) throws NoUserExistsException {


        for (User user : this.users){
            if(user.getId() != null && user.getId().equals(userId))
                return user;
        }
        throw new NoUserExistsException("User with ID: " + userId+ "does not exist in the system");
    }

    @Override
    public UserUpdater updater(String userId) throws NoUserExistsException {
        return new UserUpdater(findUser(userId),this.users);
    }

    @Override
    public Set<User> getUsers() {
        return this.users;
    }
}
