package app.ui.console;

import app.controller.ParameterController;

import java.util.Scanner;

import static app.domain.shared.Constants.ANS_NO;
import static app.domain.shared.Constants.ANS_YES;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class DeleteParameterUI implements Runnable{
    public DeleteParameterUI(){

    }

    public void run(){
        Scanner read = new Scanner(System.in);
        ParameterController p = new ParameterController();
        String codedel;
        String verific;

        System.out.println("Choose the code of the parameter you want to delete:\n");
        p.writeParameters();
        System.out.print("\n->");
        codedel= read.next();
        do {
            System.out.println("\n Are you sure you want to delete this parameter?(Y/N)");
            verific = read.next().trim();
        }while(!verific.equalsIgnoreCase(ANS_YES) && !verific.equalsIgnoreCase(ANS_NO));
        System.out.println();
        if(verific.equalsIgnoreCase(ANS_YES)) {
            if (p.deleteParameter(codedel)) {
                System.out.println("Parameter deleted with success!");
            } else {
                System.out.println("Parameter not found!");
            }
        }
    }
}
