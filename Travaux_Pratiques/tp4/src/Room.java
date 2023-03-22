
/** a class to model Room in an hotel, Room has a unique number and can be rent or not */
public class Room {

   private static final String LABEL = "Room ";
   
   private final int number;
   private boolean rent;
   
   /** create a room with given number, initially a room is not rent
    * @param number number of this room
    */
   public Room(int number) {
      this.number = number;
      this.rent = false;
   }

   /** return this room number
    * @return this room number
    */
   public int getNumber() {
      return this.number;
   }

   /** <code>true</code> iff this room is rent 
    * @return <code>true</code> iff this room is rent
    */
   public boolean isRent() {
      return this.rent;
   }
   /**
    * rent this room
    */
   public void rent() {
      this.rent = true;
   }
   
   /**
    * free this room
    */
   public void free() {
      this.rent = false;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   public String toString() {
      return Room.LABEL + this.number;
   }
   
   /** two rooms are equals if they have same number
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object o) {
      if (! (o instanceof Room))
         return false;
      // else o refers an instance of Room
      Room other = (Room) o;
      return other.number == this.number;
   }
}
