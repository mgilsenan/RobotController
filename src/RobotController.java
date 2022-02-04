import java.util.ArrayList;
import java.util.Arrays;

public class RobotController {

	private enum direction {East, West, North, South}
    private enum penState {Up, Down}
    private int[][] floor;
    //private Robot robot;
    private penState pen;
    private direction facingDirection;
    private int FloorTrackerRow;
    private int FloorTrackerColumn;

    public RobotController(){
        pen = penState.Up;
        facingDirection = direction.North;
        //robot = new Robot(0, 0);
    }

    public void executeCommands(String userInput){
        String[] commands = userInput.split("\\s+");
        String command = commands[0];
        
        if (command.equals("U")|| command.equals("u")){
            //pen up
            penUp();
        }
        else if (command.equals("D") || command.equals("d")){
            //pen down
            penDown();
        }
        else if (command.equals("R") || command.equals("r")){
            //turn right, if ycoordinate is ymax then can't go 
            moveRight();
        }
        else if (command.equals("L") || command.equals("l")){
            //turn left, if xcoordinate is 0 then can't go 
            moveLeft();
        }
        else if (command.equals("M") || command.equals("m")){
            //move forward
            try {
                maneuverRobot(Integer.parseInt(commands[1]));
            } catch (Exception e) {
                System.out.println("Did not enter a value");
            }
           
        }
        else if (command.equals("P") || command.equals("p")){
            //print
            printFloor();
        }
        else if (command.equals("C") || command.equals("c")){
            //print position and up or down
        	printPosition();
        }
        else if (command.equals("I") || command.equals("i")){
            try {
                initializeFloor(Integer.parseInt(commands[1]));
            } catch (Exception e) {
                System.out.println("Did not enter a value");
            }
        }
   }

    private void maneuverRobot(int steps) {
    	while (true) {
    		if(steps <= 0){
                System.out.println("Did not move forward, enter a value greater than zero");
                break;
            }
            
    		else if(canMoveForward(steps)){
                moveForward(steps);
                break;
            }
            else{
                System.out.println("outside the boundaries of the floor, enter a valid number");
                break;
            }  
    	}
    }

    //R1
    private boolean canMoveForward(int stepPositions) {
        
        if((FloorTrackerColumn + stepPositions >= floor.length)&&(facingDirection == direction.East)){
            return false;
        }
        
        if((FloorTrackerColumn - stepPositions < 0)&&(facingDirection == direction.West)){
            return false;
        }
        
        if((FloorTrackerRow - stepPositions < 0)&&(facingDirection == direction.North)){
            return false;
        }
        
        if((FloorTrackerRow + stepPositions >= floor.length)&&(facingDirection==direction.South)){
            return false;
        }
                
        return true;
    }

    //R2
    private void printFloor() {
        for (int i = 0; i < floor.length; i++) {

            for (int j = 0; j < floor[i].length; j++) {
                if(floor[i][j]==1){
                    System.out.print("* ");
                } 
                else{
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    //R3
    private void penUp() {
    	pen = penState.Up;
    }

    //R4
    private void penDown() {
    	pen = penState.Down;
    }

    //R5
    private void moveRight() {
    	switch (facingDirection) {

    	case East:
    		facingDirection = direction.South;
    		break;

    	case West:
    		facingDirection = direction.North;
    		break;

    	case North:
    		facingDirection = direction.East;
    		break;

    	case South:
    		facingDirection = direction.West;
    		break;

    	default:
    		break;
    	}
    }

    //R6
    private void moveLeft() {
    	switch (facingDirection) {

    	case East:
    		facingDirection = direction.North;
    		break;

    	case West:
    		facingDirection = direction.South;
    		break;

    	case North:
    		facingDirection = direction.West;
    		break;

    	case South:
    		facingDirection = direction.East;
    		break;

    	default:
    		break;
    	}
    }

    private void moveForward(int stepPositions) {

        modifyingFloor(stepPositions);

        modifyingCoordinates(stepPositions);
    }

    //R7
    private void modifyingFloor(int stepPositions) {
        if (pen == penState.Down) {
            for (int i = 0; i <= stepPositions; i++) {

                switch (facingDirection) {

                    case East:
                        floor[FloorTrackerRow][FloorTrackerColumn + i] = 1;
                        break;

                    case West:
                        floor[FloorTrackerRow][FloorTrackerColumn - i] = 1;
                        break;

                    case North:
                        floor[FloorTrackerRow - i][FloorTrackerColumn] = 1;   
                        break;
                    case South:
                        floor[FloorTrackerRow + i][FloorTrackerColumn] = 1;
                        break;
                    default:
                        break;
                }
                
            }
        
        }
    }

    private void modifyingCoordinates(int stepPositions) {
        switch (facingDirection) {
            
            case East:
                FloorTrackerColumn += stepPositions;
                break;

            case West:
                FloorTrackerColumn -= stepPositions;
                break;

            case North:
                FloorTrackerRow -= stepPositions;
                break;

            case South:
                FloorTrackerRow += stepPositions;
                break;

            default:
                break;
        }
    }

    private void initializeFloor(int arraySize){
        this.floor = new int[arraySize][arraySize];

        FloorTrackerRow = floor.length - 1;

        FloorTrackerColumn = 0;
    } 

    //R8
    public void printPosition() {
        System.out.println("Position: "+ FloorTrackerColumn +", " + Math.abs(FloorTrackerRow - floor.length + 1) + " - Pen: " + pen + " - Facing: " + facingDirection);
    }
    
    public String getPenState() {
    	return pen.toString().toUpperCase();
    }
    
    public String getFacingDirection() {
    	return facingDirection.toString().toUpperCase();
    }
    
    public int getXCoord() {
    	return FloorTrackerRow;
    }
    
    public int getYCoord() {
    	return FloorTrackerColumn;
    }

}
