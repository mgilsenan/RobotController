import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotControllerTest {

	private final ByteArrayOutputStream ouput = new ByteArrayOutputStream();
    private final PrintStream firstOuput = System.out;


	@BeforeEach
    void setUp() {
        System.setOut(new PrintStream(ouput));
    }

    @AfterEach
    void tearDown() {
        System.setOut(firstOuput);
    }

	//Requiement 1 Completed
	@Test
	void canMoveForwardTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");		
		boolean canMoveForward = rc.canMoveForward(3);
		assertEquals(true, canMoveForward);
	}

	@Test
	void canMoveForwardFearthestNorthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 3");		
		assertEquals(false, rc.canMoveForward(5));
	}

	@Test
	void canMoveForwardFearthestSouthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 3");		
		rc.executeCommands("R");
		rc.executeCommands("R");
		assertEquals(false, rc.canMoveForward(3));
	}

	@Test
	void canMoveForwardFearthestEastTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 3");		
		rc.executeCommands("R");
		assertEquals(false, rc.canMoveForward(5));
	}

	@Test
	void canMoveForwardFearthestWestTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");		
		rc.executeCommands("L");
		assertEquals(false, rc.canMoveForward(3));
	}

	//Requirement 3 Completed
	@Test
	void penUpTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");		
		rc.executeCommands("U");
		assertEquals("UP", rc.getPenState());
	}

	//Requirement 4 Completed
	@Test
	void penDownTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");	
		rc.executeCommands("D");
		assertEquals("DOWN", rc.getPenState());
	}
	
	 
	// @Test 
	// void testTurnRight() { 
	// 	RobotController rc = new RobotController();
	// 	rc.executeCommands("I 10");	
	// 	rc.executeCommands("R");
	// 	assertEquals("EAST", rc.getFacingDirection());
	// }
	
	// @Test
	// void testTurnLef() {
	// 	RobotController rc = new RobotController();
	// 	rc.executeCommands("I 10");	
	// 	rc.executeCommands("L");
	// 	assertEquals("WEST", rc.getFacingDirection());
	// }
	
	// @Test
	// void testMoveForward() {
	// 	RobotController rc = new RobotController();
	// 	rc.executeCommands("I 10");	
	// 	rc.executeCommands("M 5");
	// 	assertEquals(4, rc.getXCoord());
	// 	assertEquals(0, rc.getYCoord());
	// }
	
	//Requirement 5 Completed
	@Test
	void moveRightFacingEastTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("R");
		rc.executeCommands("R");
		assertEquals("SOUTH", rc.getFacingDirection());
	}

	@Test
	void moveRightFacingWestTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("L");
		rc.executeCommands("R");
		assertEquals("NORTH", rc.getFacingDirection());
	}

	@Test
	void moveRightFacingNorthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("R");
		assertEquals("EAST", rc.getFacingDirection());
	}

	@Test
	void moveRightFacingSouthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("R");
		rc.executeCommands("R");
		rc.executeCommands("R");
		assertEquals("WEST", rc.getFacingDirection());
	}

	//Requirement 6 Completed
	@Test
	void moveLeftFacingEastTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("R");
		rc.executeCommands("L");
		assertEquals("NORTH", rc.getFacingDirection());
	}
	
	@Test
	void moveLeftFacingWestTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("L");
		rc.executeCommands("L");
		assertEquals("SOUTH", rc.getFacingDirection());
	}
	
	@Test
	void moveLeftFacingNorthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("L");
		assertEquals("WEST", rc.getFacingDirection());
	}
	
	@Test
	void moveLeftFacingSouthTest() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");
		rc.executeCommands("M 5");
		rc.executeCommands("R");
		rc.executeCommands("R");
		rc.executeCommands("L");
		assertEquals("EAST", rc.getFacingDirection());
	}
}
