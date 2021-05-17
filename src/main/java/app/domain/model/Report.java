package app.domain.model;

public class Report {
    private String diagnosis;
    private Test test;



    Report (String diagnosis, Test test){
    this.diagnosis = diagnosis;
    this.test = test;

    }

}
