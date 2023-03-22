
/**
 * Write a description of class Goods here.
 *
 * @author Mamadou Diallo
 * @version (a version number or a date)
 */
public class Goods
{
    /**
     * Question 2
    */
    private String name ;
    private double value ;
    
    /**
     * Question 3
     * Le type de parametre est un string
     * 
     * constructeur d'instance Goods a un seul parametre
     * @param nom: (String) une chaine de caractere 
    */
    public Goods (String nom) {
        this.value = 0 ;
        this.name = nom ;
    }
    
    /**
     * constructeur d'instance Goods a un deux parametre
     * @param nom : (String) une chaine de caractere
     * @param valeur : (double) un nombre decimal
    */
    public Goods (String nom, double valeur){
        this.name = nom ;
        this.value = valeur ;
    }
    
    /**
     * Question 5
     * Methode getValue() sans param qui nous retourne la valeur de value
    */
    public double getValue () {
        return this.value ;
    }
    
    /**
     * Methode setValue qui permet de modifier la valeur de value
     * @param valeur : (double) un nombre decimal 
    */
    public void setValue (double valeur) {
        this.value = valeur ; 
    }
    
    /**
     * Question 6
     * Methode getName() sans param retourne la valeur de nom
     */
    public String getName () {
        return this.name ;
    }
    
    /**
     * Question 7
     * Methode toString sans param qui nous retourne une phrase descriptive
     * @return : (String) une chaine de caractere
    */
    public String toString (){
        return "the goods " + name + " costs " + String.valueOf(getValue());
    }
    
    /**
     * Question 8
     * Methode qui calcule le TTC d'une marchandise avec 20% de TVA
     * @return : (double) une valeur numerique
    */
    public double TTC () {
        return (this.value*1.2) ;
    }
}
