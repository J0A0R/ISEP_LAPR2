package app.controller;

import app.domain.model.Company;

import java.io.FileNotFoundException;

public class ExportToCsvController {

    private static Company company;

    public ExportToCsvController() {
        if (company == null)
            company = App.getInstance().getCompany();
    }

    public boolean exportFilesToCSV() {

        try {
            company.exportToCsv();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}