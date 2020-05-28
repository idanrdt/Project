package com.project.hit;

import com.project.hit.fileManager.FileManger;
import com.project.hit.fileManager.FileNameSelect;
import com.project.hit.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileManger fileManger = new FileManger();
        List<Supplier> suppliers = new ArrayList<>();
        try {
           suppliers = (List<Supplier>) fileManger.loadFromFile(FileNameSelect.SUPPLIERFILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
