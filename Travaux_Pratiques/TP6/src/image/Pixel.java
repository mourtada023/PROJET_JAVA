package image;
import image.color.GrayColor;
import image.*;


 public class Pixel{
   private GrayColor color;

   public Pixel(GrayColor color){
     this.color=color;

   }

   public GrayColor getColor(){
     return this.color;
   }

   public GrayColor setColor(GrayColor b){
      return this.color=b;
   }

   public int colorLevelDifference(Pixel o){
     return Math.abs(this.color.getGrayLevel() - o.getColor().getGrayLevel());
   }

   public boolean equals(Object o){
     if(o instanceof Pixel){
       Pixel other=(Pixel) o;
       return (this.color==other.color);
     }
     else
     return false;
   }
 }
