
/**
 * Classe constuisant une lampe
 *
 * @author : Mamadou DIALLO
 * @version : 20/09/2020
*/
public class Lightbulb
{
  /**
    /**
    * Question 4
    * 
    * Methode getPower() qui nous renvoi la valeur de power qui est la puissance de la lampe
    * Methode getColor() qui nous renvoi la couleur de la lampe
    * Methode isOn() qui nous permet de savoir si la lampe est allumé ou pas
    * Methode on() qui nous permet d'allumer la lampe
    * Methode off() qui nous permet d'éteindre la lampe
    * Methode toString() qui nous renvoi une phrase descriptive de la lampe
  */
    
  /**
    * Question 5
  */
  /**
    * Valeur correspondante à la puissance de la lampe
  */
  private int power ;
  /**
    * Valeur correspondante à la couleur de la lampe
  */
  private String color ; 
  /**
    * Element nous permettant de savoir si la lampe est allumé ou pas
  */ 
  private boolean on ;
    
  /**
   * Constructeur d'une instance de la classe Lightbulb
   * @param puissance : (int) la puissance de la lampe
   * @param couleur : (String) la couleur de la lampe
   */
  public Lightbulb (int puissance, String couleur) {
       this.on = false ;
       this.color = couleur ;
       this.power = puissance ;
  }
    
  /**
    * l'etat le plus pertinant est de représenter la lampe initialemen éteint
  */
   
  /**
   * Question 6
   * Methode qui vérifie si la lampe est allumé ou pas
   * @return : (boolean) true or false 
  */
  public boolean isOn () {  
      return this.on ;
  }
  
  /**
   * Methode qui nous donne la couleur de la lampe
   * @return : (String) la couleur
   */
  public String getColor () {
      return this.color ;
  }
  
  /**
   * Methode qui nous donne la puissance de la lampe
   * @return : (int) la puissance
   */
  public int getPower () {
      return this.power ;
  }
  
  /**
   * Methode qui nous permet d'allumer la lampe
   */
  public void on () {
      this.on = true ;
  }
  
  /**
   * Methode qui nous permet d'éteindre la lampe
   */
  public void off () {
      this.on = false ;
  }
  
  /**
   * Methode qui nous décrit la lampe
   */
  public String toString () {
      return "La lampe est " + color + " et de " + power + " watt";
  }
}
