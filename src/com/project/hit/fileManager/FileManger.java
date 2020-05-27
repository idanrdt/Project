package com.project.hit.fileManager;

import java.io.*;

public class FileManger {

    private final String SUPPLIER = "supplier_file";
    private final String USER = "user_file";
    private final String ORDER = "order_file";
    private String selectedFileName = null;

    /**
     *
     * @param object The object you want to save
     * @param select enum type from FileNameSelect enum class
     *               USERFILE for save user object
     *               SUPPLIERFILE for save supplier object
     *               ORDERFILE for save order object
     *               example: FileNameSelect.USERFILE
     * @return return false if the file can`t open or true if open
     * @exception throws Exception if the enum is not found
     */
    public void/*Boolean*/ saveToFile(Object object, FileNameSelect select) throws FileNotFoundException/*Exception*/ {

        this.selectedFileName = selectedName(select);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.selectedFileName))) {
            oos.writeObject(object);
        }catch (IOException e){
            throw new FileNotFoundException(e.getMessage());
            //return false;
        }
        //return true;
    }

    /**
     *
     * @param  select enum type from FileNameSelect enum class
     *         USERFILE for save user object
     *         SUPPLIERFILE for save supplier object
     *         ORDERFILE for save order object
     *         example: FileNameSelect.USERFILE
     * @return Object
     * @throws throws Exception if the enum is not found
     */
    public Object loadFromFile(FileNameSelect select) throws FileNotFoundException/*Exception*/ {

        Object object = null;
        this.selectedFileName = selectedName(select);

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.selectedFileName))) {
            object = ois.readObject();
        }/*catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        */
        catch(IOException e) {
        	throw new FileNotFoundException(e.getMessage());
        }
        catch(ClassNotFoundException e) {
        	throw new FileNotFoundException(e.getMessage());
        }
        return object;
    }

    private String selectedName( FileNameSelect select) /*throws Exception*/ {
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
            	str = null;
                //throw new Exception("the selected enum dos not exist");
        }
        return str;
    }
}
