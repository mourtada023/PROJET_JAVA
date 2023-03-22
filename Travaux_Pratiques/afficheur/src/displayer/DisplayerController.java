
package displayer;

public class DisplayerController {

   private LedDisplayer displayer;

   public DisplayerController(LedDisplayer displayer) {
      this.displayer = displayer;
   }

   public void changeDisplayer(LedDisplayer displayer) {
      this.displayer = displayer;
   }

   public void tryIt(String message, int nbSeconds) {
      this.displayer.setMessage(message);
      for (int i = 0; i < nbSeconds; i++) {
         this.displayer.shift();
	 try {
	     Thread.sleep(500);
	 } catch(Exception e) {}
         System.out.println("|" + displayer.textOnScreen() + "|");
      }
   }

}
