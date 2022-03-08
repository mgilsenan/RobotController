import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static RobotController robotController;
    public static void main(String[] args) {
       
        RobotController robotController = new RobotController();

        try (Scanner scan = new Scanner(System.in)) {

            robotController.printInstructions();

            String userInput;

            while(true)
            {
                System.out.print("Enter command: ");

                userInput = scan.nextLine();
                
                robotController.executeCommands(userInput);
                
            }
                
        }
    
    }
    
}