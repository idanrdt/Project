package com.project.hit.controller.supplierController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public interface SupplierController {
	
	public Supplier findSupplier(int number) throws SupplierNotFoundException;
	
	public void updateSupplier(Supplier supplier) throws SupplierNotFoundException;
	
	public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException;
	
	public void removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException;
	
	public Set<Supplier> getSupplierSet();
}
