
/**
 * An Hotel has a name and some rooms continuously numbered from 1
 *
 */
public class Hotel {

   private final String name;
   private final Status status;
   private Room[] rooms;

     /** build an Hotel with given name, status and number of rooms
    * @param name this hotel name
    * @param status this hotel status
    * @param numberOfRooms number of rooms of this hotel
    */
   public Hotel(String name, Status status, int numberOfRooms) {
     
      this.name = name;
      this.status = status;
      this.rooms= new Room[numberOfRooms];
      for (int i=0; i< numberOfRooms; i++){
         this.rooms[i]=new Room(i+1);

      }
   }

    /** return this hotel name
    * @return this hotel name
    */
   public String getName() {
      return this.name;
   }
   /** this hotel status
    * @return this hotel status
    */
   public Status getStatus() {
      return this.status;
   }

   /**  return the number of rooms for this hotel
    * @return the number of rooms for this hotel
    */
   public int numberOfRooms() { 
      return this.rooms.length;
   }
   
   /** provide the room corresponding to given number, first room has number 1, 
    * number must not be greater than <code>this.numberOfRooms()</code>
    * @param number number of the room, from 1 to this.numberOfRooms()
    * @return the room with given number
    */
   public Room getRoom(int number) {
         return this.rooms[number-1];
   }
 
   /** 
    * the method allows the rental of a room, and gives
    * the number of the room passed in parameter
    * @param number room number 
    * @return the number of the room passed as a parameter
    */
   public Room rentRoom(int number) {
       if (number > this.numberOfRooms() || number<=0 || this.rooms[number-1].isRent()){
          return null;
       }
       else {
          this.rooms[number-1].rent();
          return this.rooms[number-1];
       }
   }
   
   /** 
    * It returns nothing this method, it allows to return a rented room
    * @param number room number 
    */
   public void leaveRoom(int number) {
       this.rooms[number-1].free();
   }
   
   
   /** 
    * It allows to know the number of free rooms
    * She takes nothing as a parameter 
    * @return the free number of rooms
    */
   public int numberOfFreeRooms() {
       int res=0;
       for (int i=0; i<this.rooms.length;i++){
          if(!this.rooms[i].isRent()){
             res++;
          }
       }
   return res;
   }   
   
   /** 
    * It allows to know the number of the first free room
    *  It takes nothing in parameter
    * @return the number of the first free room
    */
   public int firstFreeNumber() {
       for (int i=0; i<this.rooms.length; i++){
          if(!this.rooms[i].isRent()){
             return i+1;
          }
       }
       return 0;
   }
   

   
}
