package app.test;

import app.controller.CreateClientController;
import app.controller.RegisterNewCALController;
import app.domain.model.CAL;
import app.domain.model.CALStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterNewCALControllerTest {

    @Test
    public void testRegisterNewCAL() {
        //arrange
        RegisterNewCALController controller = new RegisterNewCALController();
        //preparing
        boolean b1 = controller.registerNewCAL("11asd","labNams",12345678524L,"Adress",1234567891,true);


        //testing
        assertEquals(true,b1);
        try{
            controller.registerNewCAL("11a","labNams",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
    }

    @Test
    public void testSaveCAL() {
        //arrange
        RegisterNewCALController controller = new RegisterNewCALController();
        CAL cal = new CAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        controller.registerNewCAL("11as1","labName",23672318524L,"asasa ",1234678921,true);
        //preparing
        boolean b1 = controller.saveCAL();

        //testing
        assertEquals(true,b1);
        controller.registerNewCAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        assertEquals(true,controller.saveCAL());
        controller.registerNewCAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        assertEquals(false,controller.saveCAL());

    }
}