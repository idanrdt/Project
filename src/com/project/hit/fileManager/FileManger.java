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
    public void saveToFile(Set<T> object, FileNameSelect select) throws FileNotFoundException {

        this.selectedFileName = selectedName(select);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.selectedFileName))) {
            oos.writeObject(object);
        }catch (IOException e){
        	throw new FileNotFoundException(e.getMessage());
        }
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
	public Set<T> loadFromFile(FileNameSelect select) throws FileNotFoundException {

        this.selectedFileName = selectedName(select);
        if(!(new File(this.selectedFileName)).exists()){
            return new HashSet<T>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.selectedFileName))) {
            return (Set<T>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
        	throw new FileNotFoundException(e.getMessage());
        }
    }
	
	/**
	 * 
	 * @param select - The {@link FileNameSelect} enum that related to a specific file in the database.
	 * @return - {@link String} variable that holds the file name.
	 */
    private String selectedName(FileNameSelect select) {
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
        }
        return str;
    }
}
