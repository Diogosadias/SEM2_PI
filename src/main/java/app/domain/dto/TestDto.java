package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Test;

import java.util.ArrayList;

public class TestDto {

    private ArrayList<Test> testlist= new ArrayList<>();

    private long code;
    private String description;
    private Client client;

    public TestDto(){}

    public TestDto(long code,String description, Client client){
        this.code = code;
        this.description = description;
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


    public String toString(){
        return  "Collection Method:"+description+" \nClient:"+client.getCitizenCard();
    }
}
