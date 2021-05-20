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




    public long getCode(){
        return code;
    }

    public String toString(){
        return  "Collection Method:"+description+" \nClient:"+client.getCitizenCard();
    }
}
