package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

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



    @Test
    public void testSetCompany() {
        Company company2 = new Company("Many");
        company.getTestStore().setCompany(company2);

        assertEquals(company2,company.getTestStore().getCompany());
    }

    @Test
    public void checkRegisteredClient() {
        company.getTestStore().setCompany(company);
        Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
        company.getClientStore().saveClients(c1,"aaaa");
        boolean test = company.getTestStore().checkRegisteredClient(1111111111L);
        assertTrue(test);
        boolean test2 = company.getTestStore().checkRegisteredClient(111111311111L);
        assertFalse(test2);
    }

    @Test
    public void getListTestType() {
        /*company.getTestStore().setCompany(company);
        TestType p2 = company.getTestTypeStore().createTestType("aaaaa","aaaaaaaa","aaaaa");
        company.getTestTypeStore().saveTestType(p2);
        List<Object> storeTestList = new ArrayList<>();
        Object a = "aaaaaaaa";
        storeTestList.add(a);

        assertEquals(storeTestList, company.getTestStore().getListTestType());*/
    }

    @Test
    public void newTest() {
        /*company.getTestStore().setCompany(company);
        TestType type1 = new TestType("123te","Blood Test","Blood sample");
        this.company.getTestTypeStore().addTestType(type1);
        company.getTestStore().newTest("123te");
        app.domain.model.Test e = company.getTestStore().getTestByCode("123te");
        assertEquals(type1,e);*/
    }

    @Test
    public void addCategoryToTest() {
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
    }

    @Test
    public void addSampleToTest() {
    }

    @Test
    public void getRegisteredTests() {
    }

    @Test
    public void getSampleCollectedTests() {
    }

    @Test
    public void getSampleAnalysisTests() {
    }

    @Test
    public void getDiagnosedTests() {
    }

    @Test
    public void getValidatedTests() {
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