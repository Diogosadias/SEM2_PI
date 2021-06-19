package app.domain.model;

import auth.domain.model.Email;
import com.example2.EMRefValue;
import junit.framework.TestResult;
import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;
import java.util.Date;

import static org.junit.Assert.*;

public class TestParameterTest {


    private TestType testType = new TestType("11111","aaaa","aaaa");
    private Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);

    private app.domain.model.Test test = new app.domain.model.Test(testType,"aaaa",c1);

    private Parameter parameter = new Parameter("code","parameter","description","category");

    private TestParameter tpm = new TestParameter(parameter);

    private String result = "aa";
    private double metric = 11;
    private EMRefValue ref = new EMRefValue("1111","2",2.1,4.1,new Date(12/12/2021));


    @Test
    public void getParameter() {
        test.addParameter(parameter);
        assertEquals(parameter, test.getParameterByCode("code"));
    }

    @Test
    public void addResult() {

        assertEquals(tpm.addResult(result,metric,ref),true);


    }

    @Test
    public void getResult() {
        tpm.addResult(result,metric,ref);
        TestParameterResult tpr = new TestParameterResult(result, 0.1, ref);
        TestParameterResult tpr2 = new TestParameterResult(result, metric, ref);
        System.out.println(tpm.getResult());;
        System.out.println(tpr2);
        assertEquals(tpm.getResult().equals(tpr),false);
        assertEquals(tpm.getResult().toString(), tpm.getResult().toString());
    }

    @Test
    public void testToString() {
        assertEquals(tpm.toString(), "Test Result: \n" +
                "Parameter: " + parameter + "\n");
    }
}