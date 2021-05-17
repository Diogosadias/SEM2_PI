package app.domain.model;

import app.domain.dto.LabOrderDto;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private Company company;

    private Client client;

    private TestMapper mapper;

    private List<Test> testlist;

    public TestStore(){
        testlist = new ArrayList<>();
        this.mapper = new TestMapper();
    }

    public void setCompany (Company company) {
        this.company = company;
    }

    public void getClient(long cc) {
        this.client = company.getCreateClientStore().getClientByCC(cc);
        if (client == null) {
            throw new IllegalArgumentException("Client with CC:" + cc + " is not registered.");
        }
    }

    public LabOrderDto getClientLabOrder() {
        LabOrderStore store = this.company.getLabOrderStore();
        LabOrder order = store.getClientLabOrder(this.client);
        return mapper.toOrderDto(order);
    }

    public Test createTest() {
        return new Test();
    }

    public boolean getTest(Test test) {
        if (checkCompleted(test))
            return true;
        return false;
    }

    public boolean checkCompleted(Test test) {
        return test.checkCompleted();
    }

    public TestDto getTestCompletedList() {
        TestDto list = new TestDto();

        for (Test temp : testlist) {
            if (getTest(temp)) list.addTest(temp);
        }
        return list;
    }

    public void addSampletoTest(Sample sample, Test test) {

        for (Test t : testlist) {
            if (t == test)
                t.setSampleList(sample);
        }
    }

    public List<Test> getTests () {
        if(testlist!=null) {
            if (testlist.isEmpty()) {
                throw new IllegalArgumentException("Organization Test list is empty.");
            }
            return testlist;
        }
        return null;
    }

}
