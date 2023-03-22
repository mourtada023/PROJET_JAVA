
/**
 * Une classe permettant de manipuler les intervalles
 *
 * @author : Mamadou DIALLO
 * @version : 26/09/2020
 */
public class Interval
{
    // attribut correspondant à la borne inférieure de l'interval
    private int left ;
    
    // attribut correpondant à la borne supérieure de l'interval
    private int right ;
    
    /**
     * Le constructeur des instances de la classe d'Interval
     * @param left : (int) la borne supérieure
     * @param right : (int) la borne supérieure
    */
    public Interval (int left , int right) {
        this.left = left ;
        this.right = right ;
    }
    
    /** 
     * Methode qui permet de connaître la borne inférieure de l'intervalle
     * @return : (int) la borne inférieure
     */
    public int getLeft () {
        return this.left ;
    }
    
    /** 
     * Methode qui permet de connaître la borne supérieure de l'intervalle
     * @return : (int) la borne supérieure
     */
    public int getRight () {
        return this.right ;
    }
    
    /**
     * Methode permettant de verifier si l'intervalle est vide ou pas
     * @return : (boolean) true or false 
     */
    public boolean estVide () {
        return this.left > this.right ;
    }
    
    /**
     * Methode permettant de verifier si une valeur appartient à l'intervalle
     * @return : (boolean) true or false
    */
    public boolean appartient (int nombre) {
        return (this.left < nombre) && (this.right >nombre) ;
    }
    
    /**
     * Methode qui nous donne la taille d'un intervalle
     * @return : (int) un entier
     */ 
    public int taille () {
        if (this.estVide()){
            return 0 ;
        }
        return right-left+1 ;
    }
    
    /**
     *  Methode qui nous permet de faire l'intersection entre deux intervalles
     *  @param un_interval : (Interval) un intervalle
     *  @return : (Interval) un intervalle
     */
    public Interval intersection (Interval un_interval) {
      return new Interval (Math.max(this.left,un_interval.left), Math.min(this.right,un_interval.right)) ;
    }
    
    /**
     * Methode permettant de savoir si deux intervalles sont disjoints
     * @param un_interval : (Interval) un interval
     * @return : (noolean) true or false
     */
    public boolean est_disjoints (Interval un_interval) {
        return ((this.intersection(un_interval)).estVide()) ;
    }
    
    /**
     * Methode nous permettant de prolonger un intervalle d'une certaine valeur
     * @param v : (int) un entier
     * @return : (Interval) un interval
    */ 
    public Interval prolonge (int v) {
        if (this.estVide()){
            return new Interval (this.left , this.right) ;
        }
        return new Interval (this.left , this.right + v) ;
    }
    
    /**
     *  Methode nous permettant de faire l'union de deux intervalles
     *  @param un_interval : (Interval) un interval
     *  @return : (Interval)
     */
    public Interval union (Interval un_interval) {
        if (this.estVide()){
            return un_interval ;
        }
        else if (un_interval.estVide()){
            return this ;
        }
        else if (this.estVide() && un_interval.estVide()){
            return this ;
        }
        else {
            return new Interval (Math.min(this.left,un_interval.left),Math.max(this.right,un_interval.right)) ;
        }
    }
    
    /**
     * Methode nous permettant de savoir si deux intervalles sont égaux ou pas
     * @param un_interval : (Interval) un intervalle
     * @return : (boolean) true or false
     */ 
    public boolean equals(Interval un_interval){
        if (this.estVide()){
            return un_interval.estVide() ;
        }
        else if (un_interval.estVide()){
            return this.estVide() ;
        }
        else {
            return (this.left==un_interval.left) && (this.right==un_interval.right) ;
        }
    }
    
    /**
     * Methode permettant de representer un intervalle
     * @return : (String) un string
     */ 
    public String affiche () {
        return "[" + String.valueOf(this.left) + "," + String.valueOf(this.right) + "]" ;
    }
}
    
    
