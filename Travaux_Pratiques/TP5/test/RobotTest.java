import org.junit.*;
import static org.junit.Assert.*;

import factory.Robot;   
import factory.util.*;   

public class RobotTest {	


    @Test
    public void robotCarryNoBoxWhenCreated() {
	Robot robbie = new Robot();
	assertFalse(robbie.carryingBox());
    }

    /**
     * Method allowing us to verify if this robot can take a Box or not
    */
    @Test
    public void robotCanTakeBoxIfNotCarrying() {
        // Initial situation
        Robot robbie = new Robot();
        Box box = new Box(10);
        // robot is wearing nothing
        assertFalse(robbie.carryingBox());
        robbie.take(box);      
        // execution of the tested method 
        assertSame(box, robbie.getCarriedBox());
    }
    
     @Test
    public void robotCannotTakeBoxIfAlreadyCarrying(){
      Robot robbie = new Robot();
      Box b1 = new  Box(10);
      robbie.take(b1);
      assertSame(b1,robbie.getCarriedBox());
      Box b2 = new  Box(5);
      robbie.take(b2);
      assertSame(b1,robbie.getCarriedBox());
    }
     
    @Test
    public void putOn1(){
    Robot robbie= new Robot();
    Box b1= new Box(5);
    ConveyerBelt be = new ConveyerBelt(15);
    robbie.take(b1);
    assertTrue(robbie.carryingBox()&& be.accept(b1) && !be.isFull());
    robbie.putOn(be);
    assertFalse(robbie.carryingBox());
    }
    @Test
    public void putOn2(){
    Robot robbie= new Robot();
    ConveyerBelt be = new ConveyerBelt(15);
    Box b1= new Box(16);
    assertFalse(robbie.carryingBox());
    robbie.take(b1);
    robbie.putOn(be);
    assertSame(b1,robbie.getCarriedBox());
    }

    @Test
    public void putOn3(){
    Robot robbie= new Robot();
    ConveyerBelt be = new ConveyerBelt(15);
    Box b1= new Box(16);
    robbie.take(b1);
    robbie.putOn(be);
    assertFalse(robbie.carryingBox() && be.accept(b1));
    assertSame(b1,robbie.getCarriedBox());
    }

    @Test
    public void putOn4(){
    Robot robbie= new Robot();
    ConveyerBelt be = new ConveyerBelt(15);
    Box b1= new Box(16);
    robbie.take(b1);
    robbie.putOn(be);
    assertFalse(robbie.carryingBox() && be.isFull());
    assertSame(b1,robbie.getCarriedBox());
    }


    
    


    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}
