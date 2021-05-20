package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.Sample;
import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class TestDto {

    private String sampleDate;
    private String dateValidation;
    private String dateDiagnosis;
    private String dateChemical;
    private String description;
    private String NHSCode;
    private String parameterValue;
    private String client;
    private List<Sample> sampleList;

    public TestDto(){}

    /**
     *
     * @param sampleDate
     * @param dateValidation
     * @param dateDiagnosis
     * @param dateChemical
     * @param description
     * @param NHSCode
     * @param parameterValue
     * @param client
     * @param sampleList
     */
    public TestDto(String sampleDate, String dateValidation, String dateDiagnosis, String dateChemical, String description, String NHSCode, String parameterValue, String client, List<Sample> sampleList) {
        this.sampleDate = sampleDate;
        this.dateValidation = dateValidation;
        this.dateDiagnosis = dateDiagnosis;
        this.dateChemical = dateChemical;
        this.description = description;
        this.NHSCode = NHSCode;
        this.parameterValue = parameterValue;
        this.client = client;
        this.sampleList = sampleList;
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

    public String getDescription() {
        return description;
    }

    public String getNHSCode() {
        return NHSCode;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public String getClient() {
        return client;
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    

    public String toString(){
        return  "Collection Method:"+description+" \nClient:"+client;
    }

}
