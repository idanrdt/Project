package com.project.hit.controller.managerController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.ManagerPropertiesRepository;
import com.project.hit.model.managerSystem.NoUserExistsException;
import com.project.hit.model.managerSystem.UserExistException;
import com.project.hit.model.managerSystem.details.User;
import com.project.hit.model.supplierSystem.BankAccount;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public class ManagerPageController implements ManagerController {

	private ManagerPropertiesRepository model;
	
	public ManagerPageController(ManagerPropertiesRepository model) {
		this.model = model;
	}

	@Override
	public void addUser(User user) throws UserExistException, IOException, EnumNameNotFoundException {
		model.createNewUser(user);
	}

	@Override
	public void deleteUser(User user) throws NoUserExistsException, IOException, EnumNameNotFoundException {
		model.deleteUser(user);
	}

	@Override
	public void editUser(String[] updateArray) throws NoUserExistsException{
		try {
			model.updater(updateArray[0])
			.editAddress(updateArray[1])
			.editIsManager(Boolean.valueOf(updateArray[2]))
			.editName(updateArray[3])
			.editUserName(updateArray[4])
			.update();
		} catch (IOException | EnumNameNotFoundException e) {
			throw new NoUserExistsException("Can't save User.\nPlease contact your administrator");
		}
	}

	@Override
	public Set<User> getUserFile() {
		return model.getUsers();
	}
}
