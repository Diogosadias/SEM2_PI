package app.domain.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDtoTest {

    EmployeeDto dto = new EmployeeDto("Doctor","John","Rua",12345678910l,"SocCode");



    @Test
    public void getRoleId(){
        String role;
        role = dto.getRoleId();

        assertEquals("Doctor",role);
        assertEquals(false,role.equals(""));

    }

    @Test
    public void getName(){
        String name;
        name = dto.getName();

        assertEquals("JOHN", name);
        assertEquals(false,name.equals(""));
    }

    @Test
    public void getAdress(){
        String adress;
        adress = dto.getAddress();

        assertEquals("RUA",adress);
        assertEquals(false,adress.equals(""));
    }

    @Test
    public void getPhoneNumber(){

        long pnumber;
        pnumber = dto.getPhoneNumber();

        assertEquals(12345678910l,pnumber);

    }

    public void getSocCode(){
        String soc;
        soc = dto.getSocCode();

        assertEquals("SOCCODE",soc);
        assertEquals(false,soc.equals(""));
    }
}