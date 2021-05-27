package app.domain.dto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestMapperTest {

    List<TestDto> testDto = new ArrayList<>();
    TestMapper mapper = new TestMapper();

    @Test
    public void testToDto() {
        assertNull(mapper.toDto(null));

    }

    @Test
    public void testParameters_toDto() {
    }

    @Test
    public void testSamples_toDto() {
    }

    @Test
    public void testResults_toDto() {
    }
}