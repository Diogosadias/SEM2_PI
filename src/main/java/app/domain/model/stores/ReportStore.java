package app.domain.model.stores;

import app.domain.model.Report;
import app.domain.model.Test;

import java.util.ArrayList;

public class ReportStore {

    private final ArrayList<Report> reportlist;

    public ReportStore(){
        reportlist = new ArrayList<>();
    }


    public Report createReport(String diagnosis, Test test){
        if(diagnosis==null || test ==null){
            return null;
        }
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
