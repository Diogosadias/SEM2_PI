package app.domain.shared;

import com.nhs.report.Report2NHS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*5000);
    }

    class RemindTask extends TimerTask {
        public void run() {

             Report2NHS reportnhs = new Report2NHS();

             reportnhs.writeUsingFileWriter("");


            timer.cancel(); //Terminate the timer thread
        }
    }

    public void scheduled() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,18);
        cal.set(Calendar.MINUTE,00);
        cal.set(Calendar.SECOND,00);
        Date time = cal.getTime();

        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);



    }


}