package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CarTest {

    private Vehicle c1;
    private Vehicle c2;

    private Vehicle c3;
    private Vehicle c4;

   /* méthode exécutée avant l'exécution de chacune des méthodes de test */
   @Before
   public void before() {
      // réinitialisation des attributs c1 et c2 pour chacun des tests
      this.c1 = new Car("brand1", "model1", 2015, 100.0f);
      this.c2 = new Car("brand2", "model2", 2000, 200.0f);

      this.c3 = new Car("brand1", "model1", 2015, 100.0f);
      this.c4 = new Car("brand1", "model1", 2015, 200.0f);
   }
   // Les autres methode ayant été tester dans VehicleTest, ici on a tester celle ajouté et modofier

   @Test 
	public void getAndSetNbpPassagerTest(){
        assertEquals(0,c1.getNbpPassager());
        c1.setNbpassager(6);
        assertEquals(6,c1.getNbpPassager());

      
        assertEquals(0,c2.getNbpPassager());
        c2.setNbpassager(4);
        assertEquals(4,c2.getNbpPassager());
    }

    @Test
    public void testEquals() {
       
       assertTrue(c1.equals(c3));
       assertFalse(c1.equals(c2));
       assertFalse(c1.equals(c4));
       assertFalse(c1.equals(new Object()));

       c1.setNbpassager(6);
       c2.setNbpassager(4);
       c3.setNbpassager(6);
       c4.setNbpassager(4);

       assertTrue(c1.equals(c3));
       assertFalse(c1.equals(c2));
       assertFalse(c1.equals(c4));
       assertFalse(c1.equals(new Object()));



    }


    // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.CarTest.class);
 }

    
}