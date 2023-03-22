package maze;

import cell.Cell;


import java.util.ArrayList;
import java.util.List;

import figure.Hero;

public abstract class Maze {

/** nx=number of lines, ny=number of columns */
   protected int nx, ny ;

   protected Cell[][] maze;



   public Maze(int nx, int ny) {
 		this.nx = nx;
 		this.ny = ny;
        this.maze = new Cell[nx][ny];
        for (int i = 0; i < nx ;i++){
        	for (int j = 0; j < ny; j++){
        		this.maze[i][j] = new Cell(i, j);

 			}
 		}
	}

	public abstract void initMaze();

    // retourne une chaine representant le labyrinthe et le x represente la position du hero

	public String strDynamique(Hero h) {
		List<String> laby_lignes = new ArrayList<>();
		List<String> laby_l = new ArrayList<>();
		String str1 = "+---";
		String str2 = "|";
		String str4 = "    ";
		String str5 = "---+";
		String str6 = "   +";
		String repeated = str1.repeat(this.ny);
		laby_lignes.add(repeated + "+");
		for (int x = 0 ; x < this.nx; x++) {
			if (x == 0) {
				laby_l.add(str2);
			}
			else {
				laby_l.add('\n' + str2 );
			}

			for (int y = 0 ; y < this.ny; y++) {
				if (x== h.getCell().getX() && y== h.getCell().getY()) {
						laby_l.add(" x");
					}
				if (this.maze[x][y].getWalls()[2]) {
					if (x== h.getCell().getX() && y== h.getCell().getY()) {
						laby_l.add(" |");
					}
					else {
						laby_l.add("   |");
					}
				}
				else {
					if (x== h.getCell().getX() && y== h.getCell().getY()) {
						laby_l.add("  ");
					}
					else {
					laby_l.add(str4);
					}
				}

			}

			laby_lignes.add(String.join("", laby_l));
			laby_l.clear();
			laby_l.add("+");
			for (int y = 0 ; y < this.ny; y++) {
				if (this.maze[x][y].getWalls()[1]) {
					laby_l.add(str5);
				}
				else {
					laby_l.add(str6);
				 }
			}
		}
	   laby_lignes.add(String.join("", laby_l));
	   return String.join("\n" , laby_lignes);

	}




   public int getnx() {
		return this.nx;
	}



   public int getny() {
		return this.ny;
	}


   public Cell getTop(Cell cell) {
		if (cell.getX() == 0) {
			return null;
		}
		else {
			return this.maze[cell.getX()-1][cell.getY()];
	    }
	}


   public Cell getRight(Cell cell) {
		if (cell.getY() == ny-1) {
			return null;
		}
		else{
			return this.maze[cell.getX()] [cell.getY()+1];
		}
		}


   public Cell getBottom(Cell cell)  {
		if (cell.getX() == nx-1) {
			return null;
		}
		else {
			return this.maze[cell.getX()+1] [cell.getY()];
		}
			}


   public Cell getLeft(Cell cell) {
	   if (cell.getY() == 0) {
			return null;
	   }
	   else{
		   return this.maze[cell.getX()][cell.getY()-1];
	   }
		}



   public Cell getCell(int x, int y) {
    		return this.maze[x][y] ;

}



   public int getTotalNumberOfCells(){
      return this.nx * this.ny;
 }


   public void removeWall (Cell cell, Cell next) {
    	if (cell.getX() == 0 || next.getX() == 0){
    		cell.getWalls()[0] = true; /**les murs exterieurs de la grille ne seront jamais detruits*/
   }

    	if (cell.getY() == 0 || next.getY() == 0){
    		cell.getWalls()[3] = true; /**les murs exterieurs de la grille ne seront jamais detruits*/
   }

    	if (cell.getX() == getnx()-1 || next.getX() == getnx()-1){
    		cell.getWalls()[1] = true;  /**les murs exterieurs de la grille ne seront jamais detruits*/
   }

    	if (cell.getY() == getny()-1 || next.getY() == getny()-1){
    		cell.getWalls()[2] = true;  /**les murs exterieurs de la grille ne seront jamais detruits*/

   }

    	if (getTop(cell) == next){
    		cell.getWalls()[0] = false; /**on detruit le mur Nord */
    		next.getWalls()[1] = false; /** on detruit aussi le mur Sud de la cellule voisine*/
    }

    	if (getRight(cell) == next){
    		cell.getWalls()[2] = false;  /**on detruit le mur Est */
    		next.getWalls()[3] = false; /** on detruit aussi le mur Ouest de la cellule voisine*/
	    }

    	if (getBottom(cell) == next){
    		cell.getWalls()[1] = false; /**on deruit le mur Sud */
    		next.getWalls()[0] = false; /** on detruit aussi le mur Nord de la cellule voisine*/
    }

    	if (getLeft(cell) == next){
    		cell.getWalls()[3] = false; /**on detruit le mur Ouest */
    		next.getWalls()[2] = false; /** on detruit aussi le mur Est de la cellule voisine*/
	    }

}



   public List<Cell> adjoiningCells (Cell cell) {

    	List<Cell> result = new ArrayList<>();

    	if (cell.getWalls()[0] == false && getTop(cell) != null) {
		   result.add(getTop(cell));
	 }

    	if (cell.getWalls()[1] == false && getBottom(cell)  != null) {
    	   result.add(getBottom(cell));
	 }

    	if (cell.getWalls()[2] == false && getRight(cell)  != null) {
    	   result.add(getRight(cell));
	 }

    	if (cell.getWalls()[3] == false && getLeft(cell)  != null) {
    	   result.add(getLeft(cell));
	 }

    	return result;
 }




   public List<Cell> neighborsOfACell(Cell cell)  {
    	List<Cell> result = new ArrayList<>();
    	if ( getTop(cell)  != null ) {
    		result.add(getTop(cell));
    	}
    	if ( getBottom(cell)  != null ) {
    		result.add(getBottom(cell));
        }
    	if ( getRight(cell)  != null) {
    		result.add(getRight(cell));
    	}
    	if ( getLeft(cell)  != null ) {
    		result.add(getLeft(cell));
    	}
    	return result ;
    }






    public int distance(Cell c1, Cell c2) {
       List<Cell> res = new ArrayList<>();
       List<Cell> seen = new ArrayList<>();
       res.add(c1);
       while (!seen.contains(c2)) {
       for(int n=0; n < adjoiningCells(res.get(0)).size() ; n++) {
          	Cell c = adjoiningCells(res.get(0)).get(n);
          	if( !seen.contains(c)){
          		res.add(c);

          	}
          }
            if (!seen.contains(res.get(0))){
              seen.add(res.get(0));
              }
            res.remove(0);
       }

        return seen.size()/2 ;

     }






}
