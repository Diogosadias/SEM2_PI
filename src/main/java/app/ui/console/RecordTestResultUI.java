package app.ui.console;

import app.controller.RecordTestResultController;
import app.domain.dto.ParameterDto;
import app.domain.dto.TestDto;
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



        Scanner read = new Scanner(System.in);

        TestDto testDto = writeTests();
        System.out.println(testDto);

        List<ParameterDto> parametersDto = m_controller.getListParameters(testDto.getCode());
        ParameterDto parameterDto = (ParameterDto) Utils.showAndSelectOne(parametersDto, "\nList of Parameters:\n");
        m_controller.addTestResult(parameterDto);

    }




    public TestDto writeTests(){
        return (TestDto) Utils.showAndSelectOne(m_controller.getTests(),"\nTests");
    }
}
