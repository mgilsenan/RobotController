import java.util.ArrayList;

public class RobotController {

    private int[][] floor;
    private int xCordinate;
    private int yCordinate;
    private penState pen;
    private direction facingDirection;
    private enum direction {East, West, North, South}
    private enum penState {Up, Down}

    public RobotController(){
        pen = penState.Up;
        facingDirection = direction.North;
    }

    public void executeCommands(String userInput){
        String[] commands = userInput.split("\\s+");
        String command = commands[0];
        
        if (command == "U" || command == "u"){
            //pen up
            penUp();
        }
        else if (command == "D" || command == "d"){
            //pen down
            penDown();
        }
        else if (command == "R" || command == "r"){
            //turn right, if ycordinate is ymax then can't go 
            moveRight();
        }
        else if (command == "L" || command == "l"){
            //turn left, if xcordinate is 0 then can't go 
            moveLeft();
        }
        else if (command == "M" || command == "m"){
            //move forward
            moveForward(Integer.parseInt(commands[1]));
        }
        else if (command == "P" || command == "p"){
            //print
            printFloor();
        }
        else if (command == "C" || command == "c"){
            //print position and up or down
            printPosition();
            printPenStatus();
        }
        else if (command == "I" || command == "i"){
            initializeFloor(Integer.parseInt(commands[1]));
        }    
   }

    private void printFloor() {
    }

    private void penUp() {
    }



    private void penDown() {
    }



    private void moveRight() {
    }



    private void moveLeft() {
    }



    private void moveForward(int stepPositions) {
    }



    private void initializeFloor(int arraySize){
        this.floor = new int[arraySize][arraySize];
        xCordinate = arraySize - 1;     
        yCordinate = arraySize - 1;   
    } 

    private void printPosition() {
        
    }

    private void printPenStatus() {
        
    }
    
    
}
