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
    public void createNewUse(User user) throws UserExistException, IOException, EnumNameNotFoundException, EnumNameNotFoundException;


    /**
     * Deletes {@link User} from the DataBase.
     * @param user - The {@link User} to delete.
     * @throws NoUserExistsException If the {@link User} not exist.
     * @throws IOException If the {@link User} fails to save in the DataBase.
     * @throws EnumNameNotFoundException If the {@link User} fails to save.
     */
    public void deleteUser(User user) throws NoUserExistsException, IOException, EnumNameNotFoundException;

    /**
     * Find the requested {@link User} by {@link User} ID.
     * @param userId - The {@link User} ID.
     * @return The requested {@link User}.
     * @throws NoUserExistsException If no {@link User} exist.
     */
    public User findUser(String userId) throws NoUserExistsException;
    
    /**
     * Get {@link UserUpdater} instance for update {@link User} by {@link User} ID.
     * @param userId - the {@link User} ID.
     * @return{@link UserUpdater} instance.
     * @throws NoUserExistsException If no {@link User} exist.
     */
    public UserUpdater updater(String userId) throws NoUserExistsException;
    
    /**
     * Gets the current {@link User} {@link Set}.
     * @return {@link Set} of {@link User}.
     */
    public Set<User> getUsers();
    }
