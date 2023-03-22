package figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cell.Cell;
import objet.Joyaux;
import objet.Parchemin;


public class  Hero  {

   protected Cell cell;
   protected int or ;
   protected List<Parchemin> ParcheminPickedUp;
   protected List<Joyaux> JoyauxPickedUp;



  public Hero(Cell c, int or) {
     this.or = or;
     this.cell = c;
     this.ParcheminPickedUp = new ArrayList<Parchemin>();
     this.JoyauxPickedUp = new ArrayList<Joyaux>();

  }


  public void addParchemin(Parchemin newParchemin) {
     this.ParcheminPickedUp.add(newParchemin);
  }



  public void addJoyaux(Joyaux newJoyaux) {
     this.JoyauxPickedUp.add(newJoyaux);
  }



  public List<Parchemin> getParcheminPickedUp() {
    return this.ParcheminPickedUp;
  }


  public List<Joyaux> getJoyauxPickedUp() {
    return this.JoyauxPickedUp;
  }


  public int getOr() {
    return this.or;
  }


  public void setOr(int or) {
    this.or = or;
  }



  public Cell getCell() {
    return this.cell;
  }


  public void setCell(Cell c) {
    this.cell = c;
  }

  public Parchemin Parchemin() {
	   if(!(this.getParcheminPickedUp().isEmpty())) {
		    Random random = new Random();
		    int i = random.nextInt(this.getParcheminPickedUp().size());
			return this.getParcheminPickedUp().get(i);
			}
	   return null;
  	}


  public Joyaux Joyau() {
	   if(!(this.getJoyauxPickedUp().isEmpty())) {
		    Random random = new Random();
		    int i = random.nextInt(this.getJoyauxPickedUp().size());
			return this.getJoyauxPickedUp().get(i);
			}
	   return null;
 	}


}
