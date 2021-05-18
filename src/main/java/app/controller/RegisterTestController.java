package app.controller;

import app.domain.dto.TestTypeDto;
import app.domain.model.Company;
import app.domain.model.TestStore;

import java.util.List;

public class RegisterTestController {

    private Company company;

    private TestStore tStore;

    public void registerTest() {
        this.tStore = company.getTestStore();
        tStore.setCompany(this.company);
    }

    public List getListTestType(long cc) {
        tStore.getClient(cc);
        return tStore.getListTestType();
    }

    public List getListParameters(String category) {
        return tStore.getListParameters(category);
    }

    public void newTest(String type) {
        tStore.newTest(type);
    }

    public boolean addParameterToTest(String parameter) {
        return tStore.addParameterToTest(parameter);
    }

    public void addNhsCodeToTest(String nhs) {
        tStore.addNhsCodeToTest(nhs);
    }

    public boolean validateTest() {
        return tStore.validateTest();
    }

    public void confirmTest() {
        tStore.saveTest();
    }

}
