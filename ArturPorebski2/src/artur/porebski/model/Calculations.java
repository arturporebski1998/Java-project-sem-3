package artur.porebski.model;

import java.util.Arrays;
import java.util.Vector;

/**
 * Class containing separate methods for each statistic operation
 * @author Artur Porębski
 * @version 3.0
 */
public class Calculations {
    
    /**
    * Method rounding the given number to the specified number of decimal places
    * @param num number to round
    * @param dec  number of decimal places
    * @return double - returns rounded number
    */
    public static double roundNumber(double num, int dec) {
        int multi = (int) Math.pow(10, dec);
        int temp = (int) Math.round(num * multi);
        return (double) temp / multi;
    }
    
    
    /**
     * Method calcultaing mean value from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The mean value calculated from the array
     */
    public double mean(double[] arr) {

      double mean = 0;
      for(int i=0;i<arr.length;i++) {
        mean += arr[i];
      }
      mean = mean/arr.length;
      return roundNumber(mean,2);
  }
    
    /**
     * Method calcultaing median from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The median value calculated from the array
     */
    public double median(double[] arr) {

      double median;
      double mean2values;
      Arrays.sort(arr);
      
      if (arr.length % 2 == 0 ) {
          mean2values = arr[arr.length/2] + arr[(arr.length/2)-1];
          median = mean2values/2;
      }
      else {
          median = arr[arr.length/2];
      }
      return roundNumber(median,2);
  }
    
    /**
     * Method calcultaing variance from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The variance value calculated from the array
     */
    public double variance(double[] arr) {
        
        double variance = 0;
        double varianceNominator;
        //double[] var = new double[arr.length];
        Vector<Double> var = new Vector<>();
        for(int i=0;i<arr.length;i++) {
              varianceNominator = (arr[i]- mean(arr))*(arr[i]-mean(arr));
              var.add(varianceNominator);
          }
        for (double element : var) {
            variance += element/arr.length;
        }
        return roundNumber(variance,2);
    }
    
    /**
     * Method calcultaing standart deviation from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The standard deviation value calculated from the array
     */
    public double stdDev(double[] arr) {

        double stdDevi = Math.sqrt(variance(arr));
        return roundNumber(stdDevi,2);
    }
    
    /**
     * Method calcultaing geometric mean from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The geometric mean value calculated from the array
     */
    public double geometricMean(double[] arr) {

        double geometric = 1;
        for (int i = 0; i<arr.length; i++){
          geometric *= arr[i];
        }
        geometric = Math.pow(geometric, (1.0/arr.length));
        return roundNumber(geometric,2);
    }
  
    /**
     * Method calcultaing harmonic mean from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The harmonic mean value calculated from the array
     */
    public double harmonicMean(double[] arr) {

        double harmonic = 0;
        for (int i = 0; i<arr.length; i++){
          harmonic += 1/arr[i];
        }
        harmonic = arr.length/harmonic;
        return roundNumber(harmonic,2);
    }
    
    /**
     * Method calcultaing coefficient of variation from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The coefficient of variation value calculated from the array
     */
    public double coefOfVar(double[] arr) {

        double coefOfVar = stdDev(arr)/mean(arr);
        return roundNumber(coefOfVar,2);
    }
  
    /**
     * Method calcultaing minimum from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The minimum value calculated from the array
     */
    public double minimum(double[] arr) {
        Arrays.sort(arr);
        double min = arr[0];
        return min;
    }
    
    /**
     * Method calcultaing maximum from the data
     * @param arr Parameter to which a filled table is assigned
     * @return The maximum value calculated from the array
     */
    public double maximum(double[] arr) {
        Arrays.sort(arr);
        double max = arr[arr.length-1];
        return max;
    }
    
    /**
     * A method that allows to choose which statistical operation perform
     * @param arr Parameter to which a filled table is assigned
     * @param operation Defines number of statistical operation to calculate
     * @return The value of calculated statistical operation
     */
    public double allOpeartions(double[] arr, int operation) {
        double result = 0;
        switch(operation) {
            case 1:
              result = mean(arr);
              break;
            case 2:
              result = median(arr);
              break;
            case 3:
              result = variance(arr);
              break;
            case 4:
              result = stdDev(arr);
              break;
            case 5:
              result = geometricMean(arr);
              break;
            case 6:
              result = harmonicMean(arr);
              break;
            case 7:
              result = coefOfVar(arr);
              break;
            case 8:
              result = minimum(arr);
              break;
            case 9:
              result = maximum(arr);
              break;
        }  
        
        return result;
    }

    
     
   
}
