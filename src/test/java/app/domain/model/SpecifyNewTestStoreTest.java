package app.domain.model;

import app.domain.model.stores.TestTypeStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class SpecifyNewTestStoreTest {
    TestTypeStore storeTest = new TestTypeStore();
    TestType p1 = new TestType("aaaaa","aaaaaaaa","aaaaa");
    @Test
    public void createTestType() {
        TestType p2 = storeTest.createTestType("aaaaa", "aaaaaaaa", "aaaaa");
        //assert
        assertEquals(p1.toString(),p2.toString());
        assertNotNull(storeTest.createTestType("aaaaa", "aaaaaaaa", "aaaaa"));

    }
    @Test
    public void createTestTypeWithNullValues() {

        assertNull(storeTest.createTestType(null, null, null));
        assertNull(storeTest.createTestType("aaaaa", null, null));
        assertNull(storeTest.createTestType(null, "aaaaaaaa", null));
        assertNull(storeTest.createTestType(null, null, "aaaaa"));


    }

    @Test
    public void validateTestType() {
        boolean b = storeTest.validateTestType(p1);
        assertEquals(true,b);
    }
    @Test
    public void validateTestTypeExistent() {
        storeTest.saveTestType(p1);
        boolean b1 = storeTest.validateTestType(p1);
        assertEquals(false,b1);
    }
    @Test
    public void validateTestTypeNull() {
        boolean b2 = storeTest.validateTestType(null);
        assertFalse(b2);
    }

    @Test
    public void saveTestType() {
        boolean b = storeTest.saveTestType(p1);
        assertEquals(true,b);

        boolean b1 = storeTest.saveTestType(p1);
        assertEquals(false,b1);
    }

    @Test
    public void deleteTestType() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p2);
        boolean delete = storeTest.deleteTestType(p2.getCode());
        boolean contains = storeTest.getTestTypeList().contains(p2);
        assertTrue(delete && !contains);
    }
    @Test
    public void deleteTestTypeNull() {
        assertFalse(storeTest.deleteTestType(null));
    }
    @Test
    public void deleteTestTypeNonExistent() {
        assertFalse(storeTest.deleteTestType("DOESNT EXIST"));
    }


    @Test
    public void searchTestTypeExistent() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p2);
        boolean check = storeTest.searchTestType(p2.getCode());
        assertEquals(true ,check );
    }
    @Test
    public void searchTestTypeNonExistent() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p2);
        boolean check = storeTest.searchTestType("aaaab");
        assertEquals(false ,check );
    }

    @Test
    public void getTestTypeByCode() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p2);
        assertEquals(p2 , storeTest.getTestTypeByCode(p2.getCode()));
    }
    @Test
    public void getTestTypeByCodeIsNotNull() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p2);
        assertNotNull(storeTest.getTestTypeByCode(p2.getCode()));
    }
    @Test
    public void getTestTypeByCodeNull() {
        assertNull(storeTest.getTestTypeByCode(null));
    }
    @Test
    public void getTestTypeByCodeNonExistant() {
        assertNull(storeTest.getTestTypeByCode("DOESNT EXIST"));
    }

    @Test
    public void getTestTypeList() {
        TestType p2 = storeTest.createTestType("aaaaa","aaaaaaaa","aaaaa");
        storeTest.saveTestType(p1);
        storeTest.saveTestType(p2);
        List<TestType> storeTestList = new ArrayList<>();
        storeTestList.add(p1);
        storeTestList.add(p2);

        assertEquals(storeTestList, storeTest.getTestTypeList());
    }
}