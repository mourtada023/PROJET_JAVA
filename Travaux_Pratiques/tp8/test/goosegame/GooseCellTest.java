package goosegame;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import goosegame.boards.*;
import goosegame.cells.*;

public class GooseCellTest
{
   private Cell cell1;



   /* méthode exécutée avant l'exécution de chacune des méthodes de test */
   @Before
   public void before() {
      // réinitialisation de attribut game
      cell1 = new GooseCell(0);

   }

   @Test
   public void testBounceMethod()
   {
      assertFalse(cell1.isBusy());

      Player player1 = new Player("pikatchu");
      player1.setCell(cell1);
      assertSame(0, player1.getCell().getIndex());

      Cell nextCell1 = new GooseCell(cell1.getIndex()+9, player1);
      nextCell1.bounce(9);
      assertSame(18, nextCell1.bounce(9));

   }


   // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(goosegame.GooseCellTest.class);
   }

}
