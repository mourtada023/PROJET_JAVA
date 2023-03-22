package objet;

import cell.Cell;

public class  Joyaux extends Objet {



  public Joyaux(Cell c) {
     super(c);

  }

@Override
public void whatIAm() {
	System.out.println("un joyau\n");

}


}
