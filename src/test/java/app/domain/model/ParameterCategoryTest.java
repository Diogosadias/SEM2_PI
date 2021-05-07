package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryTest {


    ParameterCategory pc = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");

    @Test
    public void testcheckCodeRules(){

        try{
        ParameterCategory pc = new ParameterCategory("a","aaaaaaaa","aaaaa");
        }catch (IllegalArgumentException ex){
            assertEquals("Code must have 4 to 8 characters.",ex.getMessage());
        }
        try{
            ParameterCategory pc = new ParameterCategory("","aaaaaaaa","aaaaa");
        }catch (IllegalArgumentException ex){
            assertEquals("Code cannot be blank",ex.getMessage());
        }
    }

    @Test
    public void testCheckDescriptionRules() {
        try{

            ParameterCategory pc = new ParameterCategory("aaaaa","","aaaaa");
        }catch (IllegalArgumentException ex){
            assertEquals("Code cannot be blank",ex.getMessage());
        }
        try{
            ParameterCategory pc = new ParameterCategory("aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaa");
        }catch (IllegalArgumentException ex){
            assertEquals("Code must not exceed 40 chars.", ex.getMessage());
        }
    }

}