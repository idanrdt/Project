package com.yair.hit.fileManager;

import java.io.*;

public class FileManger {

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
    public Boolean saveToFile(Object object, FileNameSelect select) throws Exception {

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
    public Object loadFromFile(FileNameSelect select) throws Exception {

        Object object=null;
        this.selectedFileName = selectedName(select);

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.selectedFileName))) {
            object = ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return object;
    }

    private String selectedName( FileNameSelect select) throws Exception {
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
                throw new Exception("the selected enum dos not exist");
        }
        return str;
    }
}
