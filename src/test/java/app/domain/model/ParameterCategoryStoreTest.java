package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterCategoryStoreTest {
    ParameterCategoryStore storeTest = new ParameterCategoryStore();
    ParameterCategory p1 = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");

    @Test
    public void createParameterCategory() {
        ParameterCategory p2 = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");
        //assert
        assertEquals(p1.getCode(),p2.getCode());
        assertEquals(p1.getDescription(),p2.getDescription());
        assertEquals(p1.getNhsId(),p2.getNhsId());
    }
    @Test
    public void testCreateParameterWithNullValues(){
        assertNull(storeTest.createParameterCategory(null, null, null));
    }


    @Test
    public void getParameterCategoryByCode() {
        storeTest.saveParameterCategory(p1);
        assertEquals(p1 , storeTest.getParameterCategoryByCode(p1.getCode()));
    }
    @Test
    public void testGetParameterCategoryByCodeIsNotNull(){
        storeTest.saveParameterCategory(p1);
        assertNotNull(storeTest.getParameterCategoryByCode(p1.getCode()));
    }
    @Test
    public void getParameterCategoryByCodeNull() {
        assertNull(storeTest.getParameterCategoryByCode(null));
    }
    @Test
    public void getParameterCategoryByCodeNonExistant() {
        assertNull(storeTest.getParameterCategoryByCode("DOESNT EXIST"));
    }

    @Test
    public void validateParameterCategoryNull() {
        boolean b2 = storeTest.validateParameterCategory(null);
        assertFalse(b2);
    }
    @Test
    public void validateParameterCategory() {
        boolean b = storeTest.validateParameterCategory(p1);
        assertEquals(true,b);
    }
    @Test
    public void validateParameterCategoryExistent() {
        storeTest.saveParameterCategory(p1);
        boolean b1 = storeTest.validateParameterCategory(p1);
        assertEquals(false,b1);
    }

    @Test
    public void saveParameterCategory() {
        boolean b = storeTest.saveParameterCategory(p1);
        assertEquals(true,b);

        boolean b1 = storeTest.saveParameterCategory(p1);
        assertEquals(false,b1);
    }

    @Test
    public void getParameterCategoryList() {
        ParameterCategory p2 = storeTest.createParameterCategory("aaaa2","aaaaaaaa","aaaaa");
        storeTest.saveParameterCategory(p1);
        storeTest.saveParameterCategory(p2);
        List<ParameterCategory> storeTestList = new ArrayList<>();
        storeTestList.add(p1);
        storeTestList.add(p2);

        assertEquals(storeTestList, storeTest.getParameterCategoryList());
    }
    @Test
    public void testGetNotNullParameterCategoryList() {
        ParameterCategoryStore storetest2 = new ParameterCategoryStore();
        assertNotNull(storetest2.getParameterCategoryList());
    }

    @Test
    public void testToString() {
        ParameterCategory p2 = new ParameterCategory("aaaa2","aaaaaaaa","aaaaa");

        storeTest.saveParameterCategory(p1);
        storeTest.saveParameterCategory(p2);
        String check = "ParameterCategory{code='aaaaa', description='aaaaaaaa', nhsId='aaaaa'}\nParameterCategory{code='aaaa2', description='aaaaaaaa', nhsId='aaaaa'}\n";
        assertEquals(check, storeTest.toString());
    }
}