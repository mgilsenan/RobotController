import java.util.ArrayList;

public class RobotController {

	private enum direction {East, West, North, South}
    private enum penState {Up, Down}
    private int[][] floor;
    private int xCoordinate;
    private int yCoordinate;
    private Robot robot;
    private penState pen;
    private direction facingDirection;

    public RobotController(){
        pen = penState.Up;
        facingDirection = direction.North;
        robot = new Robot(0, 0);
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
            moveForward(Integer.parseInt(commands[1]));
        }
        else if (command.equals("P") || command.equals("p")){
            //print
            printFloor();
        }
        else if (command.equals("C") || command.equals("c")){
            //print position and up or down
        	printPosition();
        	printPenState();
        }
        else if (command.equals("I") || command.equals("i")){
            initializeFloor(Integer.parseInt(commands[1]));
        }
   }

    private void printFloor() {
    	for (int i = 0; i < floor.length; i++) {
    		for (int j = 0; j < floor[i].length; j++) {
    			if (floor[i][j] == 1)
    				System.out.print("*");
    	// if it is pen down then every 1 is an * 
    		}
    	}
    }
    private void penUp() {
    	pen = penState.Up;
    }

    private void penDown() {
    	pen = penState.Down;
    }

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
    	//if (pen == penState.Up)
    }

    private void initializeFloor(int arraySize){
        this.floor = new int[arraySize][arraySize];
        xCoordinate = 0;     
        yCoordinate = 0;
        robot.setX(xCoordinate);
        robot.setY(yCoordinate);
    } 

    private void printPosition() {
        System.out.println("Robot x coord: " + robot.getX() + ". Robot y coord: " + robot.getY() + ". Robot facing: " + facingDirection);
    }

    private void printPenState() {
        System.out.println(pen.toString());
    }
    
    
}
