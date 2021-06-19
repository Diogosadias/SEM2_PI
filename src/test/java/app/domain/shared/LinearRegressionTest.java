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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {        
        double[] xAgeInterval = new double[] {30.08695652173913, 31.90909090909091, 34.708333333333336, 31.75, 25.266666666666666, 27.466666666666665, 26.61111111111111, 26.416666666666668, 26.416666666666668, 30.0, 0.0, 0.0};
        double[] xTestsInterval = new double[] {23.0, 22.0, 24.0, 20.0, 15.0, 15.0, 18.0, 12.0, 12.0, 7.0, 0.0, 0.0};        
        double[] yInterval = new double[] {16.0, 16.0, 18.0, 14.0, 9.0, 10.0, 12.0, 8.0, 8.0, 5.0, 0.0, 0.0};
        this.instanceTests = new LinearRegression(xTestsInterval,yInterval, 0.05);
    }

    @After
    public void tearDown() throws Exception {
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
     * Test of dfSR method, of class LinearRegression.
     */
    @Test
    public void testDfSR() {
        System.out.println("dfSR");
        double expResult = 1.0;
        double result = instanceTests.dfSR();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of dfSE method, of class LinearRegression.
     */
    @Test
    public void testDfSE() {
        System.out.println("dfSE");
        double expResult = 10.0;
        double result = instanceTests.dfSE();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of dfST method, of class LinearRegression.
     */
    @Test
    public void testDfST() {
        System.out.println("dfST");
        double expResult = 11.0;
        double result = instanceTests.dfST();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of MSR method, of class LinearRegression.
     */
    @Test
    public void testMSR() {
        System.out.println("MSR");
        double expResult = instanceTests.getSR()/instanceTests.dfSR();
        double result = instanceTests.MSR();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of MSE method, of class LinearRegression.
     */
    @Test
    public void testMSE() {
        System.out.println("MSE");
        double expResult = instanceTests.getSE()/instanceTests.dfSE();
        double result = instanceTests.MSE();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of F method, of class LinearRegression.
     */
    @Test
    public void testF() {
        System.out.println("F");
        double expResult = instanceTests.MSR()/instanceTests.MSE();
        double result = instanceTests.F();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class LinearRegression.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "\nThe regression model fitted using data from the interval \n" +
                "^y = a + bx <=> ^y = -0,3654 + 0,7166 * x\n" +
                "b = 0,7166\n" +
                "a = -0,3654\n" +
                "//\n" +
                "Other statistics\n" +
                "R2 = 0,9882\n" +
                "R2adjusted = ...\n" +
                "R = 0,9941\n" +
                "//\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs = 2,2281\n" +
                "Decision: Reject H0.\n" +
                "//\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0\n" +
                "\t\t\tdf\t\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t1.0\t384,0856\t384,0856\t838,4125\t\n" +
                "Residual\t10.0\t4,5811\t\t0,4581\t\t\n" +
                "Total\t\t11.0\t388,6667\t\t\n" +
                "\n" +
                "Decision: f \n" +
                "0 > f0.05,(1.10)=0,0041";
        String result = instanceTests.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of delta method, of class LinearRegression.
     */
    @Test
    public void testDelta() {
        System.out.println("delta");
        double x0 = 1.0;
        double expResult = 0.8386788508455758;
        double result = instanceTests.delta(x0);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of decision method, of class LinearRegression.
     */
    @Test
    public void testDecisionReject() {
        System.out.println("decision");
        String expResult = "Reject H0.";
        String result = instanceTests.decision();
        assertEquals(expResult, result);
    }

    /**
     * Test of decision method, of class LinearRegression.
     */
    @Test
    public void testDecisionDontReject() {
        System.out.println("decision");
        String expResult = "Don't Reject H0.";
        instanceTests.setfDistribution(900.0);
        String result = instanceTests.decision();
        assertEquals(expResult, result);
    }

    /**
     * Test of getfDistribution method, of class LinearRegression.
     */
    @Test
    public void testGetfDistribution() {
        System.out.println("delta");
        double expResult = 0.004134251619444255;
        double result = instanceTests.getfDistribution();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setfDistribution method, of class LinearRegression.
     */
    @Test
    public void testSetfDistribution() {
        System.out.println("delta");
        double expResult = 100.0;
        instanceTests.setfDistribution(100.0);
        double result = 100.0;
        assertEquals(expResult, result, 0.0);
    }



}

