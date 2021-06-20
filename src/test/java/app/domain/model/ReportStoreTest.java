package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class ReportStoreTest {
    Report report1 =  new Report("123456789",new app.domain.model.Test((new TestType("codex","description","collectingMethod")),"qwertyuiop",new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L)));
    ReportStore reportStore = new ReportStore();

    @Test
    public void createReport() {
        assertNull(reportStore.createReport(null,new app.domain.model.Test((new TestType("codex","description","collectingMethod")),"qwertyuiop",new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L))));
        assertNull(reportStore.createReport("123456789",null));
        Report report2 = reportStore.createReport("123456789",new app.domain.model.Test((new TestType("codex","description","collectingMethod")),"qwertyuiop",new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L)));

        assertEquals(report2.getDiagnosis(),report1.getDiagnosis());
        //assertEquals(report2.getTest(),report1.getTest());
    }

    @Test
    public void validateReport() {
        //testing
        assertTrue(reportStore.validateReport(report1));
        reportStore.saveReport(report1);
        assertFalse(reportStore.validateReport(report1));
        Report report2 = reportStore.createReport("123356789",new app.domain.model.Test((new TestType("co2ex","description","collectingMethod")),"qweruiop",new Client(new Email("uer1@gmail.com"), "Jhn", 1111211111L, 1111111121111111L, 1111111121L, new Date("12/12/2021"), "M", 11111111112L)));
        assertTrue(reportStore.validateReport(report2));
        assertFalse(reportStore.validateReport(null));

    }

    @Test
    public void saveReport() {
        //testing

        boolean b = reportStore.saveReport(report1);
        assertEquals(true,b);

        boolean b1 = reportStore.saveReport(report1);
        assertEquals(false,b1);
    }

    @Test
    public void testGetFileName() {
        System.out.println("GetFileName");
        ReportStore instance = reportStore;
        String expResult = "ser/report.txt";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }
}