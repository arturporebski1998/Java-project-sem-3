package artur.porebski.controller;

import artur.porebski.model.Calculations;
import artur.porebski.view.View;
import java.util.InputMismatchException;
import java.util.Vector;

/**
 * Main class of the application
 *
 * @author Artur Porębski
 * @version 4.0
 */
public class Main {
    
    /**
     * Main method of the application
     *
     * @param args Takes size of an array as initial parameter
     */
    public static void main(String[] args) {
        
        int mySize = 0;
        View view = new View();
        Calculations calculations = new Calculations();
       
        if (args.length > 0){
            try {
                mySize = Integer.parseInt(args[0]);
                if(mySize > 0){
                    Vector<Double> myVector = new Vector<>();
                    view.fillVector(myVector, mySize); 
                    view.displayVector(myVector, mySize);
                    
                    for (int i=1;i<=9;i++){
                        view.displayAllStatistics(calculations.allOpeartions(myVector,mySize,i),i,myVector, mySize);
                    }

                    while (view.yesOrNo()) {
                        boolean error;
                        view.displayText(4); 
                        view.displayText(3); 
                        do{
                            error = false;
                            try {
                                mySize = view.getSize(mySize);
                            }catch(InputMismatchException e) {
                                error = true;
                                view.displayText(9); 
                                view.displayText(3); 
                            }
                        }while(error);
                        while (mySize <= 0) {
                            view.displayText(2); 
                            try {
                            mySize = view.getSize(mySize);
                            }catch(InputMismatchException e) {
                                view.displayText(9); 
                                view.displayText(3);
                            }
                        }
                        if (mySize > 0) {
                            myVector = new Vector<>();
                            view.fillVector(myVector, mySize); 
                            view.displayVector(myVector, mySize);
                            for (int i=1;i<=9;i++){
                                view.displayAllStatistics(calculations.allOpeartions(myVector,mySize,i),i,myVector, mySize);
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
