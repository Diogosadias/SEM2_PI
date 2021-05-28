package app.ui.console;

import app.controller.RecordTestResultController;
import app.domain.dto.ParameterDto;
import app.domain.dto.TestDto;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import com.example1.ExternalModule3API;

import java.util.List;
import java.util.Scanner;

public class RecordTestResultUI implements Runnable {

    private RecordTestResultController m_controller;

    public RecordTestResultUI(){
        this.m_controller = new RecordTestResultController();
    }


    public void run(){
        try {
            TestDto testDto = writeTests();
            System.out.println(testDto);
            if (testDto == null) {
                return;
            }
            List<ParameterDto> parametersDto = m_controller.getListParameters(testDto.getCode());
            while (!parametersDto.isEmpty()) {
                ParameterDto parameterDto = (ParameterDto) Utils.showAndSelectOne(parametersDto, "\nList of Parameters:\n");
                Scanner read = new Scanner(System.in);
                System.out.println("\nResult: ");
                String result = read.nextLine();
                System.out.println("\nMetric.");
                double metric = read.nextDouble();
                if (m_controller.addTestResult(parameterDto, result, metric)) {
                    presentsData();
                    if (!Utils.confirm("\nDo you want to confirm the Test/Parameter Result? (Y/N)")) {
                        System.out.println("\nOperation canceled.");
                    } else {
                        if (m_controller.saveTestResult()) {
                            System.out.println("\nTestResult saved successfully.");
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
        return (TestDto) Utils.showAndSelectOne(m_controller.getTests(),"\nTests");
    }

    private void presentsData()    {
        System.out.println("\nTest/Parameter Result: \n" + m_controller.getTestStore().getTestResultToString());
    }
}
