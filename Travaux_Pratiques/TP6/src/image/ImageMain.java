package image;


import image.*;
import image.color.*;
import image.util.*;

public class ImageMain {
    private static final String LAMP_IMAGE = "/images/lamp.pgm";
    public static void main(String[] args) {
      if (args.length > 0 ){
        Image image1 = new Image(200,150);
        image1.fillRectangle(20,30,30,50, GrayColor.BLACK);
        image1.fillRectangle(50,100,40,40, new GrayColor(128));
        image1.fillRectangle(90,20,70,50, new GrayColor(200));
        String file = args[0];
        Image image2 = ImageLoader.loadPGM(file);
        Image image3 = image2.negative();
        Image image4 = image2.edgeExtraction(Integer.parseInt(args[1]));
        Image image5 = image2.decreaseNbGrayLevels(Integer.parseInt(args[2]));

        ImageDisplayer displayer = new ImageDisplayer();
        displayer.display(image1, "Rectangle", 100, 100);
        displayer.display(image2, "PGM", 450, 100);
        displayer.display(image3, "negative", 100, 450);
        displayer.display(image4, "edge:PGM", 450, 450);
        displayer.display(image5, "grays:PGM", 950, 350);

    }
  }
}
