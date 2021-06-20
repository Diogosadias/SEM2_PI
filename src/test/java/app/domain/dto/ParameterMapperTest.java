/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import auth.domain.model.Email;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class ParameterMapperTest {

    ParameterMapper mapper = new ParameterMapper();
    Parameter p = new Parameter("123", "teste", "teste", "teste");
    ParameterDto pDto = new ParameterDto("123", "teste");
    List<Parameter> parameters = new ArrayList<>();

    /**
     * Test of toDto method, of class ParameterMapper.
     */
    @Test
    public void testToDto() {
        System.out.println("toDto");
        List<ParameterDto> expResult = new ArrayList<>();
        parameters.add(p);
        expResult.add(pDto);
        ParameterMapper instance = mapper;
        List<ParameterDto> result = instance.toDto(parameters, "teste");
        assertEquals(expResult.get(0).getCode(), result.get(0).getCode());
    }
    
}
