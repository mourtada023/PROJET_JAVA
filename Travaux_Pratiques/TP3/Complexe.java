/**
 * This Class Handle the complex number
 * @author Mamadou Diallo 
 * 
 */
import java.lang.Math;
public class Complexe{

    private double real;
    private double imaginary;

     /**
     * This Class handles complex numbres 
     * @param real The real number
     * @param imaginary The imaginary Number
     */
     public Complexe( double real , double imaginary){
         this.real = real;
         this.imaginary = imaginary;
     }

     
     /**
      * This class calculates the moduls of the complex number
      * @return The module of this class
      */
    public double module(){
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2) );
    }

    /**
     * This class returns the conjugate of the complex number
     * @return The conjugate of the complex
     */
    public Complexe conjugate(){
        return new Complexe(this.real, -this.imaginary);
    }

    /**
     * Add to complex
     * 
     */
    public Complexe add( Complexe c){
        return new Complexe( this.real + c.real, this.imaginary + c.imaginary);
    }

    /**
     * This class returns the multiplivation of the complex number
     * @return The Multiplication between two complex
     */
    public Complexe mult( Complexe c){
        return new Complexe((this.real*c.real - this.imaginary*c.imaginary),(this.real*c.imaginary + this.imaginary*c.real));
    }

    /**
     * Checks if a complex is real
     * @return true if he is real false or not 
     */
    public boolean isReal(){
        return this.imaginary==0;
    }

    /**
     * Get the real part of the complex
     * @return The real part
     */
    public double realPart(){
        return this.real;
    }


    /**
     * Get the imaginary part
     * @return The imaginary part
     */
    public double imaginaryPart(){
        return this.imaginary;
    }

    /**
     * Test if two complex are same
     */
    public boolean equals(Object o){
        if(o instanceof Complexe){
            Complexe other = (Complexe)o;
            return ( this.real == other.real && this.imaginary == other.imaginary);
        }
        else {
            return false;
        }
    }

    /**
     * Get a message
     * 
     */
    public String toString(){
        return "The Complexe is" + this.real + "i" + this.imaginary;
    }
    public static void main (String[] args){
           Complexe complex_un = new Complexe (5,7);
           Complexe complex_deux= new Complexe(2,-4);

           Complexe somme1= complex_un.add(complex_deux);


           Complexe produit1= complex_un.mult(complex_deux);

           double module1 = complex_un.module();
           double module2= complex_deux.module();

           boolean real1 = complex_un.isReal();
           boolean real2 = complex_deux.isReal();

           Complexe conjugue1 = complex_un.conjugate();
           Complexe conjugue2 = complex_deux.conjugate();

           boolean vrai = complex_un.equals(complex_deux);

        System.out.println(

             "complexe_un = " + complex_un.toString() + "\n"+
            "complexe_un = " + complex_deux.toString() + "\n"+
            "La partie réel du nombre complexe 1 est " + complex_un.realPart() + " et sa partie imaginaire "+ complex_un.imaginaryPart() + "\n"+
            "La partie réel du nombre complexe 2 est " + complex_deux.realPart() + " et sa partie imaginaire "+ complex_deux.imaginaryPart() + "\n"+
            "Le nombre complexe 1 a pour conjugué " + conjugue1 + " et pour module " + module1 + "\n"+
            "Le nombre complexe 2 a pour conjugué " + conjugue2 + " et pour module " + module2 + "\n"+
            "Le nombre complexe 1 est-il un réel : " + real1 + "\n"+
            "Le nombre complexe 2 est-il un réel : " + real2 + "\n"+
            "La somme des deux nombres complexes est de : " + somme1 + "\n"+
            "Le produit des deux nombres complexes est de : " + produit1 +"\n"+
            "Les deux complexes sont-ils égaux : "+ vrai 
        ) ; 
    }




}
