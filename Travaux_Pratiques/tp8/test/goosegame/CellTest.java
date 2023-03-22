package goosegame;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import goosegame.boards.*;
import goosegame.cells.*;

public class CellTest
{
   private Cell cell1;
   private Cell cell2;
   private Player player1;
   private Player player2;



   /* méthode exécutée avant l'exécution de chacune des méthodes de test */
   @Before
   public void before() {
      // réinitialisation de attribut game
      cell1 = new Cell(0);
      cell2 = new Cell(0);
   }

   @Test
   public void testMovePlayer()
   {
      assertFalse(cell1.isBusy());
      assertFalse(cell2.isBusy());

      player1 = new Player("pikatchu");
      player1.setCell(cell1);
      player2 = new Player("salameche");
      player2.setCell(cell2);
      assertSame(0, player1.getCell().getIndex());
      assertSame(0, player2.getCell().getIndex());

      Cell nextCell1 = new Cell(5, player1);
      Cell nextCell2 = new Cell(3, player2);
      player1.setCell(nextCell1);
      player2.setCell(nextCell2);
      assertSame(5, player1.getCell().getIndex());
      assertSame(3, player2.getCell().getIndex());

      nextCell1.movePlayer(player1);
      nextCell2.movePlayer(player2);

      assertEquals("pikatchu", nextCell1.getPlayer().getName());
      assertEquals("salameche", nextCell2.getPlayer().getName());


   }


   // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(goosegame.CellTest.class);
   }

}
