package goosegame.boards;
import goosegame.cells.*;

public abstract class Board{
  //attributs
  protected final int NB_OF_CELLS ;
  protected Cell[] theCells;

  /**
   * Constructor of this class that initialized the cells and the board
   * @param nbOfCells
   */
  public Board( int nbOfCells )
  {
      this.NB_OF_CELLS = nbOfCells;
      this.theCells = new Cell[this.NB_OF_CELLS];
      this.initBoard();
  }

  /**
   * returns the cell indexed by the value given in the parameter
   * @param index
   * @return the cell corresponding the index given in the parameter
   */
  public Cell getIndexedCell( int index )
  {
      if(index>=0 && index<this.getNbOfCells())
          return this.theCells[index];
      else
          return null;
  }

  /**
   * set the cells of the board
 * @param cells are the cells we want to set
 */
public void setCells(Cell[] cells) {
  this.theCells = cells;
}


  /**
   * Get the cells of the board
   * @return returns the cells of the board
   */
public Cell[] getCell() {
  return this.theCells;
}


  /**
   * Returns the number of cells
   * @return the number of cells
   */
  public int getNbOfCells()
  {
      if(this.theCells == null)
          return 0;
      return this.theCells.length;
  }

  /**
   * Method abstract that initialized the board and will be implemented by every class that extends this
   */
  public abstract void initBoard();
}
