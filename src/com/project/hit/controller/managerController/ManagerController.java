package com.project.hit.controller.managerController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.NoUserExistsException;
import com.project.hit.model.managerSystem.UserExistException;
import com.project.hit.model.managerSystem.details.User;

public interface ManagerController {
	
	/**
	 * Adds the {@link User} to the database.
	 * @param user - the {@link User} to add.
	 * @throws IOException if the addition fails.
	 * @throws EnumNameNotFoundException if the addition fails.
	 * @throws UserExistException if the {@link User} already exist.
	 */
	public void addUser(User user) throws UserExistException, IOException, EnumNameNotFoundException;
	
	/**
	 * Delete the {@link User} from the database.
	 * @param user - the {@link User} to delete.
	 * @throws IOException if the remove fails.
	 * @throws EnumNameNotFoundException if the remove fails.
	 * @throws NoUserExistsException if the {@link User} not found.
	 */
	public void deleteUser(User user) throws NoUserExistsException, IOException, EnumNameNotFoundException;
	
	/**
	 * Edits and save the {@link User} in the database.
	 * @param updateArray - the update parameters array.
	 * @throws NoUserExistsException if the {@link User} not found.
	 */
	public void editUser(String[] updateArray) throws NoUserExistsException;
	
	/**
	 * Returns {@link User} set from the database.
	 * @return {@link Set} of {@link User}.
	 */
	public Set<User> getUserFile();
}
