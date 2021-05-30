package app.domain.model;

import java.util.ArrayList;

/**
 * ReportStore - Class responsible for managing Reports
 *
 */

public class ReportStore {

    /**
     * Initialize a list of report.
     */
    private final ArrayList<Report> reportlist;

    /**
     * Initialize a list of Report's store.
     */
    public ReportStore(){
        reportlist = new ArrayList<>();
    }

    /**
     * Creates a Report instance and returns it.
     *
     * @param diagnosis Report's diagnosis
     * @param test Reports's test
     *
     * @return Report
     */
    public Report createReport(String diagnosis, Test test){
        if(diagnosis==null || test ==null){
            return null;
        }
        return new Report(diagnosis,test);
    }

    /**
     * Validates Report attributes for business model rules.
     *
     * @param report - Report
     *
     * @return boolean
     */

    public boolean validateReport(Report report){
        if(report!=null) {
            if (!this.reportlist.isEmpty()) {
                for (Report temp : reportlist) {
                    if (temp.equals(report)) {
                        System.out.println("Report is not valid.");
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /**
     * Saves the new Report.
     *
     * @param report - Report Register
     *
     * @return boolean
     */

    public boolean saveReport(Report report){
        if(!validateReport(report))
            return false;

        return this.reportlist.add(report);
    }

    /**
     * Return the Report's list.
     *
     * @param code Test's code
     *
     * @return Report's list
     */

    public Report getReportByTestCode (String code) {
        for(Report r : reportlist) {
            if (r.getTest().getCode().equals(code)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Report: There is no test with that code.");
    }
}
