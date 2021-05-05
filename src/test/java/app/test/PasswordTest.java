package app.test;

import auth.domain.model.Password;
import junit.framework.TestCase;
import org.junit.Test;

public class PasswordTest extends TestCase {

    @Test
    public void testCheckPassword() {
        //preparations
        Password pwd = new Password("123456");
        Password pwd2 = new Password("aa");
        boolean b = pwd.checkPassword("123456");
        boolean b2 = pwd2.checkPassword("aaaaa");

        //Assert
        assertEquals(true,b);
        assertEquals(false,b2);

    }

    @Test
    public void testTestHashCode() {

        //arrange
        Password pwd = new Password("123456");
        int hash = pwd.hashCode();
        String hashS = Integer.toString(hash);
        boolean b;
        //Calculations

        if("123456" == hashS)
            b = true;
        else
            b = false;

        //assert
        assertEquals(false,b);

    }

    @Test
    public void testTestEquals() {
        //arrange
        Password pwd = new Password("123456");
        Password pwd2 = new Password("123456");
        boolean b;
        boolean b2;
        //calculations
        b = pwd.equals(pwd);
        b2 = pwd2.equals(new Password("aaa"));
        //assert
        assertEquals(true,b);
        assertEquals(false,b2);

    }


}