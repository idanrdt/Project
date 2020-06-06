package com.project.hit.controller.supplierController;

import com.project.hit.model.supplierSystem.MangeSupplier;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;
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
	public void updateSupplier(Supplier supplier) {
	}
	
}
