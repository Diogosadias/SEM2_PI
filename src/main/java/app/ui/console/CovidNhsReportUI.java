package app.ui.console;

import app.controller.CovidNhsReportController;
import app.domain.shared.Constants;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CovidNhsReportUI implements Runnable {

    private CovidNhsReportController controller;
    private Scanner read;

    public CovidNhsReportUI () {
        read = new Scanner(System.in);
        controller = new CovidNhsReportController();
    }

    @Override
    public void run() {
        /*
        String ui = chooseData("Chose UI(Fixing):\n1 - Old\n2 - New","Old","New");

        if(ui=="New"){
            alternativeUI();
            return;
        }*/


        //String historic = chooseData("Send Data to NHS:\n1 - Daily\n2 - Weekly","Daily","Weekly");
        String historic = "Daily";
        System.out.println("\nNumber of historical points: ");
        int histPoints = read.nextInt();

        controller.startNewReport(historic,histPoints);

        String initDate;
        String finalDate;

        System.out.println("Initial Date:  (dd/mm/yyyy)");
        //initDate = read.next();
        initDate = "22/03/2021";
        System.out.println("Final Date:  (dd/mm/yyyy)");
        //finalDate = read.next();
        finalDate = "26/03/2021";



        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateI = formatter1.parse(initDate);
            Date dateF = formatter1.parse(finalDate);
            //String regression = chooseData("Set Linear Regression Model:\n1 - Simple Linear Regression\n2 - Multiple Linear Regression","Linear","Multiple");
            //controller.setAdditionalData(dateI,dateF,regression);
            String regression = "Linear";
            if (regression.equals("Linear")) {
                String varIndependent = chooseData("Variable Independent:\n1 - Number of Tests Realised\n2 - Client Mean Age","Registered Tests","Mean Age");
                controller.doSimpleLinearRegression(dateI,dateF,"Linear",varIndependent);
            } else {
                controller.doMultipleLinearRegression(dateI,dateF,"Multiple");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

    private String chooseData (String header,String option1, String option2) {
        String data = "NA";
        do {
            System.out.println(header);
            int option = read.nextInt();
            if (option == 1) {
                data = option1;
            } else if (option == 2) {
                data = option2;
            } else {
                System.out.println("Incorrect Option, try again.\n");
            }
        } while (data == "NA");
        return data;
    }

    public void alternativeUI(){

        //asks for historical points of analysis and data range



        // asks if linear or multiple regressions, level of significance

        //asks what variables to report

        //Writes on console info and writes on file

        //sends file though API

    }
}
