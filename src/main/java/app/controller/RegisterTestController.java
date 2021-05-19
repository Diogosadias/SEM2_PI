package app.controller;

import app.domain.model.Company;
import app.domain.model.TestStore;

import java.util.List;

import static app.domain.shared.Constants.ROLE_ADMIN;
import static app.domain.shared.Constants.ROLE_RECEP;

public class RegisterTestController {

    private Company company;

    private TestStore tStore;

    public RegisterTestController() {
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_RECEP)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.tStore = this.company.getTestStore();
        tStore.setCompany(this.company);
    }

    public void registerTest() {

    }

    public boolean checkRegisteredClient(long cc) {
        return tStore.checkRegisteredClient(cc);
    }

    public List getListTestType() {
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

    public Company getCompany () {
        return this.company;
    }

    public TestStore getTestStore() {
        return this.tStore;
    }
}
