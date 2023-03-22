import maze.*;
import objet.*;
import action.*;
import figure.*;
import cell.Cell;
import quete.Quete;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String algoVerifier = "";  
        Maze maze = null; 
        Scanner scanner = new Scanner(System.in);   
        while(algoVerifier.equals("")){
            System.out.println("Veuillez taper un numero associer a un algorithme pour la generation du labyrinthe de taille 10x10");
            System.out.println("Choix :    0 : \"Quitter\"");
            System.out.println("Choix :    1 :\"BinaryTree\"");
            System.out.println("Choix :    2 :\"Sidewinder\"");
            String choix = scanner.nextLine();
            try{
                switch(Integer.parseInt(choix)){
                    case 0 :
                        System.out.println("Quitter");
                        System.exit(-1);
                    case 1 :
                        maze = new BinaryTreeMaze(10,10);
                        Hero h = new Hero(maze.getCell(0, 0), 0);
                        Deplacer p = new Deplacer();
                        Quete q = new Quete();
                        maze.initMaze();
                        //25 personnages
                        for(int i=0; i<=8;i++) {
                        	Random random = new Random();
                        	int x = random.nextInt(10);
                        	int y = random.nextInt(10);
                        	Marchand pp = new Marchand(maze.getCell(x, y));
                        	maze.getCell(x, y).addFigure(pp);
                        	int f = random.nextInt(10);
                        	int g = random.nextInt(10);
                        	Sphynx ppp = new Sphynx(maze.getCell(f, g));
                        	maze.getCell(f, g).addFigure(ppp);
                        	int z = random.nextInt(10);
                        	int e = random.nextInt(10);
                        	Fou pppp = new Fou(maze.getCell(e, e));
                        	maze.getCell(z, e).addFigure(pppp);
                        }
                        //25 objets
                        for(int i=0; i<=12;i++) {
                        	Random random = new Random();
                        	int x = random.nextInt(10);
                        	int y = random.nextInt(10);
                        	Parchemin pp = new Parchemin(maze.getCell(x, y));
                        	maze.getCell(x, y).addParchemin(pp);
                        	int a = random.nextInt(10);
                        	int b = random.nextInt(10);
                        	Joyaux ppp = new Joyaux(maze.getCell(a, b));
                        	maze.getCell(a, b).addJoyau(ppp);;
                        }
                         //Cellule objectif
                        Cell objectif = maze.getCell(8,3);
                        Interroger i = new Interroger();
                        Ramasser r = new Ramasser();
                        System.out.println("\n Que la partie commence Bonne chance \n");
                        System.out.print((maze.strDynamique(h)));  
                        System.out.print('\n');
                        while(!q.EndOfTheGame(h, maze, objectif)){
                        	System.out.println("\nVeuillez taper un numero associer a une action pour se deplacer dans le labyrinthe");
                            System.out.println("Choix :    N :\"aller au Nord\"");
                            System.out.println("Choix :    S :\"aller vers le sud\"");
                            System.out.println("Choix :    E :\"aller vers l'est\"");
                            System.out.println("Choix :    O :\"aller vers l'ouest\"");
                            System.out.println("Choix :    A :\"Observer\"");
                            System.out.println("Choix :    P :\"Ouvrir un parchemin\"");
                            System.out.println("Choix :    C :\"Convertir un joyau en or\"");
                            System.out.println("sinon \"q\" pour quitter le jeu ");
                            String choix1 = scanner.nextLine();
                            try{
                                switch(choix1){
                                    case "N" :
                                        System.out.println("go to the top");
                                        p.goToTheTop(h , maze);
                                        System.out.print((maze.strDynamique(h)));	
                                        i.interogateFigure(h, maze, objectif);
                                     	r.PickParchemin(h, h.getCell().Parchemin());
                                     	r.PickJoyaux(h, h.getCell().Joyaux());
                                        break;
                                    case "S" :
                                        System.out.println("go to the bottom");
                                        p.goToTheBottom(h , maze);
                                        System.out.print((maze.strDynamique(h)));
                                        i.interogateFigure(h, maze, objectif);
                                     	r.PickParchemin(h, h.getCell().Parchemin());
                                     	r.PickJoyaux(h, h.getCell().Joyaux());
                                        break;
                                    case "E" :
                                        System.out.println("go to the right");
                                        p.goToTheRight(h , maze);
                                        System.out.print((maze.strDynamique(h)));	
                                        i.interogateFigure(h, maze, objectif);
                                     	r.PickParchemin(h, h.getCell().Parchemin());
                                     	r.PickJoyaux(h, h.getCell().Joyaux());
                                        break;
                                    case "O" :
                                        System.out.println("go to the left");
                                        p.goToTheLeft(h , maze);
                                        System.out.print((maze.strDynamique(h)));
                                        i.interogateFigure(h, maze, objectif);
                                     	r.PickParchemin(h, h.getCell().Parchemin());
                                     	r.PickJoyaux(h, h.getCell().Joyaux());
                                        break;
                                    case "A" :
                                        System.out.println("observer");
                                        Observer p3 = new Observer();
                                        p3.voir(h , maze);
                                        System.out.print((maze.strDynamique(h)));
                                        break; 
                                    case "P" :
                                    	System.out.println("Utiliser un parchemin");
                                        Utiliser p4 = new Utiliser();
                                        p4.OpenParchemin(h.Parchemin(), h, maze, objectif);
                                        System.out.print((maze.strDynamique(h)));
                                    break;
                                    case "C" :
                                    	System.out.println("convertir un joyau en or");
                                        Utiliser p41 = new Utiliser();
                                        p41.UseJoyaux(h.Joyau(), h);
                                        System.out.print((maze.strDynamique(h)));
                                    break;
                                    case "q" :
                                	   System.out.println("\nTu pars :( ! ce fut quand meme un plaisir de t'avoir parmis nous ");
                                	   System.exit(-1);       
                        }
                            }
                        catch(NumberFormatException e){
                            System.out.println("Veuillez recommencer en entrant un choix valide !");
                        }
                }
                        algoVerifier= choix;
                        break; 
                    case 2 :
                        maze = new SidewinderMaze(10,10);
                        Hero h1 = new Hero(maze.getCell(0, 0), 0);
                        Deplacer p1 = new Deplacer();
                        Quete q1 = new Quete();
                        maze.initMaze();
                        System.out.print((maze.strDynamique(h1)));  
                        System.out.print('\n');
                        //25 personnages
                        for(int i1=0; i1<=8;i1++) {
                        	Random random = new Random();
                        	int x = random.nextInt(10);
                        	int y = random.nextInt(10);
                        	Marchand pp = new Marchand(maze.getCell(x, y));
                        	maze.getCell(x, y).addFigure(pp);
                        	int f = random.nextInt(10);
                        	int g = random.nextInt(10);
                        	Sphynx ppp = new Sphynx(maze.getCell(f, g));
                        	maze.getCell(f, g).addFigure(ppp);
                        	int z = random.nextInt(10);
                        	int e = random.nextInt(10);
                        	Fou pppp = new Fou(maze.getCell(e, e));
                        	maze.getCell(z, e).addFigure(pppp);;
                        }
                        //25 objets
                        for(int i1=0; i1<=12;i1++) {
                        	Random random = new Random();
                        	int x = random.nextInt(10);
                        	int y = random.nextInt(10);
                        	Parchemin pp = new Parchemin(maze.getCell(x, y));
                        	maze.getCell(x, y).addParchemin(pp);
                        	int a = random.nextInt(10);
                        	int b = random.nextInt(10);
                        	Joyaux ppp = new Joyaux(maze.getCell(a, b));
                        	maze.getCell(a, b).addJoyau(ppp);
                        }
                        //Cellule objectif
                        Cell objectif1 = maze.getCell(8,3);
                        Interroger a = new Interroger();
                        Ramasser b = new Ramasser();
                        while(!q1.EndOfTheGame(h1, maze, objectif1)){            	
                        	System.out.println("\nVeuillez taper un numero associer a un algorithme pour se deplacer dans le labyrinthe");
                        	System.out.println("Choix :    N :\"aller au Nord\"");
                            System.out.println("Choix :    s :\"aller vers le sud\"");
                            System.out.println("Choix :    E :\"aller vers l'est\"");
                            System.out.println("Choix :    O :\"aller vers l'ouest\"");
                            System.out.println("Choix :    A :\"Observer\"");
                            System.out.println("Choix :    P :\"Ouvrir un parchemin\"");
                            System.out.println("Choix :    C :\"Convertir un joyau en or\"");
                            System.out.println("sinon \"q\" pour quitter le jeu ");
                            String choix1 = scanner.nextLine();
                            try{
                                switch(choix1){
                                    case "N" :
                                        System.out.println("go to the top");
                                        p1.goToTheTop(h1 , maze);
                                        System.out.print((maze.strDynamique(h1)));
                                        a.interogateFigure(h1, maze, objectif1);
                                        b.PickParchemin(h1, h1.getCell().Parchemin());
                                        b.PickJoyaux(h1, h1.getCell().Joyaux());
                                        break;
                                    case "S" :
                                        System.out.println("go to the bottom");
                                        p1.goToTheBottom(h1 , maze);
                                        System.out.print((maze.strDynamique(h1)));
                                        a.interogateFigure(h1, maze, objectif1);
                                        b.PickParchemin(h1, h1.getCell().Parchemin());
                                        b.PickJoyaux(h1, h1.getCell().Joyaux());
                                        break; 
                                    case "E" :
                                        System.out.println("go to the right");
                                        p1.goToTheRight(h1 , maze);
                                        System.out.print((maze.strDynamique(h1)));
                                        a.interogateFigure(h1, maze, objectif1);
                                        b.PickParchemin(h1, h1.getCell().Parchemin());
                                        b.PickJoyaux(h1, h1.getCell().Joyaux());
                                        break;
                                    case "O" :
                                        System.out.println("go to the left");
                                        p1.goToTheLeft(h1 , maze);
                                        System.out.print((maze.strDynamique(h1)));
                                        a.interogateFigure(h1, maze, objectif1);
                                        b.PickParchemin(h1, h1.getCell().Parchemin());
                                        b.PickJoyaux(h1, h1.getCell().Joyaux());
                                        break;
                                    case "A" :
                                        System.out.println("observer");
                                        Observer p3 = new Observer();
                                        p3.voir(h1 , maze);
                                        System.out.print((maze.strDynamique(h1)));
                                        break;
                                    case "P" :
                                    	System.out.println("Ouvrir un parchemin");
                                        Utiliser p4 = new Utiliser();
                                        p4.OpenParchemin(h1.Parchemin(), h1, maze, objectif1);
                                        System.out.print((maze.strDynamique(h1)));
                                    break;
                                    case "C" :
                                    	System.out.println("convertir un joyau en or");
                                        Utiliser p5 = new Utiliser();
                                        p5.UseJoyaux(h1.Joyau(), h1);
                                        System.out.print((maze.strDynamique(h1)));
                                    break;
                                    case "q" :
                                        System.out.println("\nTu pars :( ! ce fut quand meme un plaisir de t'avoir parmis nous ");
                                        System.exit(-1);
                        }
                            }
                        catch(NumberFormatException e){
                            System.out.println("Veuillez recommencer en entrant un choix valide !");
                        }
                }     
                        algoVerifier= choix;
                        break;   
                }
            }
            catch(NumberFormatException e){
                System.out.println("Veuillez recommencer en entrant un choix valide !");
        }
	}
        scanner.close();
	}	
}
