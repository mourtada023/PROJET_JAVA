package image;
import image.color.GrayColor;
import image.*;

public class Image implements ImageInterface{
  private int Height;
  private int Width;
  private Pixel pixels[][];

  public Image(int w,int h){
    this.Height=h;
    this.Width=w;
    this.pixels=new Pixel[this.Width][this.Height];
    for (int i=0;i<this.Width;i++){
      for (int j=0;j<this.Height;j++){
      this.pixels[i][j]=new Pixel(GrayColor.WHITE);
    }
  }
}
  /** returns width of the image
	 * @return width of the image
	 */
	public int getWidth(){
    return this.Width;
  }

	/** returns height of the image
	 * @return height of the image
	 */
	public int getHeight(){
    return this.Height;
  }

	/** get the pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
	 * @param x the horizontal coordinate
	 * @param y the vertical coordinate
	 * @return pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
	 * @exception UnknownPixelException if coord (x,y) is not valid for this image
	 */
   public Pixel getPixel(int x, int y) throws UnknownPixelException{
   if (x <= this.getWidth() && y <= this.getHeight()) {
     return this.pixels[x][y];
   }
   else {
     throw new UnknownPixelException("Coordonées non trouvées");
   }
 }

 public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException {
   if (x <= this.getWidth() && y <= this.getHeight()) {
       Pixel p = this.getPixel(x,y);
       p.setColor(color);
   }
   else {
     throw new UnknownPixelException("Coordonnées non trouvées");
   }
}

public void fillRectangle(int x, int y, int width, int height, GrayColor color ){
for (int i = x; i < x+width; i++){
  for(int j = y; j < y + height; j++){
    this.changeColorPixel(i,j,color);

  }
}
}
public Image negative() {
  Image res = new Image(this.Width, this.Height);
  for(int i = 0 ; i<this.Width; i++) {
    for(int j = 0 ; j<this.Height; j++) {
      Pixel p = this.getPixel(i, j);
      GrayColor c1 = p.getColor();
      GrayColor c2 = new GrayColor(255 - c1.getGrayLevel());
      res.changeColorPixel(i, j, c2);
    }
  }
  return res;
}

 public Image edgeExtraction(int threshold){
     Image image = new Image(this.Width,this.Height);
     for (int i = 0; i < this.Width-1; i++) {
        for (int j = 1; j < this.Height; j++) {
            if ((this.pixels[i][j]).colorLevelDifference(this.pixels[i][j-1])
                > threshold || (this.pixels[i][j]).colorLevelDifference(this.pixels[i+1][j] )
                > threshold){
                    image.changeColorPixel(i,j,GrayColor.BLACK);
             }
         }
     }
     return image ;
 }

 public Image decreaseNbGrayLevels(int nbGrayLevels) {

  Image im =new Image(this.Width, this.Height);
  int t = 256/nbGrayLevels ;
  for (int i = 0; i < im.Width;  i++){
      for (int j = 0; j < im.Height; j++){
          int l = this.getPixel(i, j).getColor().getGrayLevel() ;
          int k = l/t ;
          im.changeColorPixel(i, j , new GrayColor(k*t));
         }
     }
     return im ;
 }
 }
