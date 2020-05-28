package com.project.hit.fileManager;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManger<T extends Serializable> {

    private String selectedFileName;

    public FileManger() {
        selectedFileName = null;
    }

    /**
     * Generic function that save a collections set to file.
     * @param object is a Set<T>.
     * @param select is a {@link FileNameSelect} object that select file type:
     *        <li>USERFILE for save user object.
     *        <li>SUPPLIERFILE for save supplier object.
     *        <li>ORDERFILE for save order object.<br>
     *        example: FileNameSelect.USERFILE.
     * @throws IOException if the file can't open.
     * @throws EnumNameNotFoundException if the enum parameter not exists.
     */
    public void saveToFile(Set<T> object, FileNameSelect select) throws EnumNameNotFoundException, IOException {

        this.selectedFileName = selectedName(select);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.selectedFileName))) {
            oos.writeObject(object);
        }
    }

    /**
     * Generic function that load a collections set from file.
     * @param select is a {@link FileNameSelect} object that select file type:
     *        <li>USERFILE for save user object.
     *        <li>SUPPLIERFILE for save supplier object.
     *        <li>ORDERFILE for save order object.<br>
     *        example: FileNameSelect.USERFILE.
     * @return new {@link HashSet} if no file exists.<br>
     *         else return the saved set.
     * @throws EnumNameNotFoundException if the enum parameter not exists.
     * @throws IOException if the file can't open.
     * @throws ClassNotFoundException if the object does not exist.
     */
    public Set<T> loadFromFile(FileNameSelect select) throws EnumNameNotFoundException, IOException, ClassNotFoundException {

        this.selectedFileName = selectedName(select);
        if(!(new File(this.selectedFileName)).exists()){
            return new HashSet<>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.selectedFileName))) {
            return (Set<T>)ois.readObject();
        }
    }
    
    private String selectedName( FileNameSelect select) throws EnumNameNotFoundException {
        String str;
        String SUPPLIER = "supplier_file";
        String USER = "user_file";
        String ORDER = "order_file";
        switch (select){
            case USERFILE:
                str = USER;
                break;
            case SUPPLIERFILE:
                str = SUPPLIER;
                break;
            case ORDERFILE:
                str = ORDER;
                break;
            default:
                throw new EnumNameNotFoundException("the selected enum dos not exist");
        }
        return str;
    }
}
