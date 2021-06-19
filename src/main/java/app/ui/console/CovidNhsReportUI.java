package app.ui.console;

import app.controller.CovidNhsReportController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CovidNhsReportUI implements Runnable {

    private final CovidNhsReportController controller;
    private final Scanner read;

    public CovidNhsReportUI () {
        read = new Scanner(System.in);
        controller = new CovidNhsReportController();
    }

    @Override
    public void run() {
        controller.startNewReport();
        if( controller.startNewReport()) {
            String historic = chooseData("Send Data to NHS:\n1 - Daily\n2 - Weekly","Daily","Weekly");

            System.out.println("\nNumber of historical points: ");
            int histPoints = read.nextInt();
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            String initDate;
                String finalDate;

                System.out.println("Initial Date:  (dd/mm/yyyy)");
                initDate = read.next();
                System.out.println("Final Date:  (dd/mm/yyyy)");
                finalDate = read.next();

                try {
                    Date dateI = formatter1.parse(initDate);
                    Date dateF = formatter1.parse(finalDate);
                    String regression = chooseData("Set Linear Regression Model:\n1 - Simple Linear Regression\n2 - Multiple Linear Regression","Linear","Multiple");
                    System.out.println("Significance Level:  (ex: 95%)");
                    double alpha = 1 - Double.valueOf(read.nextLine().replace(",",".").replace("%",""))/100;
                    if (regression.equals("Linear")) {
                        String varIndependent = chooseData("Variable Independent:\n1 - Number of Tests Realised\n2 - Client Mean Age", controller.VAR_TESTS, controller.VAR_AGE);
                        controller.doLinearRegression(dateI, dateF, varIndependent,historic, histPoints,alpha);
                    } else {
                        controller.doLinearRegression(dateI, dateF, controller.MULTIPLE, historic, histPoints,alpha);
                    }
                    controller.sendNhsReport();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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

}
