package app.domain.model;

import java.util.List;

public class Test {
    private String sampleTime;
    public String sampleDate;
    private String timeValidation;
    private String dateValidation;
    private String timeDiagnosis;
    private String dateDiagnosis;
    private String timeChemical;
    public String dateChemical;
    private String description;
    private String NHSCode;
    private String parameterValue;
    private Client client;
    private List<Sample> sampleList;


    public boolean getInformation(Test test){
        if(test!=null){
            //print information

        }
        return false;
    }

    public boolean checkChemicalDate(Test test){
        if(dateChemical==null){
            return false;
        }
        return true;
    }

    public boolean checkSampleDate(Test test){
        if(sampleDate == null){
            return false;
        }
        return true;
    }

    public boolean checkCompleted(){
        if(true){
            return true;
        }
        return false;
    }

    public String getNHSCode() {
        return NHSCode;
    }

    public void setNHSCode(String NHSCode) {
        this.NHSCode = NHSCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSampleList(Sample sample){
        this.sampleList.add(sample);
    }
}
