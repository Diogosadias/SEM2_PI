package app.domain.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.Sample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class TestDto {
    
    public String sampleDate;
    private String dateValidation;
    private String dateDiagnosis;
    public String dateChemical;
    private String parameterValue;
    private String code;
    private List<Sample> sampleList = new ArrayList<>();
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
    public TestDto(String code,String description, long clientCC){
        this.code = code;
        this.description = description;
        this.clientCC = clientCC;
    }



    public String getSampleDate() {
        return sampleDate;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public String getDateDiagnosis() {
        return dateDiagnosis;
    }

    public String getDateChemical() {
        return dateChemical;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }
    
    public String getCode(){
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
