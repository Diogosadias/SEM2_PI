package app.domain.model;

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
    private String barcode;
    private String parameterValue;


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

}
