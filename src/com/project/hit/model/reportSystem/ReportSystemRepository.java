package com.project.hit.model.reportSystem;

import java.io.IOException;

public interface ReportSystemRepository {

    public ReportCreator genarateReport();

    public void exportToExcel(String Url) throws IOException;

}
