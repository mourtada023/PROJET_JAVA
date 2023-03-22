package maze;
import cell.Cell;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BinaryTreeMaze extends Maze{

    public BinaryTreeMaze(int nx, int ny){
        super(nx,ny);
    }
//construire le labyrinthe parfait grace a l'algorithme de l'arbre binaire
    public void initMaze() {
        List<Cell> l = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < this.getnx() ; i++) { //on part d'une grille ou tous les murs existent
           for (int j = 0; j < this.getny() ;j++) {// on parcourt une a une toutes les cellules de la grille (en commencant en haut a gauche, c'est a dire en (0,0))
             if (getBottom(this.getCell(i,j)) != null) {//pour chaque cellule ainsi parcourue, on detruit aleatoirement soit le mur Sud soit le mur Est
                     l.add(getBottom(this.getCell(i, j)));
                 }
             if (getRight(this.getCell(i,j)) != null) {
                     l.add(getRight(this.getCell(i,j)));
                 }
             if (! l.isEmpty()) {
                     int index = random.nextInt(l.size());
                     removeWall(this.getCell(i,j), l.get(index));
                     l.clear();
                }

             }
        }
    }
}
