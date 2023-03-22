package action;

import figure.Hero;
import objet.Joyaux;
import objet.Parchemin;
import java.util.Scanner;

public class Ramasser extends Action{
	
	 public Ramasser() {
			super();
			 }
	
	   public void PickParchemin(Hero h, Parchemin p) {
		   //Le hero peut ramasser un parchemin si ce dernier se trouve sur la meme cellule que lui 
		   if (!(h.getCell().getParchemin().isEmpty()) && !h.getParcheminPickedUp().contains(p) && h.getCell().equals(p.getCell())) {
			   System.out.println("\n Il y a un parchemin sur cette cellule veux tu le ramasser?");
             	System.out.println("Choix :    oui :\"ramasser le parchemin\"");
             	System.out.println("Choix :    non     :\"ne pas ramasser le parchemin\"");
             	Scanner scanner = new Scanner(System.in); 
            	String choix3 = scanner.nextLine();
              	try{
                      switch(choix3){
                          case "oui" :
                        	  h.addParchemin(p);
                		      h.getCell().getParchemin().remove(p);//on supprime le parchemin ramasser de la cellule vu qu'il a ete ramasser
                		      setNbTurns();
                          	
                          	break;
                          case "non" :
                           	break;
                      }
              	}
                          	catch(NumberFormatException e){
                                  System.out.println("Inserez oui ou non");
                              }
                      }
		      
		   }
	   
	   
	
	   
	   public void PickJoyaux(Hero h, Joyaux j) {
		   if (!(h.getCell().getJoyau().isEmpty()) && !h.getJoyauxPickedUp().contains(j) && h.getCell().equals(j.getCell())){
			   System.out.println("\n Il y a un Joyau sur cette cellule veux tu le ramasser?");
             	System.out.println("Choix :    oui :\"ramasser le joyau\"");
             	System.out.println("Choix :    non     :\"ne pas ramasser le joyau\"");
             	Scanner scanner = new Scanner(System.in); 
             	String choix3 = scanner.nextLine();
             	try{
                     switch(choix3){
                         case "oui" :
                        	 h.addJoyaux(j);
           			      	 h.getCell().getJoyau().remove(j); //on supprime le bijou ramasser de la cellule vu qu'il a ete ramasser
           			      	 setNbTurns();
                         	break;
                         case "non" :
                          	break;
                     }
             	}
                         	catch(NumberFormatException e){
                                 System.out.println("Inserez oui ou non");
                             }
		   }
			   
	   	}
	   
	 
	   
	  
		public String toString(){
			return "Youpppi on a ramasse un objet ";
		}

		

}
