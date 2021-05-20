package app.domain.dto;

import app.domain.model.TestStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMapperTest {
    TestMapper mapper = new TestMapper();
    TestStore testStore = new TestStore();

    @Test
    public void toDto() {
    }

    @Test
    public void testGetTestCompletedList() {

        assertNull(mapper.getTestCompletedList(null));
    }

    @Test
    public void getTestInformation() {
    }
}