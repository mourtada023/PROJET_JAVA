import static org.junit.Assert.*;
import org.junit.*;
import image.Image;
import image.Pixel;
import image.UnknownPixelException;
import image.color.GrayColor;

public class ImageTest {
 

@Test
 public void testImage(){
     Image image = new Image(100,100);
     assertEquals(image.getWidth(),100);
     assertEquals(image.getHeight(),100);
}

@Test
public void testpixelwhenok(){
  Image im=new Image(100,100);
  Pixel p=im.getPixel(50,50);
  assertEquals(p,new Pixel(GrayColor.WHITE));
}

@Test(expected = UnknownPixelException.class)
public void testpixelwhenko(){
  Image im=new Image(100,10);
  Pixel p=im.getPixel(50,50);
}
@Test (expected = UnknownPixelException.class)
public void testChangeColorPixelThrowsExceptionWhenCoordOutOfImage() {
    Image image = new Image(10, 20);
    int x = image.getWidth() + 5;
    int y = image.getHeight() + 2;
    image.changeColorPixel(x, y, GrayColor.BLACK);
}

@Test
public void testChangeColorPixel() {
    Image image = new Image(20, 25);
    int x = 5;
    int y = 15;
    Pixel pixel = image.getPixel(x, y);
    assertEquals(GrayColor.WHITE, pixel.getColor()); // on vérifie que les pixels de l'image sont blanches à la création
    image.changeColorPixel(x, y, GrayColor.BLACK);
    assertEquals(GrayColor.BLACK, pixel.getColor());
}

@Test
public void testFillRectangle() {
    Image image = new Image(100, 100);
    int x = 5;
    int y = 10;
    int width = 35;
    int height = 45;
    image.fillRectangle(x, y, width, height, GrayColor.BLACK);
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            assertEquals(GrayColor.BLACK, image.getPixel(x+i, y+j).getColor());
        }
    }
}

   // ---Pour permettre l'exécution des test----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(ImageTest.class);
    }
}
