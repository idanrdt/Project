package com.project.hit.controller.supplierController;

import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public interface SupplierController {
	
	public Supplier findSupplier(int number) throws SupplierNotFoundException;

}
