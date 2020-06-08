package com.project.hit.controller.supplierController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
import com.project.hit.model.supplierSystem.SupplierUpdater;
import com.project.hit.view.supplierView.SupplierView;

public class SupplierPageController implements SupplierController {
	
	private SupplierView view;
	private MangeSupplier model;
	
	public SupplierPageController(SupplierView view, MangeSupplier model ) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public Supplier findSupplier(int number) throws SupplierNotFoundException {
		Supplier supplier = null;
		supplier = model.findSupplier(number);
		return supplier;
	}

	@Override
	public void updateSupplier(Supplier supplier) throws SupplierNotFoundException {
		try {
			model.UpdateSupplier(supplier);
		} catch (IOException | EnumNameNotFoundException e) {
			throw new SupplierNotFoundException("Cant save supplier.\nPlease contect your administrator!");
		}
	}

	@Override
	public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
		model.addSupplier(supplier);
	}

	@Override
	public void removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
		model.removeSupplier(supplier);
	}

	@Override
	public Set<Supplier> getSupplierSet() {
		return model.getSuppliers();
	}
}
