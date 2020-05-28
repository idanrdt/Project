package Supplier;

public class Mange_Supplier  {

    private Supplier supplier;

    public Mange_Supplier(Supplier supplier) {
        this.supplier=supplier;

    }

    public boolean addSupplier(Supplier supplier) {
        return true;
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