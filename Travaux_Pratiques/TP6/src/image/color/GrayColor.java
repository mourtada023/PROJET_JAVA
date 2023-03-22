package image.color;
import image.*;

public class GrayColor{
  public static final  GrayColor WHITE=new GrayColor(255);
  public static final GrayColor BLACK=new GrayColor(0);
  private final int grayLevel;
  private double alpha;

  public GrayColor(int Level){
    this.alpha=1;
    this.grayLevel=Level;

  }

  public int getGrayLevel(){
    return this.grayLevel;
  }

  public double getalpha(){
    return this.alpha;
  }

  public double setalpha(double a){
    return this.alpha=a;
  }

  public boolean equals(Object o){
    if(o instanceof GrayColor){
      GrayColor other=(GrayColor) o;
      return (this.grayLevel==other.grayLevel)&&(this.alpha==other.alpha);
    }
    else
    return false;
  }
}
