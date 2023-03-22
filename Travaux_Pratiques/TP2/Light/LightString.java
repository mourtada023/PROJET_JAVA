
/**
 * Classe permettant de contrôler une guirlandes.
 * @author : Mamadou DIALLO
 * @version : 226/09/2020
 */
public class LightString
{
    // Nombre maximum de lampes dans la guirlande
    private static final int NB_LAMPES_MAX = 20 ;
    
    // la liste des lampes crées
    private Lightbulb[] theBulbs ;
    
    // attribut correspondant au nombre de lampes
    private int nbLampes ;
    
    /**
     * Initiallisation de la guirlande avec 5 lampes à l'intérieur
    */
    public LightString (int nbLampes) {
        this.theBulbs = new Lightbulb[NB_LAMPES_MAX] ;
        this.nbLampes = nbLampes ;
        for (int i=0 ; i<nbLampes; i++){
            theBulbs[i] = new Lightbulb(1,"white");
            theBulbs[i].off() ;
        }
        
    }
    
    /**
     * Methode nous permettant de connaitre le nombre de lampes dans la guirlande
     * @return : (int) un entier
    */
    public int getNbLampes () {
        return this.nbLampes ;
    }
    
    /**
     * Methode permettant d'ajouter d'autres lampes à la guirlande
    */
    public void addTheBulb (Lightbulb bulb) {
        if (this.nbLampes < NB_LAMPES_MAX) {
            this.theBulbs[this.nbLampes] = bulb ;
            this.nbLampes = this.nbLampes + 1 ;
        }
    }
    
    /**
     * Methode permettant d'éteindre les lampes de la guirlandes
    */
    public void off () {
        for (int i=0; i<nbLampes; i++) {
            if (theBulbs[i].isOn()){
                theBulbs[i].off() ;
            }
        }
    }
    
    /**
     * Methode permettant d'éteindre les lampes de la guirlandes
    */
    public void on () {
        for (int i=0; i<nbLampes; i++) {
            theBulbs[i].on() ;
            }
    }
    
    /** replace the n-th lightbulb of the light string by the given lightbulb.
    * Nothing happens if i is not a valid index.
    * @param i the number of the lightbulb to be changed (first has number 1)
    * @param theBulb the new lightbulb
    */
    public void changeLightbulb(int i, Lightbulb theBulb) {
        theBulbs[i] = theBulb ;
    }
    
    // Methode nous permettant de connaître la puissance totale consommée par les lampes de la guirlandes
    
    /**
     * Methode qui nous renvoi la puissance totale de la guirlande
     * @return : (int) un entier
     */
    public int getConsumedPower () {
        int somme = 0 ;
        for (int i = 0; i<nbLampes; i++) {
            if (theBulbs[i].isOn()){
                somme += theBulbs[i].getPower() ;
            }
        }
        return somme ;
    }   
}

