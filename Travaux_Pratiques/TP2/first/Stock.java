
/**
 * Write a description of class Stock here.
 *
 * @author Mamadou DIALLO
 * @version (a version number or a date)
 */
public class Stock
{
   
    private int quantity ;
    
    /**
     * Methode qui renvoi la valeur initiale de quantity
     * @param : (none)
     * @return : (int) un entier
    */
    public int getQuantity (){
        return this.quantity ;  
    }
    
    
    /**
     * Constructeur qui initialise la valeur de quantity a un entier donne
     * @return : (none)
    */
    public Stock () {
        this.quantity = 0 ;
    }
    
   
    /**
     * Methode add qui augmente de n la valeur de la quantite
     * @param n : (int) entier
     * @return : (none)
    */
    public void add (int n) {
        quantity = getQuantity() + n ;
    }
    
   
    /**
     * Mehode qui diminue la valeur de quantity
     * @param x : (int) un entier
     * @return : (int) renvoi un entier
    */
    public int remove (int x) {
        if (x >= getQuantity()){
            quantity = 0 ;
            return getQuantity() ;
        }
        else{
            quantity = getQuantity() - x ;
            return x ;
        }
    }
    
   
    /**
     * Methode toString qui renvoi un string 
     * @return : (string)
    */
    public String toSTring() {
       String chaine = "the stock's quantity is " + Integer.toString(getQuantity());
        return chaine;
    } 
    
   
    public void setQuantity(int n){
        this.quantity = n ;
    }
}
