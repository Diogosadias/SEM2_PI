package app.ui.console;

import app.controller.CovidNhsReportController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CovidNhsReportUI implements Runnable {





    @Override
    public void run() {

        CovidNhsReportController controller = new CovidNhsReportController();
        Scanner read = new Scanner(System.in);
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
            controller.Matcp(dateI,dateF);
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }
}
