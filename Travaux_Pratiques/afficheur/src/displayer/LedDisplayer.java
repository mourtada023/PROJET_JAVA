package displayer;

/**
 * 
 */

public class LedDisplayer {

   /**
     the attributes
   */
  protected String Onscreen;
  protected String Message;
  protected int CurrentIndex;
  protected int Width;
  protected int ScrenWidth;


/**
     the constructor
   */
   public LedDisplayer(int width) {
      this.Width= Width;
        
   }
   
   /** get the (full) message of this displayer
    * @return the (full) message of this displayer
    */
   public String getMessage() {
    return this.Message; 
  }

/**
 * set the message
 * @param message
 */
   
   public void setMessage(String message) {      
    this.Message=Message;
    this.CurrentIndex=-1;
    StringBuffer sb = new StringBuffer();
    for (int i=0; i<this.Width; i++){
      sb.append("");
    }
    this.Onscreen = sb.toString();
   }

   /**
    * get the screen width
    * @return
    */
   public int getScreenWidth() {
      return this.ScrenWidth;
   }

   /**  shift message by one character  */
   public void shift() {
       System.out.println(CurrentIndex= (this.CurrentIndex)%this.Message.length());
       this.Onscreen= this.Onscreen.substring(1, 5) + this.Message.charAt(this.CurrentIndex);
   }

   /**
     TODO
   */
   public String textOnScreen() {
      return this.Onscreen;
   }

}
