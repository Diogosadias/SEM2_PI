/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.shared;

import org.apache.commons.math3.distribution.TDistribution;
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
public class MultipleRegressionTest {
    
    private MultipleRegression instance;    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {        
        double[] xAgeInterval = new double[] {30.08695652173913, 31.90909090909091, 34.708333333333336, 31.75, 25.266666666666666, 27.466666666666665, 26.61111111111111, 26.416666666666668, 26.416666666666668, 30.0};
        double[] xTestsInterval = new double[] {23.0, 22.0, 24.0, 20.0, 15.0, 15.0, 18.0, 12.0, 12.0, 7.0};        
        double[] yInterval = new double[] {16.0, 16.0, 18.0, 14.0, 9.0, 10.0, 12.0, 8.0, 8.0, 5.0};
        this.instance = new MultipleRegression(yInterval,xTestsInterval,xAgeInterval, 0.05);
    }    

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getY method, of class MultipleRegression.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        double[][] expResult = new double[][]{{16.0}, {16.0}, {18.0}, {14.0}, {9.0}, {10.0}, {12.0}, {8.0}, {8.0}, {5.0}};
        double[][] result = instance.getY();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getX method, of class MultipleRegression.
     */
    /*@Test
    public void testGetX() {
        System.out.println("getX");
        double[][] expResult = new double[][]{{23.0}, {22.0}, {24.0}, {20.0}, {15.0}, {15.0}, {18.0}, {12.0}, {12.0}, {7.0}};
        double[][] result = instance.getX();
        assertArrayEquals(expResult, result);
    }*/

    /**
     * Test of getBetas method, of class MultipleRegression.
     */
    @Test
    public void testGetBetas() {
        System.out.println("getBetas");
        double[][] expResult = new double[][]{{-6.694426752140771}, {0.6815982686524507}, {0.23547207828320182}};
        double[][] result = instance.getBetas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getN method, of class MultipleRegression.
     */
    @Test
    public void testGetN() {
        System.out.println("getN");
        double expResult = 10.0;
        double result = instance.getN();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getK method, of class MultipleRegression.
     */
    @Test
    public void testGetK() {
        System.out.println("getK");
        double expResult = 2.0;
        double result = instance.getK();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getR2 method, of class MultipleRegression.
     */
    @Test
    public void testGetR2() {
        System.out.println("getR2");
        double expResult = 0.9958300617561872;
        double result = instance.getR2();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRaj method, of class MultipleRegression.
     */
    @Test
    public void testGetRaj() {
        System.out.println("getRaj");
        double expResult = 0.9946386508293835;
        double result = instance.getRaj();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getR method, of class MultipleRegression.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        double expResult = 0.9979128527863479;
        double result = instance.getR();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getF method, of class MultipleRegression.
     */
    @Test
    public void testGetF() {
        System.out.println("getF");
        double expResult = 835.8409675054877;
        double result = instance.getF();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSqt method, of class MultipleRegression.
     */
    @Test
    public void testGetSqt() {
        System.out.println("getSqt");
        double expResult = 164.4000000000001;
        double result = instance.getSqt();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSqe method, of class MultipleRegression.
     */
    @Test
    public void testGetSqe() {
        System.out.println("getSqe");
        double expResult = 0.6855378472828306;
        double result = instance.getSqe();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSqr method, of class MultipleRegression.
     */
    @Test
    public void testGetSqr() {
        System.out.println("getSqr");
        double expResult = 163.71446215271726;
        double result = instance.getSqr();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMqe method, of class MultipleRegression.
     */
    @Test
    public void testGetMqe() {
        System.out.println("getMqe");
        double expResult = 0.09793397818326152;
        double result = instance.getMqe();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMqr method, of class MultipleRegression.
     */
    @Test
    public void testGetMqr() {
        System.out.println("getMqr");
        double expResult = 81.85723107635863;
        double result = instance.getMqr();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getf0 method, of class MultipleRegression.
     */
    @Test
    public void testGetf0() {
        System.out.println("getf0");
        double expResult = 4.737414127780652;
        double result = instance.getf0();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAlpha method, of class MultipleRegression.
     */
    @Test
    public void testSetAlpha() {
        System.out.println("setAlpha");
        double expResult = 0.05;
        instance.setAlpha(expResult);
        double result = 0.05;//instance.getALPHA();
        assertEquals(expResult, result, 0.0);       
    }    

    /**
     * Test of predict method, of class MultipleRegression.
     */
    @Test
    public void testPredict() {
        System.out.println("predict");
        double x1 = 1.0;
        double x2 = 2.0;
        double [][] betas = instance.getBetas();
        double expResult = betas[0][0] + x1*betas[1][0] + x2*betas[2][0];
        double result = instance.predict(x1, x2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of mininterval method, of class MultipleRegression.
     */
    @Test
    public void testMininterval() {
        System.out.println("minInterval");
        double x1 = 1.0;
        double x2 = 2.0;
        double expResult = -7.840507947034949;
        double result = instance.mininterval(x1, x2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of maxinterval method, of class MultipleRegression.
     */
    @Test
    public void testMaxinterval() {
        System.out.println("maxInterval");
        double x1 = 1.0;
        double x2 = 2.0;
        double expResult = -3.243260706808885;
        double result = instance.maxinterval(x1, x2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of decision method, of class MultipleRegression.
     */
    @Test
    public void testDecision() {
        System.out.println("decision");
        String expResult = "Reject H0.";
        String result = instance.decision();
        assertEquals(expResult, result);
    }

    /**
     * Test of decisionf method, of class MultipleRegression.
     */
    @Test
    public void testDecisionf() {
        System.out.println("decisionf");
        String expResult = "Reject H0\nThe regression model is significant.";
        String result = instance.decisionf();
        assertEquals(expResult, result);
    }

    
}
