package app.ui.console;

import app.controller.CovidNhsReportController;

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


        String historic = chooseData("Send Data to NHS:\n1 - Daily\n2 - Weekly","Daily","Weekly");

        System.out.println("\nNumber of historical points: ");
        int histPoints = read.nextInt();

        controller.startNewReport(historic,histPoints);

        String initDate;
        String finalDate;

        System.out.println("Initial Date:  (dd/mm/yyyy");
        initDate = read.next();
        System.out.println("Final Date:  (dd/mm/yyyy)");
        finalDate = read.next();



        SimpleDateFormat formatter1=new SimpleDateFormat("dd/mm/yyyy");
        try {
            Date dateI = formatter1.parse(initDate);
            Date dateF = formatter1.parse(finalDate);
            String regression = chooseData("Set Linear Regression Model:\n1 - Simple Linear Regression\n2 - Multiple Linear Regression","Linear","Multiple");
            controller.setAdditionalData(dateI,dateF,regression);

            controller.Matcp(dateI,dateF);
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

    private String chooseData (String header,String option1, String option2) {
        String data = null;
        String option;
        do {
            System.out.println(header);
            option = read.nextLine();
            if (Integer.parseInt(option) == 1 || option.equalsIgnoreCase(option1)) {
                data = option1;
            } else if (Integer.parseInt(option) == 2 || option.equalsIgnoreCase(option2)) {
                data = option2;
            } else {
                System.out.println("Incorrect Option, try again.\n");
            }
        } while (data == null);
        return data;
    }
}
