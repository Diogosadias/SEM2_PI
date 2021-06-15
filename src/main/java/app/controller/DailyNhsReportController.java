package app.controller;

import app.domain.model.Company;

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

    public void runDailyTask()throws FileNotFoundException  {
        importFile();
        String data = "";
        for(String[] line : file) {
            reportController = new CovidNhsReportController();
            Date initialDate = new Date(line[getColumnIndex("InitialDate_Registration")]);
            Date finalDate = new Date(line[getColumnIndex("FinalDate_Registration")]);
            int histPoints = Integer.valueOf(line[getColumnIndex("HistoricPoints")]);
            reportController.startNewReport(histPoints);

            data += getDataFromLinearRegression("Registered Tests",initialDate,finalDate,"Daily");
            //data += getDataFromLinearRegression("Mean Age",initialDate,finalDate,"Daily");
            //data += getDataFromLinearRegression("Both",initialDate,finalDate,"Daily");

            //data += getDataFromLinearRegression("Registered Tests",initialDate,finalDate,"Weekly");
            //data += getDataFromLinearRegression("Mean Age",initialDate,finalDate,"Weekly");
            //data += getDataFromLinearRegression("Both",initialDate,finalDate,"Weekly");

            dailytask(data);
            //Reminder dailyTask = new Reminder(data);
        }
    }

    private void dailytask(String data) {
        File file = new File("NHSReport.txt");
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

    private String getDataFromLinearRegression(String variable, Date initialDate, Date finalDate, String historic) {
        reportController.doLinearRegression(initialDate,finalDate,variable,historic);
        if (variable.equals("Both")) {
            variable = "Multiple Variables";
        }
        return " === Linear Regression - " + historic + " - " + variable + " === \n" + reportController.getData();
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
