package com.project.hit.controller.supplierController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.BankAccount;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierExistsException;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import com.project.hit.model.supplierSystem.SupplierUpdater;
import com.project.hit.view.supplierView.SupplierView;

public class SupplierPageController implements SupplierController {
	
	private MangeSupplier model;
	
	public SupplierPageController(MangeSupplier model) {
		this.model = model;
	}
	
	@Override
	public Supplier findSupplier(int number) throws SupplierNotFoundException {
		Supplier supplier = null;
		supplier = model.findSupplier(number);
		return supplier;
	}

	@Override
	public void updateSupplier(String[] updateArray) throws SupplierNotFoundException {
		try {
			model.updater(Integer.parseInt(updateArray[0]))
			.supplierAddress(updateArray[1])
			.supplierPhoneNumber(updateArray[2])
			.supplierEmailAddress(updateArray[3])
			.bankAccount(new BankAccount(updateArray[4], updateArray[5], updateArray[6]))
			.update();
		} catch (IOException | EnumNameNotFoundException | NumberFormatException e) {
			throw new SupplierNotFoundException("Can't save supplier.\nPlease contect your administrator!");
		}
	}

	@Override
	public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException, SupplierExistsException {
		model.addSupplier(supplier);
	}

	@Override
	public void removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException, SupplierNotFoundException {
		model.removeSupplier(supplier);
	}

	@Override
	public Set<Supplier> getSupplierSet() {
		return model.getSuppliers();
	}
}
