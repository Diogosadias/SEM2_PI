package app.domain.dto;

import app.domain.model.Test;

import java.util.ArrayList;

public class TestDto {

    private ArrayList<Test> testlist= new ArrayList<>();

    public TestDto(){}

    public Test getTest(Test test) {
        for(Test temp:testlist){
            if(temp.equals(test)) return null;
        }
        return test;
    }

    public boolean addTest(Test test){
        return testlist.add(test);
    }
}
