
/**
 * Classe construisant l'interrupteur d'une lampe
 *
 * @author : Mamadou Diallo
 * @version : 25/09/2020
 */
public class Switch
{
 private Lightbulb bulb ;

  // le constructeur des instances
  
 /**
  * Constructeur de l'interrupteur qui contrôle la lampe
  * @param bulb : (classe) une classe correspondant à une lampe
 */
 public Switch (Lightbulb bulb) {
       this.bulb = bulb  ;
 }
    
   
 /**
   * Methode qui permet d'allumer et d'éteindre la lampe controlé
 */
 public void interrupteur () {
     if (bulb.isOn()){
          bulb.off() ;
     }
     else {
          bulb.on() ;
     }
 }
}
