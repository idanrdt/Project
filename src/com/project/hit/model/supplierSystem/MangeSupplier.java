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

    public static MangeSupplier getMangeSupplierSinglton() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        if (mangeSupplierSinglton == null){
            mangeSupplierSinglton = new MangeSupplier();
        }
        return mangeSupplierSinglton;
    }

    /**
     *func to add supplier to the DB
     * @param supplier obj of supplier
     * @throws IOException if the file can't open
     * @throws EnumNameNotFoundException if the enum param that not exists
     */

    public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
        suppliers.add(supplier);

        fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);
    }

    /**
     *func to find file of supplier by supplier number
     * @param supplierNum id of supplier that help us to find him
     * @return obj of supplier
     * @throws SupplierNotFoundException if we can't find this supplier
     */
    public Supplier findSupplier(int supplierNum) throws SupplierNotFoundException {
        for (Supplier i:this.suppliers) {
            if(i.getSupplierId()==supplierNum)
                return i;
        }
        throw new SupplierNotFoundException("");


    }

    /**
     *func to find file of supplier by supplier name
     * @param supplierName string of company supplier name
     * @return obj of supplier
     * @throws SupplierNotFoundException if we can't find this supplier
     */
    public Supplier findSupplier(String supplierName) throws SupplierNotFoundException {
        for (Supplier i:this.suppliers){
            if(i.getCompanyName().equals(supplierName))
                return i;
        }

        throw new SupplierNotFoundException("");
    }

    /**
     *func to enter the updater and make changes
     * @param supplierNumber id of supplier that help us to find him
     * @return obj of supplier update that we used in builder
     * @throws SupplierNotFoundException if we can't find this supplier
     */
    public SupplierUpdater updater(int supplierNumber) throws SupplierNotFoundException {
        return new SupplierUpdater(findSupplier(supplierNumber), this.suppliers);
    }

    /**
     *func to remove file of supplier from the DB
     * @param supplier obj of supplier to remove
     * @return true if we succeed remove this supplier
     * @throws IOException if the file can't open
     * @throws EnumNameNotFoundException if the enum param that not exists
     */
    public boolean removeSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
        if (this.suppliers.contains(supplier)) {
            this.suppliers.remove(supplier);
            fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);

            return true;
        }
        return false;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }
}