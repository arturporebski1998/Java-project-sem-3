package artur.porebski.view;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Class containing methods controling the input and output stream
 * @author Artur Porębski
 * @version 2.0
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
              System.out.print("You can turn off the console window.\n");
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
              
        }       
    }
    
    /**
     * Method, which fills the array with data entered by the user
     * @param arr Parameter to which a filled table is assigned
     */
    public void fillArray(double[] arr) {
        
        for(int i=0;i<arr.length;i++) {
           System.out.print("Type " + (i+1) + ". number: ");
           Scanner scan = new Scanner(System.in);
           try{
                arr[i] = scan.nextDouble();
           }catch(InputMismatchException e){
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
        switch(operation) {
            case 1:
              System.out.println("1. Mean = " + result);
              break;
            case 2:
              System.out.println("2. Median = " + result);
              break;
            case 3:
              System.out.println("3. Variance = " + result);
              break;
            case 4:
              System.out.println("4. Standard deviation = " + result);
              break;
            case 5:
              System.out.println("5. Geometric Mean = " + result);
              break;
            case 6:
              System.out.println("6. Harmonic mean = " + result);
              break;
            case 7:
              System.out.println("7. Coeffficient of variation = " + result);
              break;
            case 8:
              System.out.println("8. Minimum value = " + result);
              break;
            case 9:
              System.out.println("9. Maximum value = " + result);
              break;
            
        }       
    }
    
    /**
     * Method, checking if the user wants to examine the new array
     * @return Boolean variable 1(yes) or 0(no)
     */
    public boolean yesOrNo() {

        boolean trueOrFalse = true;
        boolean error;
        int zeroOrOne = 0;
        System.out.print("\nDo you want to test new data?\nType 1 (yes) or 0 (no): ");
        do{
            error = false;
            Scanner scanner1 = new Scanner(System.in);
        
        try {
            zeroOrOne = scanner1.nextInt();
        }catch(InputMismatchException e){
            error = true;
            System.out.print("\nType proper number!\nType 1 (yes) or 0 (no): ");
        }
        
        }while(error);
        if (zeroOrOne == 1) {
            trueOrFalse = true;
        }
        else if (zeroOrOne == 0) {
            trueOrFalse = false;
        }
        
        while (zeroOrOne != 1 && zeroOrOne != 0 ) {
            boolean error1;
            Scanner scanner = new Scanner(System.in);
            do{
                System.out.print("Type proper number!\nType 1 (yes) or 0 (no): ");
                error1 = false;
                try {
                zeroOrOne = scanner.nextInt();
                }catch(InputMismatchException e){
                    error1 = true;
                    System.out.print("\nWrong number!\n");
                }
            }while(error);
            if (zeroOrOne == 1) {
                trueOrFalse = true;
            }
            else if (zeroOrOne == 0) {
                trueOrFalse = false;
            }
        }
        
    return trueOrFalse;
    }
    
    
    
}
