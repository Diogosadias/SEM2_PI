package app.domain.dto;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class TestDto {

    private long code;
    private String type;
    private String description;
    private long clientCC;
    String nhsCode;
    List<Parameter> parameters = new ArrayList<>();

    public TestDto(){}

    /**
     *
     * @param code
     * @param description
     * @param clientCC
     */
    public TestDto(long code,String description, long clientCC){
        this.code = code;
        this.description = description;
        this.clientCC = clientCC;
    }

    public long getCode(){
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public long getClientCC() {
        return clientCC;
    }

    public String getNhsCode() {
        return nhsCode;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }


    public void setNhsCode(String nhsCode) {
        this.nhsCode = nhsCode;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String toString(){
        return  "Collection Method:"+description+" \nCode:"+code;
    }

}
