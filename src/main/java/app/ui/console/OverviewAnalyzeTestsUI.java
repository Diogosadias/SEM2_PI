package app.ui.console;

import app.controller.OverviewAnalyzeTestsController;
import app.controller.RecordSampleController;
import app.domain.dto.ClientDTO;
import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.shared.SortAlgorithm;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OverviewAnalyzeTestsUI implements Runnable {

    OverviewAnalyzeTestsController oc;


    public OverviewAnalyzeTestsUI() {
        this.oc = new OverviewAnalyzeTestsController();

    }


    @Override
    public void run() {
        Scanner read = new Scanner(System.in);
        int choice;

        System.out.println("Which order algorithm? \nBy Name: 1\nBy TIN: 2");
        choice = read.nextInt();
        ClientDTO dto = writeClients(choice);
        System.out.println(dto);
        List <Test> tl = oc.listClientTest(dto);

        System.out.println("Validated tests by this client:"+dto+"\n");
        if(tl.isEmpty())
            System.out.println("\nNone");
        else {
            for (Test t : tl)
                System.out.println("\n" + t);
        }


    }



    public ClientDTO writeClients(int choice){

        List <ClientDTO> clientsDTOs = oc.getClient();


        if(choice == 1)
        Collections.sort(clientsDTOs, new SortAlgorithm.ClientCompareByName());
        else Collections.sort(clientsDTOs, new SortAlgorithm.ClientCompareByTIN());

        int index = Utils.showAndSelectIndex(clientsDTOs,"\nClients");

        if(index == 1) return null;
        return clientsDTOs.get(index);
    }
}
