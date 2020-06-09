package com.project.hit.model.supplierSystem;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;

import java.io.IOException;
import java.util.Set;

public class MangeSupplier  {

    private Set<Supplier> suppliers;
    private FileManger<Supplier> fileManger;
    static MangeSupplier mangeSupplierSinglton;

    private MangeSupplier() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        fileManger = new FileManger<Supplier>();
        suppliers = fileManger.loadFromFile(FileNameSelect.SUPPLIERFILE);

    }
    
    /**
     * Gets an instance of {@link MangeSupplier}.
     * @return {@link MangeSupplier} instance.
     * @throws EnumNameNotFoundException if the enum parameter does not exists.
     * @throws IOException if the file can't open.
     * @throws ClassNotFoundException if  an object does not exist
     */
    public static MangeSupplier getMangeSupplierSinglton() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        if (mangeSupplierSinglton == null){
            mangeSupplierSinglton = new MangeSupplier();
        }
        return mangeSupplierSinglton;
    }

    /**
     * Adds {@link Supplier} to the DB.
     * @param supplier the requested {@link Supplier} to add.
     * @throws IOException if the file can't open.
     * @throws EnumNameNotFoundException if the enum does not exists.
     */
    public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
    	suppliers.add(supplier);
        fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);
    }

    /**
     * Finds the {@link Supplier} by id.
     * @param supplierNum the id of the {@link Supplier} that related to it.
     * @return the requested {@link Supplier}.
     * @throws SupplierNotFoundException if the {@link Supplier} can't be found.
     */
    public Supplier findSupplier(int supplierNum) throws SupplierNotFoundException {
        for (Supplier i:this.suppliers) {
            if(i.getSupplierId()==supplierNum)
                return i;
        }
        throw new SupplierNotFoundException("");
    }

    /**
     * Finds the {@link Supplier} by name.
     * @param supplierName the company name of the {@link Supplier}.
     * @return the requested {@link Supplier}.
     * @throws SupplierNotFoundException if the {@link Supplier} can't be found.
     */
    public Supplier findSupplier(String supplierName) throws SupplierNotFoundException {
        for (Supplier i:this.suppliers){
            if(i.getCompanyName().equals(supplierName))
                return i;
        }

        throw new SupplierNotFoundException("");
    }

    /**
     * Gets the relevant {@link SupplierUpdater} to update a {@link Supplier}.
     * @param supplierNumber the  {@link Supplier} id that's related to it.
     * @return the {@link SupplierUpdater} for updating.
     * @throws SupplierNotFoundException if the {@link Supplier} can't be found.
     */
    public SupplierUpdater updater(int supplierNumber) throws SupplierNotFoundException {
        return new SupplierUpdater(findSupplier(supplierNumber), this.suppliers);
    }

    /**
     * Removes the requested {@link Supplier} from the Database.
     * @param the requested {@link Supplier} to remove.
     * @return true if the {@link Supplier} deleted.
     * @throws IOException if the file can't open.
     * @throws EnumNameNotFoundException if the enum param that not exists.
     */
    public boolean removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
        if (this.suppliers.contains(supplier)) {
            this.suppliers.remove(supplier);
            fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);

            return true;
        }
        return false;
    }
    
    /**
     * Gets the requested {@link Set} of {@link Supplier}.
     * @return {@link Set} that contain multiple {@link Supplier}.
     */
    public Set<Supplier> getSuppliers() {
        return suppliers;
    }
}