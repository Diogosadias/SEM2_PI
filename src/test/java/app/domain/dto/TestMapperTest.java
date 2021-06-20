package app.domain.dto;

import app.domain.model.*;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TestMapperTest {

    TestMapper mapper = new TestMapper();
    TestType testTypeDto = new TestType("12345", "teste", "teste");
    Client c = new Client(new Email("teste@gmail.com"), "teste", 1111111111L, 11111111111L, 1111111111L, new Date(), 11111111111L);
    app.domain.model.Test t = new app.domain.model.Test(testTypeDto, "teste", c);
    List<ParameterCategory> categories = new ArrayList<>();
    List<Parameter> parameters = new ArrayList<>();
    TestDto tDto = new TestDto("12345","teste","type",11111111111L, categories, parameters);
    List<app.domain.model.Test> tests = new ArrayList<>();

    @Test
    public void testToDto() {
        System.out.println("toDto");
        List<TestDto> expResult = new ArrayList<>();
        expResult.add(tDto);
        t.setCode("12345");
        tests.add(t);
        TestMapper instance = mapper;
        List<TestDto> result = instance.toDto(tests);
        assertEquals(expResult.get(0).getCode(), result.get(0).getCode());
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