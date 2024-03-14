package gameutils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Utils {

    private Utils() {}  // Cannot be Instantiated

    public static final Scanner scanner = new Scanner (System.in);
    
    public static String readString(String prompt) {
        String input;
        do{
            System.out.println(prompt);
            try{    
                input = scanner.next();
            }
            catch(Exception e) {
                System.out.println("An unexpected error occured, please try again: ");
                input = null;
            }
        } while (input == null);
        return input;
    }
    
    public static int readInt(String prompt) {
        int input;
        do{
            System.out.println(prompt);
            try{    
                input = Integer.parseInt(scanner.next());
            }
            catch(InputMismatchException e) {
                System.out.println("Please enter an number: ");
                input = -1;
            }
            catch(Exception e) {
                System.out.println("An unexpected error occured, please try again: ");
                input = -1;
            }
        } while (input == -1);
        return input;
    }

    public static int readInt(String prompt, int min, int max) {
        int input = readInt(prompt);
        while (input < min || input > max) {
            input = readInt("Please enter a number from " + min + " to " + max);
        }
        return input;
    }

    public static void printStrings(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }

    public static void waitSeconds(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}