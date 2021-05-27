package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class ReportStoreTest {
    Report report1 =  new Report("123456789",new app.domain.model.Test((new TestType("codex","description","collectingMethod")),"qwertyuiop",new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 11111111111L)));
    ReportStore reportStore = new ReportStore();

    @Test
    public void createReport() {
        assertNull(reportStore.createReport(null,new app.domain.model.Test((new TestType("codex","description","collectingMethod")),"qwertyuiop",new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 11111111111L))));
        assertNull(reportStore.createReport("123456789",null));

    }

    @Test
    public void validateReport() {
        //testing
        boolean b = reportStore.validateReport(report1);
        assertEquals(true,b);
        reportStore.saveReport(report1);
        boolean b1 = reportStore.validateReport(report1);
        assertEquals(false,b1);
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
}