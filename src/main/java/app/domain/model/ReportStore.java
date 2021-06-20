package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ReportStore - Class responsible for managing Reports
 *
 */

public class ReportStore extends Store{

    /**
     * The Report.
     */
    private Report report;

    /**
     * Initialize a list of report.
     */
    private final ArrayList<Report> reportlist;

    /**
     * Initialize a list of Report's store.
     */
    public ReportStore(){
        super();
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
        this.report = new Report(diagnosis,test);
        return report;
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

    /**
     * Change the report.
     *
     * @param report Report
     */

    public void setReport (Report report) {
        this.report = report;
    }

    /**
     * Return the List's store.
     *
     * @return List
     */

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        if(this.reportlist.isEmpty()) {
            System.out.println("Report list is empty");
            throw new IllegalArgumentException();
        }
        List<Object> list = new ArrayList<>();
        for(Report r: reportlist) {
            list.add(r);
        }
        return list;
    }

    /**
     * Get the name of the file.
     *
     * @return File's name
     */

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/report.txt";
    }

    /**
     * Read Object from File and import as this store's object class.
     *
     * @param o Object
     */

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.report = (Report) o;
        this.saveReport(report);
    }
}
