package com.project.hit.Supplier;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;

import java.io.IOException;
import java.util.Set;

public class MangeSupplier  {

    private Set<Supplier> suppliers;
    private FileManger<Supplier> fileManger;

    public MangeSupplier() throws EnumNameNotFoundException, IOException, ClassNotFoundException {
        fileManger = new FileManger<Supplier>();
        suppliers = fileManger.loadFromFile(FileNameSelect.SUPPLIERFILE);

    }

    public void addSupplier(Supplier supplier) throws IOException, EnumNameNotFoundException {
        suppliers.add(supplier);

        fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);
    }
    public boolean searchSupplier(Supplier supplier){
        return true;

    }

    public boolean editSupplier(Supplier supplier) {
        supplier.getSupplier_Number();

        return true;

    }
    public boolean removeSupplier(Supplier supplier){
        return true;

    }

}