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
    public Supplier Findsupplier(int suppliernum){
        for (Supplier i:this.suppliers){
            if(i.getSupplierId()==suppliernum)
                return i;
        }
        return null;

    }

    public Supplier Findsupplier(String suppliername){
        for (Supplier i:this.suppliers){
            if(i.getCompanyName().equals(suppliername))
                return i;
        }
        return null;

    }

    public void editSupplier(int suppliernumber) throws IOException, EnumNameNotFoundException {
        Supplier supplier=Findsupplier(suppliernumber);
        supplier.companyName();
        supplier.supplierNumber();
        supplier.supplierAddress();
        supplier.supplierPhoneNumber();
        supplier.supplierEmailAddress();
        supplier.totalExpenses();
        supplier.isDisable();
        supplier.bankAccount();

        suppliers.add(supplier);
        fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);

    }

    public void editSupplier(String suppliername) throws IOException, EnumNameNotFoundException {
        Supplier supplier=Findsupplier(suppliername);
        supplier.companyName();
        supplier.supplierNumber();
        supplier.supplierAddress();
        supplier.supplierPhoneNumber();
        supplier.supplierEmailAddress();
        supplier.totalExpenses();
        supplier.isDisable();
        supplier.bankAccount();

        suppliers.add(supplier);
        fileManger.saveToFile(suppliers,FileNameSelect.SUPPLIERFILE);

    }
    public boolean removeSupplier(Supplier supplier){
        return true;

    }

}