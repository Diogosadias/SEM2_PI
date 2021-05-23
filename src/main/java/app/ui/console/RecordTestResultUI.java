package app.ui.console;

import app.controller.RecordTestResultController;
import app.domain.dto.TestDto;
import app.ui.console.utils.Utils;

import java.util.Scanner;

public class RecordTestResultUI implements Runnable {

    private RecordTestResultController m_controller;

    public RecordTestResultUI(){
        this.m_controller = new RecordTestResultController();
    }


    public void run(){

        String parameterCode;
        String result;
        String metric;

        Scanner read = new Scanner(System.in);

        TestDto chosenTest = writeTests();
        System.out.println(chosenTest);

        m_controller.getListParameters(chosenTest.getCode());

        System.out.println("Parameter Code:");
        parameterCode = read.next();

        System.out.println("Result:");
        result = read.next();

        System.out.println("Metric:");
        metric = read.next();





    }




    public TestDto writeTests(){
        return (TestDto) Utils.showAndSelectOne(m_controller.getTests(),"\nTests");
    }
}