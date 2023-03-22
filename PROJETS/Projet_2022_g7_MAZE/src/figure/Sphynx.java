package figure;



import java.util.*;
import cell.Cell;
import maze.Maze;


public class  Sphynx extends Figure {

	private static Random rand = new Random();
	private Map<String, String> enigme ;



  public Sphynx(Cell c) {
     super(c);
     this.enigme = new HashMap<String, String>();
     this.enigme.put("1+1 = ?", "deux");
     this.enigme.put("Je ne peux pas marcher, j'ai pourtant un dos et quatre pieds. Qui suis-je ?", "une chaise");
     this.enigme.put(" Trois poissons sont dans un seau, l'un d'entre eux meurt, combien en reste t-il?", "trois");
     this.enigme.put("Un fermier a 17 vaches ; elles meurent toutes sauf 9. Combien en reste-t-il ?", "neuf");
     this.enigme.put("Tu participes a une course cycliste. A un moment donne, tu doubles le deuxieme. Tu deviens...", "deuxieme");
     this.enigme.put("Il y a huit bancs en bois dans un parc. Trois bancs ont ete peints. Combien de bancs y a-t-il maintenant dans le parc ?", "huit");
     this.enigme.put("Je parle toutes les langues et j'ai tout le temps la tete a l'envers. Qui suis-je ? ", "un stylo");
     this.enigme.put("je suis noir, je deviens rouge, et je finis blanc...", "le charbon");
     this.enigme.put("La souris mange le fromage, le chat mange la souris. Qui reste-t-il ?", "le chat");
     this.enigme.put("Plus j'ai de gardiens moins je suis garde.Moins j'ai de gardiens plus je suis garde Qui suis-je ?", "un secret");
     this.enigme.put("Quel mot devient drole apres qu'on lui ajoute une lettre ?", "role");

  }





  @Override
   public void answer (Maze m, Hero h, Cell objectif) {
	Scanner scanner = new Scanner(System.in); //le sphynx pose une enigme au hero et si sa reponse est bonne il lui donne un indice
	int index = rand.nextInt(this.enigme.size());
	setNbTurns();

	Collection<String> answers = this.enigme.values();
	List<String> listanswers= new ArrayList<String>(answers);

	Set<String> keySet = this.enigme.keySet();
    List<String> listKeys= new ArrayList<String>(keySet);
	String enigme = listKeys.get(index);
	System.out.println(enigme);
	String answer = scanner.nextLine();
	if(answer.equals(listanswers.get(index))) {
	System.out.println("Bonne reponse voici ta recompense");
	this.enigme.remove(enigme);//une fois une enigme posee et que le reponse du hero est bonne elle est supprimee
	indice(m,h,objectif);
	}else {
		System.out.println("mauvaise reponse");
	}

 }


   public void whoIAm() {
		  System.out.println("un sphynx\n");
	  }









}
