package app.domain.model;


import java.util.StringTokenizer;

public class Report {
    private String diagnosis;
    private Test test;



    public Report (String diagnosis, Test test){
        checkDiagnosis(diagnosis);
        this.diagnosis = diagnosis;
        this.test = test;

    }

    public String getDiagnosis(){
        return diagnosis;
    }


    public Test getTest(){
        return test;
    }



    public boolean checkDiagnosis(String diagnosis){
        if(diagnosis!= null){
            diagnosis=diagnosis.trim();
            if(countwords(diagnosis)>400){
                throw new IllegalArgumentException("Diagnosis has an Invalid Input! (>400 words)");
            }
            return true;
        }
        throw new IllegalArgumentException("Diagnosis has an Invalid Input!");
    }

    public int countwords(String s){
        StringTokenizer st = new StringTokenizer(s);
        return st.countTokens();
    }

}
