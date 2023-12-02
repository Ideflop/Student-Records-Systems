import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    /**
     * This method is used to create the scanner
     * @return the scanner
     */
    public static Scanner scanOpen(){
        return new Scanner(System.in);
    }

    /**
     * This method is used to close the scanner 
     * @param scanner closes the scanner
     */
    public static void scanClose(Scanner scanner){
        scanner.close();
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a String else it will give an error 
     * @param scanner scans a string
     * @return the user input as a string 
     */
    public static String scanString(Scanner scanner){
        String userInput;
        try {
            userInput = scanner.next();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a String");
        }
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is an Int else it will give an error
     * @param scanner scans an int
     * @return the user input as an int
     */
    public static int scanInt(Scanner scanner){
        int userInput;
        try {
            userInput = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be an Integer");
        }
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a long else it will give an error 
     * @param scanner scans a long
     * @return the user input as a long
     */
    public static long scanLong(Scanner scanner){
        long userInput;
        try{
            userInput = scanner.nextLong();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a Long");
        }
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a double else it will give an error 
     * @param scanner scans a double
     * @return the user input as a double
     */
    public static double scanDouble(Scanner scanner){
        double userInput;
        try{
            userInput = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a Double");
        }
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a short else it will give an error 
     * @param scanner scans a short
     * @return the user input as a short
     */
    public static short scanShort(Scanner scanner){
        short userInput;
        try{
            userInput = scanner.nextShort();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a Short");
        }    
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a float else it will give an error 
     * @param scanner scans a float
     * @return the user input as a float 
     */
    public static float scanFloat(Scanner scanner){
        float userInput;
        try{
            userInput = scanner.nextFloat();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a Float");
        }
        return userInput;
    }

    /**
     * This method is used to scan the value of the input and check
     * if it is a boolean else it will give an error 
     * @param scanner scans a boolean
     * @return the user input as a boolean
     */
    public static boolean scanBoolean(Scanner scanner){
        boolean userInput; 
        try{
            userInput = scanner.nextBoolean();
            scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a Boolean");
        }
        return userInput;
    }

    /**
     * This method is used to scan the next Line of the input and check
     * if it is a String else it will give an error
     * @param scanner scans the next line
     * @return the user input as a string
     */
    public static String scanNextLine(Scanner scanner){
        String userInput;
        try{
            userInput = scanner.nextLine();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Input has to be a String");
        }
        return userInput;
    }
}
