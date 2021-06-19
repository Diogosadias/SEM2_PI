package app.domain.shared;

import com.nhs.report.Report2NHS;
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
    private final String data;

    public Reminder(String data) {
        this.data = data;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,6);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date time = cal.getTime();

        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);
        System.out.println("Daily Nhs Report sent!");
    }

    class RemindTask extends TimerTask {
        public void run() {

             Report2NHS reportnhs = new Report2NHS();
            reportnhs.writeUsingFileWriter(data);
            timer.cancel(); //Terminate the timer thread
        }
    }

}