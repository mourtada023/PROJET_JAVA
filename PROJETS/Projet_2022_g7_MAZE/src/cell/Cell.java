package cell;



import java.util.*;


import figure.Figure;
import objet.*;

public class Cell {

// x=line, y=column
  private int x, y ;

  //the order of walls : N, S, E, O.
  //true when there is a wall, false sinon
  private boolean[] walls = {true, true, true, true};

  private List<Figure> figure;
  private List<Parchemin> p;
  private List<Joyaux> j;



   public Cell( int x, int y) {
 		this.x = x;
 		this.y = y;
		this.figure = new ArrayList<Figure>();
		this.p= new ArrayList<Parchemin>();
		this.j=new ArrayList<Joyaux>();
 	}




	public List<Figure> getFigure() {
		return this.figure;
	}


	public void addFigure(Figure f) {
		 this.figure.add(f);
	}


	public void addParchemin(Parchemin p) {
		 this.p.add(p);
	}


	public void addJoyau(Joyaux j) {
		 this.j.add(j);
	}



	public List<Parchemin> getParchemin() {
		return this.p;
	}

	public List<Joyaux> getJoyau() {
		return this.j;
	}


	public boolean[] getWalls() {
		return walls;
	}



	public void setWalls(boolean[] walls) {
		this.walls = walls;
	}



	public int getX() {
		return this.x;
	}



	public int getY() {
		return this.y;
	}

	 public Joyaux Joyaux() {
		 //on selectionne un joyau parmi ceux presents sur cette cellule  aleatoirement i
		   if(!(this.getJoyau().isEmpty())) {
			    Random random = new Random();
			    int i = random.nextInt(this.getJoyau().size());
				return this.getJoyau().get(i);
				}
		   return null;
	   	}

	 public Parchemin Parchemin() {
		 //on selectionne un parchemin  aleatoirement i parmi ceux presents sur cette cellule
		   if(!(this.getParchemin().isEmpty())) {
			    Random random = new Random();
			    int i = random.nextInt(this.getParchemin().size());
				return this.getParchemin().get(i);
				}
		   return null;
	   	}


}
