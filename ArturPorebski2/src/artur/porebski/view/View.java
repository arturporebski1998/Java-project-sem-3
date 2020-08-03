package artur.porebski.view;
import java.util.Scanner;
import java.util.Vector;

/**
 * Exception class that is generated when user's input text is inappropriate
 * @author Artur Porębski
 * @version 1.0
 */
class ImproperInputTextException extends Exception {

    /**
     * Constructor without parameters
     */
    public ImproperInputTextException() {}

    /**
     * Constructor
     * 
     * @param message Display message
     */
    public ImproperInputTextException(String message) {
	super(message); 
    }
    
}

/**
 * Class containing methods controling the input and output stream
 * @author Artur Porębski
 * @version 3.0
 */
public class View {
    /**
     * Method, which displays chosen line of text
     * @param line Number of text line which will be displayed
     */
    public void displayText(int line){
        switch(line) {
            case 1:
              System.out.print("Type the size of an array: ");
              break;
            case 2:
              System.out.print("Array size must be greater than 0!\nTry again: ");
              break;
            case 3:
              System.out.print("\nType the size of new array: ");
              break;
            case 4:
              System.out.println("\n-----------------------------------");
              break;
            case 5:
              System.out.print("\nYou can turn off the console window.\n");
              break;
            case 6:
              System.out.print("Wrong size. Size of an array must be greater than 0.\n");
              break;
            case 7:
              System.out.print("Wrong type of parameter. Size must be integer type.\n");
              break;
            case 8:
              System.out.print("Wrong parameter! Size of an array must be one integer number only.\n");
              break;
            case 9:
              System.out.print("Size of an array must be a number!");
              break;
            case 10:
              System.out.print("No input parameter!\n");
              break;
              
        }       
    }
    
    /**
     * Method, which fills the array with data entered by the user
     * @param arr Parameter to which a filled table is assigned
     */
    public void fillArray(double[] arr) {
        String word;
        for(int i=0;i<arr.length;i++) {
           System.out.print("Type " + (i+1) + ". number: ");
           Scanner scan = new Scanner(System.in);
           try{
                word = scan.nextLine();
                word = word.replaceAll(",",".");
                arr[i] = Double.parseDouble(word); 
           }catch(NumberFormatException e){
               System.out.print("Input must be a number! Try again:\n");
               i--;
           }
       }
    }
    
    /**
     * Method, which display filled array
     * @param arr Parameter to which a filled table is assigned
     */
    public void displayArray(double[] arr) {
        System.out.print("\nConsidered data:\n| ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.print("\n\n");
    }
    
    
    /**
     * Method, which display chosen statistical operation
     * @param result Stores value of statistical operation
     * @param operation Defines number of statistical operation to display
     */
    public void displayAllStatistics(double result, int operation) {
        Vector<String> operations = new Vector<>();
        switch(operation) {
            case 1:
              operations.add("1. Mean");
              break;
            case 2:
              operations.add("2. Median");
              break;
            case 3:
              operations.add("3. Variance");
              break;
            case 4:
              operations.add("4. Standard deviation");
              break;
            case 5:
              operations.add("5. Geometric Mean");
              break;
            case 6:
              operations.add("6. Harmonic mean");
              break;
            case 7:
              operations.add("7. Coeffficient of variation");
              break;
            case 8:
              operations.add("8. Minimum value");
              break;
            case 9:
              operations.add("9. Maximum value");
              break;
        }      
        for (String element : operations) {
            System.out.print(element + " = " + result);
        }
        System.out.println();
        System.out.println();
    }
    
    /**
     * Method checking if the user wants to examine the new array
     * @return Boolean variable 1(yes) or 0(no)
     */
    public boolean yesOrNo() {

        boolean trueOrFalse = true;
        boolean error;
        String input;
        System.out.print("Do you want to test new data?\nType 'yes' or 'no': ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().toLowerCase();
        try {
             trueOrFalse = stringToBool(input);
        }catch (ImproperInputTextException e) {
             System.out.println(e.getMessage());
             trueOrFalse = yesOrNo();
        }
    return trueOrFalse;
    }
    
    /**
     * Method assigning the entered number to parameter
     * @param s Patameter to which the typed number is assigned
     * @return 
     */
    public static int getSize(int s) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextInt();
        return s;
    }
    
    /**
     * Method that allows to enter only the word 'yes' or 'no', otherwise throws an exception
     * @param word Parameter to which entered text is assigned
     * @return Boolean parameter true or false
     * @throws ImproperInputTextException Exception, which displays text about proper input
     */
    public static boolean stringToBool(String word) throws ImproperInputTextException{    
        boolean trueOrFalse = false;
        if("yes".equals(word)){
          trueOrFalse = true; 
        }else if("no".equals(word)){
          trueOrFalse = false; 
        }else{
          throw new ImproperInputTextException("The input must be 'yes' or 'no'!");
        }
        return trueOrFalse;
    }
}
