import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotControllerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void out() {
	    System.out.print("hello");
	    assertEquals("hello", outContent.toString());
	}

	@Test
	public void err() {
	    System.err.print("hello again");
	    assertEquals("hello again", errContent.toString());
	}
	
	
	@Test
	void testPenUp() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");		
		rc.executeCommands("U");
		assertEquals("UP", rc.getPenState());
	}

	@Test
	void testPenDown() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");	
		rc.executeCommands("D");
		assertEquals("DOWN", rc.getPenState());
	}
	
	 
	@Test 
	void testTurnRight() { 
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");	
		rc.executeCommands("R");
		assertEquals("EAST", rc.getFacingDirection());
	}
	
	@Test
	void testTurnLef() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");	
		rc.executeCommands("L");
		assertEquals("WEST", rc.getFacingDirection());
	}
	
	@Test
	void testMoveForward() {
		RobotController rc = new RobotController();
		rc.executeCommands("I 10");	
		rc.executeCommands("M 5");
		assertEquals(4, rc.getXCoord());
		assertEquals(0, rc.getYCoord());
	}
	
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
