package app.domain.dto;

import app.domain.model.OrgRole;
import app.domain.model.Test;
import app.domain.model.TestStore;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {
    private ArrayList<Test> testlist;




    public TestDto getTestCompletedList(TestStore testStore) {
        return testStore.getTestCompletedList();
    }


    public Test getTestInformation(Test test) {
        //possible changes to this
        return test;
    }
}
