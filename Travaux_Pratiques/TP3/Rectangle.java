public class Rectangle {
    /** 
    *the attributes for the rectangle class
    *Length and width  
    */
    private double longueur;
    private double largeur;


     /** 
        *The constructor  
        *@param longueur: (double) longueur
        *@param largeur: (double) largeur
        *@param return : qui retourne un rectangle
    */
    public Rectangle (double longueur, double largeur){
      
        this.longueur=longueur;
        
        this.largeur=largeur;
    }

     /** 
    * It returns the length
    * @return (double)
    */

    public double getLenght(){
       

        return this.longueur;
    }

     /** 
        *It returns the width
        *@return (double)
     */

    public double getWidht(){
       
        return this.largeur;
    }

    /** 
        *It returns the area of ​​the rectangle
        *@return (double)
     */

    public double aire(){
        

        return (this.longueur*this.largeur);
    }

    /** 
        *It returns the perimeter of the rectangle
        *@return (double)
     */

    public double perimetre(){

        
        return 2*(this.longueur+this.largeur);
    }

     /** 
        *It checks if the rectangle is a square
        *@return (boolean)
    */
    public boolean IsSquare(){
       
        return this.longueur==this.largeur;
    }

    /** 
        * It allows to check if two rectangle are equal
        *@param (Object)
        *@return boolean
        */
    public boolean equals(Object o){
        

        if(o instanceof Rectangle){
            Rectangle other = (Rectangle) o ;
            return (this.longueur== other.longueur)&& (this.largeur==(other.largeur));
        }
        else
            return false;
  
    }

    /** 
     * Method which returns us a descriptive sentence of the rectangle
     *@return  (String) 
    */
    public String toString(){

       return "On a un rectangle de " + this.longueur + " cm de longueur et de " + this.largeur + " cm de largeur dont l''aire et le périmètre valent respectivement " 
       + aire() +" cm² et " + perimetre() + " cm" ;
        
    }
    /** 
        *It allows us messages to display
        */
    public static void main (String[] args) {
        

        Rectangle rectangle1 = new Rectangle(10, 5);
        Rectangle rectangle2 = new Rectangle(7, 7);

        double aire1 = rectangle1.aire() ;
        double aire2 = rectangle2.aire() ;
        
        double perim1 = rectangle1.perimetre();
        double perim2 = rectangle2.perimetre() ;

        boolean est_carre = rectangle1.IsSquare() ;
        boolean est_carre1 = rectangle2.IsSquare() ;

        boolean est_vrai = rectangle1.equals(rectangle2) ;

        System.out.println(
            "L'aire du 1er rectangle est de "+ aire1 +" cm²"+"\n"+
            "L'aire du 2eme rectangle est de "+ aire2 +" cm²"+"\n"+
            "Les périmètres des deux rectangles sont respectivement "+ perim1 +" cm"+" et "+ perim2 +" cm"+"\n"+
            "Le 1er rectangle et le 2ème sont-ils des carrés ? "+est_carre+ " et "+est_carre1+"\n"+
            "Les deux rectangles sont-ils égaux : "+ est_vrai);
    }

}