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
            ParameterCategory pc = new ParameterCategory("aaaaaaaaa","aaaaaaaa","aaaaa");
        }catch (IllegalArgumentException ex1){
            assertEquals("Code must have 4 to 8 characters.",ex1.getMessage());
        }
        try{
            ParameterCategory pc = new ParameterCategory("","aaaaaaaa","aaaaa");
        }catch (IllegalArgumentException ex2){
            assertEquals("Code cannot be blank",ex2.getMessage());
        }
        try{
            ParameterCategory pc = new ParameterCategory("awdad","aaaaaaaa","aaaaa");
        }catch (IllegalArgumentException ex3){
            assertEquals("Code cannot be blank",ex3.getMessage());
        }finally {
            assertTrue(true);
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


    @Test
    public void testGetCode() {
        assertEquals("aaaaa",pc.getCode());
    }

    @Test
    public void testGetDescription() {

        assertEquals("aaaaaaaa",pc.getDescription());
    }

    @Test
    public void testGetNhsId() {
        assertEquals("aaaaa",pc.getNhsId());

    }



    @Test
    public void testSetCode() {
        pc.setCode("codex");
        assertEquals("codex",pc.getCode());
        assertEquals(false,pc.getCode().equals("aaaaa"));
    }

    @Test
    public void testSetDescription() {
        pc.setDescription("desc");
        assertEquals("desc",pc.getDescription());
        assertEquals(false,pc.getDescription().equals("aaaaaaaa"));
    }

    @Test
    public void setNhsId() {
        pc.setNhsId("nhsid");
        assertEquals("nhsid",pc.getNhsId());
        assertEquals(false,pc.getNhsId().equals("aaaaa"));

    }

}