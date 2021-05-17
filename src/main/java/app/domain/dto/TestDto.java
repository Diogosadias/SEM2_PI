package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Test;

import java.util.ArrayList;

public class TestDto {

    private ArrayList<Test> testlist= new ArrayList<>();

    private String NhsCode;
    private Client client;

    public TestDto(){}

    public TestDto(String NhsCode, Client client){
        this.NhsCode = NhsCode;
        this.client = client;


    }

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
