package maze;
import cell.Cell;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SidewinderMaze extends Maze{
  
    public SidewinderMaze(int nx, int ny){
        super(nx,ny);
    }




    public void initMaze(){
        for (int y = 0; y < this.getny(); y++) {
            if (this.getRight(this.getCell(this.getnx()-1, y)) instanceof Cell) {
             removeWall(this.getCell(this.getnx()-1, y),this.getRight(this.getCell(this.getnx()-1, y)));}}
        // Scan grid row by row
        for (int x = 0; x < this.getnx()-1; x++) {
          // Initialize an empty list to keep track of the current run path
          List<Cell> l = new ArrayList<>();
          Random random = new Random();
          for (int y = 0; y < this.getny(); y++) {
            // Add current cell to the path
            l.add(this.getCell(x,y));
            int wall = random.nextInt(2);
            // Randomly carve to east (if possible) or not
            if (getRight(this.getCell(x,y)) instanceof Cell && wall == 1 ) {
              removeWall(this.getCell(x,y), getRight(this.getCell(x,y)));
            }
            // Otherwise carve to the South from a random cell of the run set
            else {
              Cell cell = l.get(random.nextInt(l.size()));
              if (getBottom(cell) instanceof Cell) {
                removeWall(cell, getBottom(cell));
              }
              // Empty the lest and continue row scan
              l.clear();
            }
          }
        }


      }

}
