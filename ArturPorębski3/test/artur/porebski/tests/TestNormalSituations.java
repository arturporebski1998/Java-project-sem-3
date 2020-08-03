package artur.porebski.tests;

import artur.porebski.model.Calculations;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

public class TestNormalSituations {
    
    @Test
    public void testFlowControl() {
        if ((2 + 2) != 4) {
            fail("Error in adding!");
        }
    }
    
    Calculations testMethod;
    
    public void fillMyVector(Vector<Double> vector, int whichFilling){
        if (whichFilling == 1) {
            vector.add(2.01); vector.add(4.22); vector.add(16.0); vector.add(6.313); vector.add(6.0); }
        else if (whichFilling == 2) {
            vector.add(6.7); vector.add(0.2345); vector.add(32.09); vector.add(-234.5); vector.add(145.70); }
        else if (whichFilling == 3) {
            vector.add(-2.01); vector.add(-4.22); vector.add(16.0); vector.add(-6.313); vector.add(86.0); }
        else if (whichFilling == 4) {
            vector.add(2.78); vector.add(7.02); vector.add(-16.7); vector.add(-6.7813); vector.add(-17.002); }
        else if (whichFilling == 5) {
            vector.add(8.09); vector.add(-4.92); vector.add(9.0); vector.add(-300.000); vector.add(-1.0007); }
        else
            fail("Wrong filling vector number typed");
    }
    
    @Test
    public void TestMean() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,1);
        testMethod = new Calculations();
        assertEquals(6.91, testMethod.mean(vector1, vector1.size()), 0.01);
    }
    
    
    @Test
    public void TestMedian() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,2);
        testMethod = new Calculations();
        assertEquals(6.7,testMethod.median(vector1, vector1.size()), 0.01);
    }
    
    
    @Test
    public void TestVariance() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,3);
        testMethod = new Calculations();
        assertEquals(1222.64, testMethod.variance(vector1, vector1.size()), 0.01);
    }
    
    
    @Test
    public void TestStdDev() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,3);
        testMethod = new Calculations();
        assertEquals(34.97, testMethod.stdDev(vector1, vector1.size()), 0.01);
    }
    
    @Test
    public void TestGeoMean() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,1);
        testMethod = new Calculations();
        assertEquals(5.52, testMethod.geometricMean(vector1, vector1.size()), 0.01);
    }
    
    @Test
    public void TestHarMean() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,4);
        testMethod = new Calculations();
        assertEquals(21.19, testMethod.harmonicMean(vector1, vector1.size()), 0.01);
    }
    
    @Test
    public void TestCoeffOfVar() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,5);
        testMethod = new Calculations();
        assertEquals(-2.1, testMethod.coefOfVar(vector1, vector1.size()), 0.01);
    }
    
    @Test
    public void TestMin() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,4);
        testMethod = new Calculations();
        assertEquals(-17.002, testMethod.minimum(vector1), 0.01);
    }
    
    @Test
    public void TestMax() throws Exception {
        Vector<Double> vector1 = new Vector<Double>();
        fillMyVector(vector1,2);
        testMethod = new Calculations();
        assertEquals(145.70, testMethod.maximum(vector1, vector1.size()), 0.01);
    }
    
    @Test
    public void TestRoundNumber() throws Exception {
        testMethod = new Calculations();
        assertEquals(15.16, testMethod.roundNumber(15.15985, 2), 0.0);
    }
 
}
