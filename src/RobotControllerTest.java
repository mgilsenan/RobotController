import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotControllerTest {

	private RobotController rc;

	@BeforeEach
	void init() {
		rc = new RobotController();
		rc.executeCommands("I 10");
	}

	@Test
	void testPenUp() {
		rc.executeCommands("U");
		assertEquals("UP", rc.getPenState());
	}

	@Test
	void testPenDown() {
		rc.executeCommands("D");
		assertEquals("DOWN", rc.getPenState());
	}
	
	 
	@Test 
	void testTurnRight() { 
		rc.executeCommands("R");
		assertEquals("EAST", rc.getFacingDirection());
	}
	
	@Test
	void testTurnLef() {
		rc.executeCommands("L");
		assertEquals("WEST", rc.getFacingDirection());
	}
	
	@Test
	void testMoveForward() {
		rc.executeCommands("M 5");
		assertEquals(4, rc.getXCoord());
		assertEquals(0, rc.getYCoord());
	}

}
