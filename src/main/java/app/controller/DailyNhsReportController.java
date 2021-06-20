package app.controller;

import app.domain.model.Company;
import app.domain.shared.CovidReportMapper;
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

    public DailyNhsReportController(){this.company = App.getInstance().getCompany();}

    public void runDailyNhsReportTask()throws FileNotFoundException  {
        importFile();
        CovidReportMapper mapper = new CovidReportMapper(this.company);
        String data = "";
        for(String[] line : file) {
                Date initialDate = new Date(line[getColumnIndex("InitialDate_Registration")]);
                Date finalDate = new Date(line[getColumnIndex("FinalDate_Registration")]);
                int histPoints = Integer.valueOf(line[getColumnIndex("HistoricPoints")]);
                String sign = line[getColumnIndex("SignificanceLevel")].replace("%","").replace(",",".");
                double alpha = round(1 - (Double.valueOf(sign)/(double)100),2);
                mapper.startNewReport(initialDate,finalDate,histPoints,alpha);
                if(mapper.startNewReport(initialDate,finalDate,histPoints,alpha)){
                    data = mapper.getData();
                    //dailytask(data);
                    new Reminder(data);
                }
            }

    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
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
