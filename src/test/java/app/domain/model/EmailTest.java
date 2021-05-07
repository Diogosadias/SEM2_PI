package app.domain.model;

import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Test;

public class EmailTest extends TestCase {


    @Test
    public void testGetEmail() {
        //arrange
        Email e1 = new Email("user@gmail.com");

        //assert
        assertEquals("user@gmail.com", e1.getEmail());
    }

    @Test
    public void testTestHashCode() {
        //arrange
        int i = hashCode();
        int j = hashCode();
        boolean b;

        if(i != j)
            b=true;
        else
            b=false;

        //assert
        assertEquals(false, b);
    }

    @Test
    public void testTestEquals() {
        //arrange
        Email e1 = new Email("user@gmail.com");

        //assert
        assertEquals(true, e1.equals(e1));
    }


}