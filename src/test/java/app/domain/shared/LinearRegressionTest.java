/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.shared;

import app.controller.CovidNhsReportController;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
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
public class LinearRegressionTest {
                
    private LinearRegression instanceTests;
    
    @Before
    public void setUp() {        
        double[] xAgeInterval = new double[] {30.08695652173913, 31.90909090909091, 34.708333333333336, 31.75, 25.266666666666666, 27.466666666666665, 26.61111111111111, 26.416666666666668, 26.416666666666668, 30.0, 0.0, 0.0};
        double[] xTestsInterval = new double[] {23.0, 22.0, 24.0, 20.0, 15.0, 15.0, 18.0, 12.0, 12.0, 7.0, 0.0, 0.0};        
        double[] yInterval = new double[] {16.0, 16.0, 18.0, 14.0, 9.0, 10.0, 12.0, 8.0, 8.0, 5.0, 0.0, 0.0};
        this.instanceTests = new LinearRegression(xTestsInterval,yInterval);
    }
    

    /**
     * Test of intercept method, of class LinearRegression.
     */
    @Test
    public void testIntercept() {
        System.out.println("intercept");
        double expResult1 = -0.36541889483065937; 
        double result1 = instanceTests.intercept();    
        assertEquals(expResult1, result1, 0.0);
    }

    /**
     * Test of slope method, of class LinearRegression.
     */
    @Test
    public void testSlope() {
        System.out.println("slope");
        double expResult = 0.7165775401069518;
        double result = instanceTests.slope();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of R2 method, of class LinearRegression.
     */
    @Test
    public void testR2() {
        System.out.println("R2");
        double expResult = 0.9882132800102733;
        double result = instanceTests.R2();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of interceptStdErr method, of class LinearRegression.
     */
    @Test
    public void testInterceptStdErr() {
        System.out.println("interceptStdErr");
        double expResult = Math.sqrt(0.15821553058105464);
        double result = instanceTests.interceptStdErr();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of slopeStdErr method, of class LinearRegression.
     */
    @Test
    public void testSlopeStdErr() {
        System.out.println("slopeStdErr");
        double expResult = Math.sqrt(6.124472151524696E-4);
        double result = instanceTests.slopeStdErr();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of predict method, of class LinearRegression.
     */
    @Test
    public void testPredict() {
        System.out.println("predict");
        double x = 1.0;
        double expResult = 0.7165775401069518*x + -0.36541889483065937;
        double result = instanceTests.predict(x);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getST method, of class LinearRegression.
     */
    @Test
    public void testGetST() {
        System.out.println("getST");
        double expResult = 388.66666666666663;
        double result = instanceTests.getST();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSE method, of class LinearRegression.
     */
    @Test
    public void testGetSE() {
        System.out.println("getSE");
        double expResult = 4.581105169340473;
        double result = instanceTests.getSE();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSR method, of class LinearRegression.
     */
    @Test
    public void testGetSR() {
        System.out.println("getSR");
        double expResult = 384.0855614973262;
        double result = instanceTests.getSR();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of decision method, of class LinearRegression.
     */
    @Test
    public void testDecision() {
        System.out.println("decision");
        String expResult = "Reject H0.";
        String result = instanceTests.decision();
        assertEquals(expResult, result);
    }
    
}
