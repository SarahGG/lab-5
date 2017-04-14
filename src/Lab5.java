import java.util.Random;
import java.util.Scanner;

/**
 * rolls two dice with random results
 */
public class Lab5 {
    private static Scanner scnr = new Scanner(System.in);
    private static boolean doAgain = false;

    public static void main(String[] args) {
        int dieFaces;
        int dieAmount;
        String dieResults = "";
        Random rollResult = new Random();

        do {
            System.out.print("How many faces should your die have? ");
            dieFaces = scnr.nextInt();

            System.out.print("How many dice would you like to roll? ");
            dieAmount = scnr.nextInt();

            for(int i = 1; i <= dieAmount; i++){
                dieResults = "" + dieResults + rollResult.nextInt(dieFaces) + " ";
            }
            System.out.println(dieResults);

            inputCheck();
        }
        while(doAgain);
    }
    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void inputCheck() {
        boolean correctInput; // will check that user has input 'n', 'N', 'y', or 'Y'
        char userContinueCheck = 'z'; // will check that user wants to repeat the program

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
                case 'z':
                    correctInput = true; // can repeat test if tester wants
                    System.out.println("Your userContinueCheck has failed.");
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
}
