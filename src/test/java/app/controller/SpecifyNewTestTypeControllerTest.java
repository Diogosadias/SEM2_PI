package app.controller;

import app.domain.stores.TestTypeStore;
import app.domain.model.TestType;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpecifyNewTestTypeControllerTest {
    SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();


    @Test
    public void createTestType() {
        //arrange
        SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();

        //calculating
        boolean b1 = specifyNewTestTypeController.createTestType("12345", "qwe", "qwerty");

        //assert
        assertEquals(true,b1);
    }

    @Test
    public void writeTestTypeByCode() {
        //arrange
        SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();
        TestTypeStore specifyNewTestStore= new TestTypeStore();
        TestType testType1 = new TestType("12345", "zxc", "zxcvb");


        //calculations
        /*String code = testType1.getTestTypeByCode();
        specifyNewTestStore.getTestTypeByCode(code);

        specifyNewTestTypeController.writeTestTypeByCode();*/
    }

    @Test
    public void writeTestType() {
        //arrange
        SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();
        TestTypeStore specifyNewTestStore= new TestTypeStore();
        TestType testType1 = new TestType("12345", "zxc", "zxcvb");


        //calculations
        specifyNewTestStore.getTestTypeList();

        specifyNewTestTypeController.writeTestType();
    }

    @Test
    public void deleteTestType() {
    }

    @Test
    public void searchTestType() {
    }

    @Test
    public void saveTestType() {
        //arrange
        TestType testType1 = new TestType("12345", "asd", "asdfghh");
        SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();

        //calculation
        boolean b1 = specifyNewTestTypeController.saveTestType();

        //assert
        assertEquals(true, b1);
    }

    @Test
    public void addParameterToTest() {
    }
}