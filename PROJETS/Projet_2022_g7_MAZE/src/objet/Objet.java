package objet;

import cell.Cell;

public abstract class  Objet {

	protected Cell cell;



  public Objet(Cell c) {
	  this.cell = c ;

}


  public Cell getCell() {
    return this.cell;
  }



  public void setCell(Cell newCell) {
    this.cell = newCell;
  }

  public abstract void whatIAm();


}
