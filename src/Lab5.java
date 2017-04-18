import java.util.Random;
import java.util.Scanner;

/**
 * rolls two dice with random results
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class Lab5 {
    private static Scanner scnr = new Scanner(System.in);
    private static boolean doAgain = false;

    /**
     * My main method
     * promopts user and collects number of faces on each die
     * prompts user and collects number dice to roll
     * prints the results
     * asks user if they want to continue continue(y/n)
     *
     * @param args psvm string arguments
     */
    public static void main(String[] args) {
        int dieFaces;
        int dieAmount;

        do {
            System.out.print("How many faces should your die have? ");
            dieFaces = scnr.nextInt();

            System.out.print("How many dice would you like to roll? ");
            dieAmount = scnr.nextInt();

            //prints roll results to the console
            printResults(dieAmount, dieFaces);

            // asks user if they want to go again, and manually validates input
            inputCheck();
        }
        // will only repeat the loop if inputCheck() changes doAgain to true
        while(doAgain);
    }

    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void inputCheck() {
        boolean correctInput; // will check that user has input 'n', 'N', 'y', or 'Y'
        char userContinueCheck; // will check that user wants to repeat the program

        /* asks user if they want to continue and then checks their input
        for yes, no, a test result, or an incorrect input */
        do {
            System.out.print("Continue? (y/n): ");
            userContinueCheck = scnr.next("[a-zA-Z]").charAt(0); // accepts a letter as input

            switch (userContinueCheck) {
                case 'y':
                case 'Y':
                    correctInput = true; // 'y' and 'Y' are correct input
                    doAgain = true; // will repeat the main program
                    break;
                case 'n':
                case 'N':
                    correctInput = true; // 'n' and 'N' are correct input
                    doAgain = false; // will exit the main program
                    break;
                default:
                    correctInput = false; // makes the doWhile loop ask for another input
                    System.out.println("Incorrect Input!"); // yells at you for misbehavin'
                    System.out.println("");
                    break;
            }
        }
        // repeats the loop if the user gave the wrong input
        while (!correctInput);
    }

    /**
     * concantonates each dice result to the rollResults string and then prints to string to the console
     */
    private static void printResults (int dieAmount, int dieFaces) {
        String resultsSentence = "";
        Random rollResult = new Random();

        for(int i = 1; i <= dieAmount; i++){
            resultsSentence += rollResult.nextInt(dieFaces) + " ";
        }

        //trims trailing white space and prints dieResults to the console
        System.out.println(resultsSentence.trim() + ".");
    }
}
