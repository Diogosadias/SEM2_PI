package app.domain.model;

import app.domain.dto.TestDto;

import java.util.ArrayList;

public class TestStore {

    private ArrayList<Test> testlist;


    public TestStore(){
        testlist = new ArrayList<>();
    }


    public Test createTest(){
        return new Test();
    }

    public boolean getTest(Test test){
        if(checkCompleted(test))
            return true;
        return false;
    }

    public boolean checkCompleted(Test test) {
        return test.checkCompleted();
    }

    public TestDto getTestCompletedList() {
        TestDto list = new TestDto();

        for(Test temp : testlist){
            if(getTest(temp)) list.addTest(temp);
            }
        return list;
    }


}

