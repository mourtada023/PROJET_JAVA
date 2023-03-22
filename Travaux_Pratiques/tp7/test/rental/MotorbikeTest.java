package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MotorbikeTest {

    private Vehicle c1;
    private Vehicle c2;

    private Vehicle c3;
    private Vehicle c4;

   /* méthode exécutée avant l'exécution de chacune des méthodes de test */
   @Before
   public void before() {
      // réinitialisation des attributs c1 et c2 pour chacun des tests
      this.c1 = new Motorbike(150,"brand1", "model1", 2015, 100.0f);
      this.c2 = new Motorbike(150,"brand2", "model2", 2000, 200.0f);

      this.c3 = new Motorbike(150,"brand1", "model1", 2015, 100.0f);
      this.c4 = new Motorbike(150,"brand1", "model1", 2015, 200.0f);
   }
   // Les autres methode ayant été tester dans VehicleTest, ici on a tester celle ajouté et modofier

   @Test 
	public void getAndSetNbpPassagerGoodTest(){
        //assertEquals(0,c1.getNbpPassager());
        c1.setNbpassager(1);
        assertEquals(1,c1.getNbpPassager());
        //assertEquals(0,c2.getNbpPassager());
        c2.setNbpassager(2);
        assertEquals(2,c2.getNbpPassager());
    }


    @Test(expected=MaxPassengerReachedException.class)
    public void nbPassagerException() throws Exception{
        c1.setNbpassager(3);
    }

   


    @Test
    public void testEquals() {
       
       assertTrue(c1.equals(c3));
       assertFalse(c1.equals(c2));
       assertFalse(c1.equals(c4));
       assertFalse(c1.equals(new Object()));

       c1.setNbpassager(1);
       c2.setNbpassager(2);
       c3.setNbpassager(1);
       c4.setNbpassager(2);

       assertTrue(c1.equals(c3));
       assertFalse(c1.equals(c2));
       assertFalse(c1.equals(c4));
       assertFalse(c1.equals(new Object()));



    }















    // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.MotorbikeTest.class);
 }
    
}
