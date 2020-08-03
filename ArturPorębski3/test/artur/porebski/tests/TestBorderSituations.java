package artur.porebski.tests;

import artur.porebski.model.Calculations;
import artur.porebski.view.View;
import java.util.Vector;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;



public class TestBorderSituations {
    
    @Test
    public void testFlowControl() {
        if ((2 + 2) != 4) {
            fail("Error in adding!");
        }
    }
    
    Calculations testBorder;
    
    public void fillMyVector(Vector<Double> vector, int whichFilling){
        if (whichFilling == 1) {
            vector.add(0.0); vector.add(0.0); vector.add(0.0); vector.add(0.0); vector.add(0.0);}
        else if (whichFilling == 2){
            vector.add(10.0); vector.add(10.0); vector.add(10.0); vector.add(10.0); vector.add(10.0);}
        else
            fail("Wrong filling vector number typed");
    }
    
    
    @Test
    public void TestZeroVector() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,1);
        testBorder = new Calculations();
        assertEquals(0.0, testBorder.mean(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.median(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.variance(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.stdDev(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.geometricMean(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.harmonicMean(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.coefOfVar(vector1, vector1.size()), 0.0);
        assertEquals(0.0, testBorder.minimum(vector1), 0.0);
        assertEquals(0.0, testBorder.maximum(vector1, vector1.size()), 0.0);
    }
    
    @Test
    public void TestVectorWithTheSameValues() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,2);
        testBorder = new Calculations();
        assertEquals( 10.0, testBorder.mean(vector1, vector1.size()),0.0);
        assertEquals( 10.0, testBorder.median(vector1, vector1.size()),0.0);
        assertEquals( 10.0, testBorder.minimum(vector1), 0.0);
        assertEquals( 10.0, testBorder.maximum(vector1, vector1.size()), 0.0);
    }
    
    @Test
    public void TestVectorWithOneValue() throws Exception {
        Vector<Double> vector = new Vector<Double>();
        vector.add(5.0);
        testBorder = new Calculations();
        assertEquals(5.0, testBorder.mean(vector, vector.size()), 0.0);
        assertEquals(5.0, testBorder.median(vector, vector.size()), 0.0);
        assertEquals(5.0, testBorder.geometricMean(vector, vector.size()), 0.0);
        assertEquals(5.0, testBorder.harmonicMean(vector, vector.size()), 0.0);
        assertEquals(5.0, testBorder.minimum(vector), 0.0);
        assertEquals(5.0, testBorder.maximum(vector, vector.size()), 0.0);
        
        assertEquals(0.0, testBorder.variance(vector, vector.size()), 0.0);
        assertEquals(0.0, testBorder.stdDev(vector, vector.size()), 0.0);
        assertEquals(0.0, testBorder.coefOfVar(vector, vector.size()), 0.0);
    }
    
    
    View testProperYesNo;
    
    String word11 = "yes";
    String word12 = "Yes";
    String word13 = "YES";
    String word21 = "no";
    String word22 = "No";
    String word23 = "NO";
    
    @Test
    public void TestStringToBool_11() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word11),true);
    }
    
    @Test
    public void TestStringToBool2() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word12),true);
    }
    
    @Test
    public void TestStringToBoo_l3() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word13),true);
    }
    
    @Test
    public void TestStringToBool_21() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word21),false);
    }
    
    @Test
    public void TestStringToBool_22() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word22),false);
    }
    
    @Test
    public void TestStringToBool_23() throws Exception {
        testProperYesNo = new View();
        assertEquals(testProperYesNo.stringToBool(word23),false);
    }
}
