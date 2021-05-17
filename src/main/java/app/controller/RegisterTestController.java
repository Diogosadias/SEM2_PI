package app.controller;

import app.domain.dto.LabOrderDto;
import app.domain.model.Company;
import app.domain.model.TestStore;

public class RegisterTestController {

    private Company company;

    private TestStore tStore;

    public void registerTest() {
        this.tStore = company.getTestStore();
        tStore.setCompany(this.company);
    }

    public LabOrderDto getLabOrder(long cc) {
        tStore.getClient(cc);
        return tStore.getClientLabOrder();
    }

}
