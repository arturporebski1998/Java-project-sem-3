package artur.porebski.tests;
import artur.porebski.model.Calculations;
import java.util.Vector;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestAbnormalSituations {
    Calculations testAbnormal;
    
    @Test
    public void testFlowControl() {
        if ((2 + 2) != 4) {
            fail("Error in adding!");
        }
    }
    
    @Test
    public void TestEmptyVector() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        testAbnormal = new Calculations();
        assertEquals(0.00, testAbnormal.mean(vector1, vector1.size()),0.00);
    }
    
    
    
    @Test
    public void TestVectorWithNegativeValue() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        testAbnormal = new Calculations();
        vector1.add(1.0); vector1.add(-5.0); vector1.add(-5.0); vector1.add(0.0);
        assertEquals(0.00000001, testAbnormal.geometricMean(vector1, vector1.size()),0.00);
       
    }

}

