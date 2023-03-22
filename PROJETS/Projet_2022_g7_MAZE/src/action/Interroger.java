package action;


import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cell.Cell;
import figure.Figure;
import figure.Hero;
import maze.Maze;


public class Interroger extends Action{

	
	public Interroger() {
		super();
	}
	

	public void interogateFigure(Hero h, Maze m, Cell objectif) {
		if (! h.getCell().getFigure().isEmpty()) {
		System.out.println("\n Veux tu interagir avec un personnage reponds par oui ou non");
		Scanner scanner = new Scanner(System.in);
    	String choix2 = scanner.nextLine();
    	try{
            switch(choix2){
                case "oui" :
                	Random random = new Random(); // le hero peut interroger une figure parmi celles qu'il y a sur sa cellule 
            		List<Figure> res = h.getCell().getFigure();
            		int index = random.nextInt(res.size());	
            		Figure f = h.getCell().getFigure().get(index);// il ne sait pas a qui il va avoir a faire
            		f.answer(m, h, objectif); // reponse de la figure interroger
            		h.getCell().getFigure().remove(f); // vous pouvez interroger une figure qu'une seule fois
                	break;
                case "non" :
                     if (!(h.getCell().getParchemin().isEmpty())) {
                    	 Ramasser r = new Ramasser();
                       	 r.PickParchemin(h, h.getCell().Parchemin());
                     }
                                  
                     if (!(h.getCell().getJoyau().isEmpty())) {
                    	 Ramasser r = new Ramasser();
                       	 r.PickJoyaux(h, h.getCell().Joyaux());
                     }
                	break;
            }
    	}
                	catch(NumberFormatException e){
                        System.out.println("Inserez oui ou non");
                    }
		
	}
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "J'ai interroger un personnage";
	}

}
