package app.ui.console;

import app.controller.ClientResultViewController;
import app.controller.CreateClientController;
import app.controller.OverviewAnalyzeTestsController;
import app.domain.dto.ClientDTO;
import app.domain.dto.TestDto;
import app.domain.model.Test;
import app.domain.shared.SortAlgorithm;
import app.ui.console.utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClientResultViewUI implements Runnable{

    ClientResultViewController clientResultViewController;


    public ClientResultViewUI() {
        this.clientResultViewController = new ClientResultViewController();
    }


    @Override
    public void run() {
        TestDto dto = writeTests();
        System.out.println(dto);
        List<Test> tl = clientResultViewController.listClientTest(dto);

        System.out.println("Validated tests by this client:"+dto+"\n");
        if(tl.isEmpty())
            System.out.println("\nNone");
        else {
            for (Test t : tl)
                System.out.println("\n" + t);
        }


    }



    public TestDto writeTests(){

        List <TestDto> TestsDTOs = clientResultViewController.getTest();

        Collections.sort(TestsDTOs, new SortAlgorithm.TestCompareByValidationTest());

        int index = Utils.showAndSelectIndex(TestsDTOs,"\nTests");

        if(index == 1) return null;
        return TestsDTOs.get(index);
    }
}
