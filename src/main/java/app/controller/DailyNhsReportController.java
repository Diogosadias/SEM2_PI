package app.controller;

import app.domain.model.Company;
import app.domain.shared.Reminder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DailyNhsReportController {

    private Company company;

    private final String FILE_NAME = "covidreportconfigs.csv";

    private String[] header;

    private List<String[]> file;

    private CovidNhsReportController reportController;

    public DailyNhsReportController(){this.company = App.getInstance().getCompany();}

    public void runDailyNhsReportTask()throws FileNotFoundException  {
        importFile();
        String data = "";
        for(String[] line : file) {
            reportController = new CovidNhsReportController();
            reportController.startNewReport();
            if(reportController.startNewReport()) {
                Date initialDate = new Date(line[getColumnIndex("InitialDate_Registration")]);
                Date finalDate = new Date(line[getColumnIndex("FinalDate_Registration")]);
                int histPoints = Integer.valueOf(line[getColumnIndex("HistoricPoints")]);
                double alpha = Double.valueOf(line[getColumnIndex("SignificanceLevel")].replace(",","."));
                data += getDataFromLinearRegression("Registered Tests",initialDate,finalDate,"Daily",histPoints,alpha);
                data += getDataFromLinearRegression("Mean Age",initialDate,finalDate,"Daily",histPoints,alpha);
                data += getDataFromLinearRegression("Multiple",initialDate,finalDate,"Daily",histPoints,alpha);

                data += getDataFromLinearRegression("Registered Tests",initialDate,finalDate,"Weekly",histPoints,alpha);
                data += getDataFromLinearRegression("Mean Age",initialDate,finalDate,"Weekly",histPoints,alpha);
                data += getDataFromLinearRegression("Multiple",initialDate,finalDate,"Weekly",histPoints,alpha);

                dailytask(data);
                //Reminder dailyTask = new Reminder(data);
            }
        }
    }

    private void dailytask(String data) {
        File file = new File("DailyNHSReport.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }
    }

    private String getDataFromLinearRegression(String variable, Date initialDate, Date finalDate, String historic,int histPoints,double alpha) {
        reportController.doLinearRegression(initialDate,finalDate,variable,historic,histPoints,alpha);
        return " === Linear Regression - " + historic + " - " + variable + " === \n" + reportController.getData() + "\n\n\n";
    }

    private void importFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILE_NAME));
        file = new ArrayList<>();
        while(sc.hasNext()){
                file.add(sc.nextLine().split(";"));
        }
        header = file.get(0);
        file.remove(0);
    }

    private int getColumnIndex(String s){

        for(int i = 0; i < header.length; i++){


            if(header[i].trim().equals(s.trim())){
                return  i;
            }


        }
        return -1;

    }


}
