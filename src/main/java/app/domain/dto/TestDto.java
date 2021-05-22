package app.domain.dto;

import app.domain.model.Parameter;
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
    private long code;
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
    public TestDto(long code,String description, long clientCC){
        this.code = code;
        this.description = description;
        this.clientCC = clientCC;
    }

    public TestDto(String sampleDate, String dateValidation, String dateDiagnosis, String dateChemical, String parameterValue, long code, String type, String description, long clientCC, String nhsCode) {
        this.sampleDate = sampleDate;
        this.dateValidation = dateValidation;
        this.dateDiagnosis = dateDiagnosis;
        this.dateChemical = dateChemical;
        this.parameterValue = parameterValue;
        this.code = code;
        this.type = type;
        this.description = description;
        this.clientCC = clientCC;
        this.nhsCode = nhsCode;
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
