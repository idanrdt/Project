package com.project.hit.controller.supplierController;

import java.io.IOException;
import java.util.Set;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.supplierSystem.Supplier;
import com.project.hit.model.supplierSystem.SupplierNotFoundException;

public interface SupplierController {
	
	/**
	 * Finds the requested {@link Supplier} by ID.
	 * @param number - the {@link Supplier} id.
	 * @return - the requested {@link Supplier} from the Database.
	 * @throws SupplierNotFoundException if the requested {@link Supplier} not found.
	 */
	public Supplier findSupplier(int number) throws SupplierNotFoundException;
	
	/**
	 * Updates the {@link Supplier} values.
	 * @param supplier - the requested {@link Supplier} to update.
	 * @throws SupplierNotFoundException - if the requested {@link Supplier} not found.
	 */
	public void updateSupplier(Supplier supplier) throws SupplierNotFoundException;
	
	/**
	 * Adds new {@link Supplier} to the Database.
	 * @param supplier - the {@link Supplier} to add.
	 * @throws IOException if the addition fails.
	 * @throws EnumNameNotFoundException if the addition fails.
	 */
	public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException;
	
	/**
	 * Remove the requested {@link Supplier} from the Database.
	 * @param supplier - the {@link Supplier} to remove.
	 * @throws IOException if the remove fails.
	 * @throws EnumNameNotFoundException if the remove fails.
	 */
	public void removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException;
	
	/**
	 * Gets the {@link Set} of {@link Supplier} from the Database.
	 * @return {@link Set} of {@link Supplier}.
	 */
	public Set<Supplier> getSupplierSet();
}
