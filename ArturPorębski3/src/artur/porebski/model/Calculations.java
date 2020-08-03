package artur.porebski.model;
import java.util.Vector;
import java.util.Collections;

/**
 * Class containing separate methods for each statistic operation
 * @author Artur Porębski
 * @version 4.0
 */
public class Calculations {
    
    /**
    * Method rounding the given number to the specified number of decimal places
    * @param num Number to round
    * @param dec Number of decimal places
    * @return double - returns rounded number
    */
    public double roundNumber(double num, int dec) {
        int multi = (int) Math.pow(10, dec);
        int temp = (int) Math.round(num * multi);
        return (double) temp / multi;
    }
    
    
    /**
     * Method calcultaing mean value from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The mean value calculated from the vector
     */
    public double mean(Vector<Double> Vector, int size) {
      
      double mean = 0;
      for(int i=0;i<size;i++) {
        mean += Vector.elementAt(i);
      }
      mean = mean/size;
      return roundNumber(mean,2);
    } 
    
    
    /**
     * Method calcultaing median from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The median value calculated from the vector
     */
    public double median(Vector<Double> Vector, int size) {

      double median;
      double mean2values;
      Collections.sort(Vector);
      
      if (size % 2 == 0 ) {
          mean2values = Vector.elementAt(size/2) + Vector.elementAt( (size/2)-1 );
          median = mean2values/2;
      }
      else {
          median = Vector.elementAt(size/2);
      }
      return roundNumber(median,2);
    }
 
    
    /**
     * Method calcultaing variance from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The variance value calculated from the vector
     */
    public double variance(Vector<Double> Vector, int size) {
        
        double variance = 0;
        double varianceNominator;
        Vector<Double> var = new Vector<>();
        for(int i=0;i<size;i++) {
              varianceNominator = (Vector.elementAt(i)- mean(Vector,size))*(Vector.elementAt(i)-mean(Vector,size));
              var.add(varianceNominator);
          }
        for (double element : var) {
            variance += element/size;
        }
        return roundNumber(variance,2);
    }
    
    
    /**
     * Method calcultaing standart deviation from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The standard deviation value calculated from the vector
     */
    public double stdDev(Vector<Double> Vector, int size) {

        double stdDevi = Math.sqrt(variance(Vector, size));
        return roundNumber(stdDevi,2);
    }
    
    
    /**
     * Method calcultaing geometric mean from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The geometric mean value calculated from the vector
     */
    public double geometricMean(Vector<Double> Vector, int size) {
        int numOfNegVal = 0;
        double wrongDouble = 0.00000001;
        for(int i=0;i<size;i++) {
            if(Vector.elementAt(i)<0) {
                numOfNegVal++;
            } 
        }
        if (numOfNegVal == 0) {
            double geometric = 1;
            for (int i = 0; i<size; i++){
              geometric *= Vector.elementAt(i);
            }
            geometric = Math.pow(geometric, (1.0/size));
            return roundNumber(geometric,2);
        }
        else {
            return wrongDouble;
        }
    }
    
  
    /**
     * Method calcultaing harmonic mean from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The harmonic mean value calculated from the vector
     */
    public double harmonicMean(Vector<Double> Vector, int size) {

        double harmonic = 0;
        for (int i = 0; i<size; i++){
          harmonic += 1/Vector.elementAt(i);
        }
        harmonic = size/harmonic;
        return roundNumber(harmonic,2);
    }
    
    
    /**
     * Method calcultaing coefficient of variation from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The coefficient of variation value calculated from the vector
     */
    public double coefOfVar(Vector<Double> Vector, int size) {
        double coefOfVar = stdDev(Vector,size)/mean(Vector,size);
        return roundNumber(coefOfVar,2);
    }
    
  
    /**
     * Method calcultaing minimum from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @return The minimum value calculated from the vector
     */
    public double minimum(Vector<Double> Vector) {
        Collections.sort(Vector);
        double min = Vector.elementAt(0);
        return min;
    }
    
    
    
    /**
     * Method calcultaing maximum from the data
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @return The maximum value calculated from the vector
     */
    public double maximum(Vector<Double> Vector, int size) {
        Collections.sort(Vector);
        double max = Vector.elementAt(size-1);
        return max;
    }
    
    
    
    /**
     * A method that allows to choose which statistical operation perform
     * @param Vector Parameter to which a filled vector is assigned
     * @param size Parameter to which the size of vector is assigned
     * @param operation Defines number of statistical operation to calculate
     * @return The value of calculated statistical operation
     */
    public double allOpeartions(Vector<Double> Vector, int size, int operation ) {
        double result = 0;
        switch(operation) {
            case 1:
              result = mean(Vector,size);
              break;
            case 2:
              result = median(Vector,size);
              break;
            case 3:
              result = variance(Vector,size);
              break;
            case 4:
              result = stdDev(Vector,size);
              break;
            case 5:
              result = geometricMean(Vector,size);
              break;
            case 6:
              result = harmonicMean(Vector,size);
              break;
            case 7:
              result = coefOfVar(Vector,size);
              break;
            case 8:
              result = minimum(Vector);
              break;
            case 9:
              result = maximum(Vector,size);
              break;
        }
        return result;
    }
}
