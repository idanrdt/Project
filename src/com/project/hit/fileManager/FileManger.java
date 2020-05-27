package com.project.hit.fileManager;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManger<T> {

    private final String SUPPLIER = "supplier_file";
    private final String USER = "user_file";
    private final String ORDER = "order_file";
    private String selectedFileName = null;

    /**
     *
     * @param object The object you want to save
     * @param select 0 for save user object
     *               1 for save supplier object
     *               2 for save order object
     */
    public Boolean saveToFile(Set<T> object, FileNameSelect select) throws IOException {

        this.selectedFileName = selectedName(select);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.selectedFileName))) {
            oos.writeObject(object);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @param select is a enum
     *               0 for load user object
     *               1 for load supplier object
     *               2 for load order object
     * @return
     * @throws Exception
     */
    public Set<T> loadFromFile(FileNameSelect select) throws FileNotFoundException, IOException, ClassNotFoundException {


        this.selectedFileName = selectedName(select);
        if(!(new File(this.selectedFileName)).exists()){
            return new HashSet<T>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.selectedFileName))) {
            return (Set<T>) ois.readObject();
        }
    }

    private String selectedName( FileNameSelect select) throws IOException {
        String str;
        switch (select){
            case USERFILE:
                str = this.USER;
                break;
            case SUPPLIERFILE:
                str = this.SUPPLIER;
                break;
            case ORDERFILE:
                str = this.ORDER;
                break;
            default:
                throw new IOException("the selected enum dos not exist");
        }
        return str;
    }
}
