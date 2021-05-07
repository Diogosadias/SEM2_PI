package app.controller;

import app.domain.model.CAL;
import junit.framework.TestCase;

public class RegisterNewCALControllerTest extends TestCase {
    RegisterNewCALController controller = new RegisterNewCALController();
    CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);


    public void testRegisterNewCAL() {
        boolean b1 = controller.registerNewCAL("115a1","labName",12345678910L,"Adress",1234567891L,true);

        //assert
        assertEquals(true,b1);

    }

    public void testSaveCAL() {
        boolean b1 = controller.saveCAL();

        //assert
        assertEquals(false,b1);
    }
}