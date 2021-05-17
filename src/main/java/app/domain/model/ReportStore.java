package app.domain.model;

import java.util.ArrayList;

public class ReportStore {

    private ArrayList<Report> reportlist;

    public ReportStore(){
        reportlist = new ArrayList<>();
    }


    public Report createReport(String diagnosis, Test test){
        return new Report(diagnosis,test);
    }

    public boolean validateReport(Report report){
        if(report!=null) {
            if (!this.reportlist.isEmpty()) {
                for (Report temp : reportlist) {
                    if (temp.equals(report)) {
                        System.out.println("Report is not valid.");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean saveReport(Report report){
        if(!validateReport(report))
            return false;
        return this.reportlist.add(report);
    }
}