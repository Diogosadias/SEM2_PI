package app.ui.console;

import app.controller.RecordTestResultController;
import app.domain.dto.ParameterDto;
import app.domain.dto.TestDto;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class RecordTestResultUI implements Runnable {

    private final RecordTestResultController mcontroller;

    public RecordTestResultUI(){
        this.mcontroller = new RecordTestResultController();
    }


    public void run(){
        try {
            TestDto testDto = writeTests();
            System.out.println(testDto);
            if (testDto == null) {
                return;
            }
            List<ParameterDto> parametersDto = mcontroller.getListParameters(testDto.getCode());
            while (!parametersDto.isEmpty()) {
                ParameterDto parameterDto = (ParameterDto) Utils.showAndSelectOne(parametersDto, "\nList of Parameters:\n");
                Scanner read = new Scanner(System.in);
                System.out.println("\nResult: ");
                String result = read.nextLine();
                System.out.println("\nMetric.");
                double metric = read.nextDouble();
                if (mcontroller.addTestResult(parameterDto, result, metric)) {
                    presentsData();
                    if (!Utils.confirm("\nDo you want to confirm the Test/Parameter Result? (Y/N)")) {
                        System.out.println("\nOperation canceled.");
                    } else {
                        if (mcontroller.saveTestResult()) {
                            System.out.println("\nTestResult saved successfully.");
                            parametersDto.remove(parameterDto);
                        } else {
                            System.out.println("\nError: Operation Failed.");
                        }
                    }

                } else {
                    System.out.println("\nError: Operation Failed.");
                }
                if (parametersDto.isEmpty()) {
                    System.out.println("\nAll parameters have been analysed, Operation Completed.\n");
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public TestDto writeTests(){
        return (TestDto) Utils.showAndSelectOne(mcontroller.getTests(),"\nTests");
    }

    private void presentsData()    {
        System.out.println("\nTest/Parameter Result: \n" + mcontroller.getTestStore().getTestResultToString());
    }
}
