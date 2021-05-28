package app.domain.model;

import app.domain.shared.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class State {

    private String designation;
    private Date dateRegistered;
    private Date dateSampleCollected;
    private Date dateChemicalAnalysis;
    private Date dateDiagnosis;
    private Date dateValidation;

    public State(String designation) {

        setDesignation(designation);

    }

    public void setDesignation (String designation) {
        if(!designation.equals(this.designation)) {
            this.designation = designation;
            this.setDateForState(this.designation);
        }
    }


    public void setDateForState (String state) {
        switch (state){
            case Constants.REGISTERED:
                this.dateRegistered = getCurrentDateTime();
                break;
            case Constants.SAMPLE_COLLECTED:
                this.dateSampleCollected = getCurrentDateTime();
                break;
            case Constants.SAMPLE_ANALYSED:
                this.dateChemicalAnalysis = getCurrentDateTime();
                break;
            case Constants.DIAGNOSIS_MADE:
                this.dateDiagnosis = getCurrentDateTime();
                break;
            case Constants.VALIDATED:
                this.dateValidation = getCurrentDateTime();
                break;
        }
    }

    public Date getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String[] temp = formatter.format(new Date()).split(" ");
        String[] tempDate = temp[0].split("-");
        String[] tempTime = temp[1].split(":");
        int year = Integer.parseInt(tempDate[2]);
        int month = Integer.parseInt(tempDate[1]);
        int day = Integer.parseInt(tempDate[0]);
        int hour = Integer.parseInt(tempTime[0]);
        int min = Integer.parseInt(tempTime[1]);
        int sec = Integer.parseInt(tempTime[2]);
        return new Date(year,month,day,hour,min,sec);
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public Date getDateSampleCollected() {
        return dateSampleCollected;
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

    public String currentState() {
        return this.designation;
    }


}
