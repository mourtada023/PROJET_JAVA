package goosegame;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import goosegame.boards.*;
import goosegame.cells.*;

public class StartCellTest
{
   private StartCell cell1;
   private StartCell cell2;




   /* méthode exécutée avant l'exécution de chacune des méthodes de test */
   @Before
   public void before() {
      // réinitialisation de attribut game
      cell1 = new StartCell(0);
      cell2 = new StartCell(0);
   }

   @Test
   public void testMethods()
   {
      assertFalse(cell1.isBusy());
      assertFalse(cell2.isBusy());

      Player player1 = new Player("pikatchu");
      player1.setCell(cell1);
      Player player2 = new Player("salameche");
      player2.setCell(cell2);
      assertSame(0, player1.getCell().getIndex());
      assertSame(0, player2.getCell().getIndex());

   }


   // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(goosegame.StartCellTest.class);
   }

}
