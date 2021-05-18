package app.domain.shared;

import java.io.FileWriter;
import java.io.IOException;

public class EmailSender {

    public EmailSender(String email, String pwd) {
        this.sendEmail(email,pwd);
    }

    private void sendEmail (String email, String pass){
        try{
            FileWriter myWriter = new FileWriter(email +".txt");
            myWriter.write("Hello,\nhere is your new password:\n\n");
            myWriter.append("Email: " + email + "\n");
            myWriter.append("Password: " + pass + "\n");
            myWriter.append("\nBest regards\n");
            myWriter.append("ManyLabs team.");
            System.out.println("Sending your new password to your email...");
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Email with new password sent!");
        }
    }
}
