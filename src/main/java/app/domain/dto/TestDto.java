package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class TestDto {

    private ArrayList<Test> testlist= new ArrayList<>();

    private long code;
    private String type;
    private String description;
    private long clientCC;
    String nhsCode;
    List<Parameter> parameters = new ArrayList<>();

    public TestDto(){}

    public TestDto(long code,String description, long clientCC){
        this.code = code;
        this.description = description;
        this.clientCC = clientCC;
    }

    public TestDto(long code, String type, String description, long clientCC, String nhsCode, List<Parameter> parameters){
        this.code = code;
        this.type = type;
        this.description = description;
        this.clientCC = clientCC;
        this.nhsCode = nhsCode;
        this.parameters = parameters;
    }



    public long getCode(){
        return code;
    }

    public String toString(){
        return  "Collection Method:"+description+" \nClient:"+this.clientCC;
    }

}
