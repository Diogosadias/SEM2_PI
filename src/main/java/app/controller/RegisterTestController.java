package app.controller;

import app.domain.model.Company;
import app.domain.model.TestStore;

import java.util.List;

import static app.domain.shared.Constants.ROLE_RECEP;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class RegisterTestController {

    private Company company;

    private TestStore tStore;

    public RegisterTestController() {
        this.company = App.getInstance().getCompany();
        this.tStore = this.company.getTestStore();
        tStore.setCompany(this.company);
    }

    public boolean checkRegisteredClient(long tin) {
        return tStore.checkRegisteredClient(tin);
    }

    public List getListTestType() {
        return tStore.getListTestType();
    }

    public void newTest(String typeCode) {
        tStore.newTest(typeCode);
    }

    public List getListParameters(String categoryCode) {
        tStore.addCategoryToTest(categoryCode);
        return tStore.getListParameters(categoryCode);
    }

    public boolean addParameterToTest(String parameterCode) {
        return tStore.addParameterToTest(parameterCode);
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

    public List getTests() {
        return this.company.getTestStore().getRegisteredTests();
    }
}
