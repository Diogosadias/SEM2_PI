package app.domain.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.Sample;
import app.domain.model.TestParameter;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class TestDto {

    private Date dateRegistered;
    private Date dateChemicalAnalysis;
    private Date dateDiagnosis;
    private Date dateValidation;

    private String type;
    private String code;
    private List<Sample> sampleList = new ArrayList<>();
    private String description;
    private long clientCC;
    private long tin;
    String nhsCode;
    List<Parameter> parameters = new ArrayList<>();
    List<ParameterCategory> categories = new ArrayList<>();
    List<TestParameter> listTP = new ArrayList<>();

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

    public TestDto(String code,String collectMethod, String type, long clientCC, List<ParameterCategory> categories,List<Parameter> parameters){
        this.code = code;
        this.description = collectMethod;
        this.type = type;
        this.clientCC = clientCC;
        this.categories = categories;
        this.parameters = parameters;
    }

    public TestDto(String code,String description,List<Sample> sampleList){
        this.code = code;
        this.description = description;
        this.sampleList = sampleList;
    }

    public TestDto(String code,long tin,List<TestParameter> listTP){
        this.code = code;
        this.tin = tin;
        this.listTP = listTP;
    }

    public TestDto(String code, Date dateRegistered, Date dateChemicalAnalysis, Date dateDiagnosis) {
        this.code = code;
        this.dateRegistered = dateRegistered;
        this.dateChemicalAnalysis = dateChemicalAnalysis;
        this.dateDiagnosis = dateDiagnosis;
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

    public long getClientCC() {
        return clientCC;
    }

    public String getNhsCode() {
        return nhsCode;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public long getTin() {
        return tin;
    }

    public void setTin(long tin) {
        this.tin = tin;
    }

    public void setNhsCode(String nhsCode) {
        this.nhsCode = nhsCode;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<TestParameter> getListTestParameter() {
        return listTP;
    }

    public void setListTP(List<TestParameter> listTP) {
        this.listTP = listTP;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public Date getDateChemicalAnalysis() {
        return dateChemicalAnalysis;
    }

    public Date getDateDiagnosis() {
        return dateDiagnosis;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateRegistered (Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public void setDateChemicalAnalysis (Date dateChemicalAnalysis) {
        this.dateChemicalAnalysis = dateChemicalAnalysis;
    }

    public void setDateDiagnosis (Date dateDiagnosis) {
        this.dateDiagnosis = dateDiagnosis;
    }

    public void setDateValidation (Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public String toString(){
        String s = "\nTest: " + code;
        if(nhsCode != null) {
            s += " | Nhs: "+ nhsCode;
        }
        if(clientCC != 0) {
            s += " | Client n: "+ clientCC;
        }
        if(type != null) {
            s += " | Type: "+ type;
        }
        if(description != null) {
            s += " | Collection Method: "+ description;
        }
        if(!sampleList.isEmpty()) {
            s += "\nSamples:";
            for (Sample sample : sampleList) {
                s += "\n" + sample.getSampleBarcode();
            }
        }
        return s;
    }

    //US12
    public String Parameters_toString() {
        String s = "\n\nList of Parameter(s) for each Category to be analysed: ";
        for (ParameterCategory category : this.categories) {
            s = s + "\n\n - " + category.getDescription();
            for (Parameter parameter : this.parameters) {
                if (parameter.getCategory().equals(category.getCode()))
                {
                    s += "\n" + parameter.getName();
                }
            }
        }
        return s;
    }

    //US5
    public String Samples_toString() {
        String s = "\nTest n: " + this.code +
                "\nList of Sample(s): \n";
        for (Sample sample : this.sampleList) {
            s += "\n - " + sample.getSampleBarcode();
        }
        return s;
    }

    //US15
    public String validatedDates_toString() {
        String s = "\nTest n: " + this.code +
                "\nDate Registration: " + Constants.FORMATTER.format(this.dateRegistered) +
                "\nDate Chemical Analysis: " + Constants.FORMATTER.format(this.dateChemicalAnalysis) +
                "\nDate Diagnosis: " + Constants.FORMATTER.format(this.dateDiagnosis);
        return s;
    }

    public String datesForGUI_toString() {
        String s = "Test nº: " + this.code +
                "\nRegistration: " + Constants.FORMATTER.format(this.dateRegistered) +
                "\nChemical Analysis: " + Constants.FORMATTER.format(this.dateChemicalAnalysis) +
                "\nDiagnosis: " + Constants.FORMATTER.format(this.dateDiagnosis);
        return s;
    }

}
