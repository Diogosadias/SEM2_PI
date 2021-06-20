package app.domain.model;

import app.domain.dto.TestTypeDto;
import auth.AuthFacade;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class TestStoreTest {
    Company company = new Company("Many Labs");
    TestStore ts = company.getTestStore();
    AuthFacade auth = new AuthFacade();
    ClientStore cs =company.getClientStore();
    Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
    TestType type1 = new TestType("123te","Blood Test","Blood sample");
    app.domain.model.Test t = new app.domain.model.Test(type1,"aaaa", c1);
    TestType testType = new TestType("test1","testType","TEST");


    @Test
    public void testSetCompany() {
        Company company2 = new Company("Many");
        company.getTestStore().setCompany(company2);

        assertEquals(company2,company.getTestStore().getCompany());
    }

    @Test
    public void checkRegisteredClient() {
        company.getTestStore().setCompany(company);
           company.getClientStore().saveClients(c1,"aaaa");
        boolean test = company.getTestStore().checkRegisteredClient(1111111111L);
        assertTrue(test);
        boolean test2 = company.getTestStore().checkRegisteredClient(111111311111L);
        assertFalse(test2);
    }


    @Test
    public void getListTestType() {
        ts.setCompany(company);
        company.getTestTypeStore().addTestType(this.testType);
        List<TestTypeDto> testTypes = ts.getListTestType();
        String result = testTypes.get(0).getCode() + testTypes.get(0).getDescription();
        String expected = testType.getCode() + testType.getDescription();
        assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void newTest() {
        company.getTestStore().setCompany(company);
        this.company.getTestTypeStore().addTestType(this.testType);
        this.company.getClientStore().setClientList(this.c1);
        this.company.getTestStore().checkRegisteredClient(this.c1.getTin());
        company.getTestStore().newTest("test1");
        company.getTestStore().saveTest();
        app.domain.model.Test e = company.getTestStore().getTest();
        assertTrue(e.getTestType().getCode().equalsIgnoreCase(this.testType.getCode()));
    }

    @Test
    public void addCategoryToTest() {
        ParameterCategory pCat = new ParameterCategory("pCatTst1", "aaaaa", "123");
        this.company.getTestStore().setCompany(this.company);
        this.company.getParameterCategoryStore().addParameterCategory(pCat);


        this.company.getTestTypeStore().addTestType(this.testType);
        this.company.getClientStore().setClientList(this.c1);
        this.company.getTestStore().checkRegisteredClient(this.c1.getTin());
        company.getTestStore().newTest("test1");
        this.ts.addCategoryToTest("pCatTst1");
        company.getTestStore().saveTest();
        assertEquals(ts.getTest().getListCategories().get(0).toString(), pCat.toString());
    }

    @Test
    public void getListParameters() {
    }

    @Test
    public void addParameterToTest() {
    }

    @Test
    public void addNhsCodeToTest() {
    }

    @Test
    public void validateTest() {
    }

    @Test
    public void saveTest() {
    }

    @Test
    public void addTest() {
        ts.addTest(t);
        app.domain.model.Test e = new app.domain.model.Test(type1,"aaaa",c1);
        assertEquals(e.getClient().equals(ts.getTest().getClient()), true);
        assertEquals(! t.equals(ts.getTest()), false);

    }

    @Test
    public void addSampleToTest() throws OutputException, BarcodeException, IOException {
        Sample s = new Sample("1111");
        ts.addTest(t);
        ts.addSampleToTest(s);



    }

    @Test
    public void getRegisteredTests() {
        t.setNhsCode("123456789000");
        ts.addTest(t);

        assertEquals(ts.getTest().hasCondition("Registered"),true);
        assertEquals(ts.getTest().hasCondition("Sample Collected"), false);
        assertEquals(ts.getTest().hasCondition("Sample Analysed"), false);
        assertEquals(ts.getTest().hasCondition("Diagnosis Made"), false);
        assertEquals(ts.getTest().hasCondition("Validated"), false);
    }

    @Test
    public void getSampleCollectedTests() throws OutputException, BarcodeException, IOException {

        Sample s = new Sample("1111");
        t.addSample(s);

        assertEquals(t.hasCondition("Sample Collected"), true);
        assertEquals(t.hasCondition("Registered"), false);
        assertEquals(t.hasCondition("Sample Analysed"), false);
        assertEquals(t.hasCondition("Diagnosis Made"), false);
        assertEquals(t.hasCondition("Validated"), false);

    }

    @Test
    public void getSampleAnalysisTests() {
        t.addResultToList();

        assertEquals(t.hasCondition("Sample Collected"), false);
        assertEquals(t.hasCondition("Registered"), false);
        assertEquals(t.hasCondition("Sample Analysed"), true);
        assertEquals(t.hasCondition("Diagnosis Made"), false);
        assertEquals(t.hasCondition("Validated"), false);


    }

    @Test
    public void getDiagnosedTests() {

        t.testDiagnosisCompleted();


        assertEquals(t.hasCondition("Sample Collected"), false);
        assertEquals(t.hasCondition("Registered"), false);
        assertEquals(t.hasCondition("Sample Analysed"), false);
        assertEquals(t.hasCondition("Diagnosis Made"), true);
        assertEquals(t.hasCondition("Validated"), false);


    }

    @Test
    public void getValidatedTests() {

        t.isValidated();

        assertEquals(t.hasCondition("Sample Collected"), false);
        assertEquals(t.hasCondition("Registered"), false);
        assertEquals(t.hasCondition("Sample Analysed"), false);
        assertEquals(t.hasCondition("Diagnosis Made"), false);
        assertEquals(t.hasCondition("Validated"), true);

    }

    @Test
    public void getTests() {
    }

    @Test
    public void setTest() {
    }

    @Test
    public void getTest() {
    }

    @Test
    public void getTestByCode() {
    }

    @Test
    public void getListParametersFromTest() {
    }

    @Test
    public void setTestStateDiagnosis() {
    }

    @Test
    public void getTestToString() {
    }

    @Test
    public void getTestResultToString() {
    }
}