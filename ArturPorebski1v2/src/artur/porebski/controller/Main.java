package artur.porebski.controller;

import artur.porebski.model.Calculations;
import artur.porebski.view.View;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main class of the application
 *
 * @author Artur Porębski
 * @version 2.0
 */
public class Main {
    
    /**
     * Main method of the application
     *
     * @param args - Takes size of an array as initial parameter
     */
    public static void main(String[] args) {

        int size = 0;
        
        double[] myArray;
        View view = new View();
        Calculations calculations = new Calculations();

        try {
        size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {}
        finally{
        if (args.length == 1 && args.length > 0){
            if(args[0].matches(".*[0-9]+.*")) {
                if(Integer.parseInt(args[0])>0 ){

                    myArray = new double[size];

                    view.fillArray(myArray); 
                    view.displayArray(myArray);

                    for (int i=1;i<=9;i++){
                        view.displayAllStatistics(calculations.allOpeartions(myArray,i),i);
                    }

                    while (view.yesOrNo()) {
                        boolean error;
                        view.displayText(4); 
                        view.displayText(3); 
                        do{
                            error = false;
                            try {
                            Scanner scanner1 = new Scanner(System.in);
                            size = scanner1.nextInt();
                            }catch(InputMismatchException e) {
                                error = true;
                                view.displayText(9); 
                                view.displayText(3); 
                            }
                        }while(error);
                        Scanner scanner = new Scanner(System.in);
                        while (size <= 0) {
                            view.displayText(2); 
                            size = scanner.nextInt();
                        }
                        if (size > 0) {
                            myArray = new double[size];
                            view.fillArray(myArray);
                            for (int i=0;i<10;i++){
                                view.displayAllStatistics(calculations.allOpeartions(myArray,i),i);
                            }
                        }
                    }
                    view.displayText(5); 
                }
		else {
                    view.displayText(6);
                }
            }
	    else {
                view.displayText(7);
            }
        }
        else {
            view.displayText(8);
        }
        
    }
    }

}
