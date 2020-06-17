package com.project.hit.model.managerSystem;


import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.details.User;

import java.io.IOException;
import java.util.Set;

public interface ManagerPropertiesRepository {

    /**
     * the function add a new user to a Set collection and automatic save
     * @param user User object
     * @throws UserExistException if the user exist
     * @throws IOException Any exception thrown by the underlying OutputStream.
     * @throws EnumNameNotFoundException if Enum value does not exist
     */
    public void createNewUser(User user) throws UserExistException, IOException, EnumNameNotFoundException, EnumNameNotFoundException;


    /**
     * the function delete user from the system
     * @param user 
     * @throws NoUserExistsException
     * @throws IOException
     * @throws EnumNameNotFoundException
     */
    public void deleteUser(User user) throws NoUserExistsException, IOException, EnumNameNotFoundException;

    public User findUser(String userId) throws NoUserExistsException;

    public UserUpdater updater(String userId) throws NoUserExistsException;

    public Set<User> getUsers();
    }
