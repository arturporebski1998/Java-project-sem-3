package artur.porebski.controller;

import artur.porebski.model.Calculations;
import artur.porebski.view.View;
import java.util.InputMismatchException;

/**
 * Main class of the application
 *
 * @author Artur Porębski
 * @version 3.0
 */
public class Main {
    
    /**
     * Main method of the application
     *
     * @param args Takes size of an array as initial parameter
     */
    public static void main(String[] args) {
        
        int size = 0;
        
        double[] myArray;
        View view = new View();
        Calculations calculations = new Calculations();
        
        if (args.length > 0){
            try {
                size = Integer.parseInt(args[0]);
                if(size > 0){

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
                                size = view.getSize(size);
                            }catch(InputMismatchException e) {
                                error = true;
                                view.displayText(9); 
                                view.displayText(3); 
                            }
                        }while(error);
                        while (size <= 0) {
                            view.displayText(2); 
                            try {
                            size = view.getSize(size);
                            }catch(InputMismatchException e) {
                                view.displayText(9); 
                                view.displayText(3);
                            }
                        }
                        if (size > 0) {
                            myArray = new double[size];
                            view.fillArray(myArray);
                            view.displayArray(myArray);
                            for (int i=1;i<9;i++){
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
            catch (NumberFormatException e) {
                view.displayText(7);
            }
        }
        else if (args.length == 0) {
            view.displayText(10);
        }
        else {
            view.displayText(8);
        }

    }
    

}
