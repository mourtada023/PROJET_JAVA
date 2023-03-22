import static org.junit.Assert.*;

import org.junit.Test;


public class HotelTest {

   @Test
   public void roomsAreCreatedAtCreation() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      assertNotNull(hotel.getRoom(1));
      assertEquals(1, hotel.getRoom(1).getNumber());
      assertNotNull(hotel.getRoom(12));
      assertEquals(12, hotel.getRoom(12).getNumber());
   }
   
   @Test
   public void numberOfRoomsIsCorrectAtCreation() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      assertEquals(12, hotel.numberOfRooms());
   }  

   @Test
   public void rentRoomIsPossibleWhenRoomIsFree() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      Room room2 = hotel.getRoom(2);
      assertFalse(room2.isRent());
      Room resultRoom = hotel.rentRoom(2);
      assertSame(room2, resultRoom);
      assertTrue(room2.isRent());
   }

   @Test
   public void rentRoomReturnNullWhenRoomIsNotFree() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      Room room2 = hotel.getRoom(2);
      hotel.rentRoom(2);
      assertTrue(room2.isRent());
      // try to rent same room a second time
      Room resultRoom = hotel.rentRoom(2);
      assertNull(resultRoom);      
   }
   
   @Test   
   public void rentRoomReturnNullWhenNumberIsNotValid() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      // number is too great
      Room toogreatRoom = hotel.rentRoom(hotel.numberOfFreeRooms() + 10);
      assertNull(toogreatRoom);
      // number is negative or zero
      Room zeroRoom = hotel.rentRoom(0);
      assertNull(zeroRoom);
      Room negativeRoom = hotel.rentRoom(-1000);
      assertNull(negativeRoom);
   }
   
   @Test
   public void roomIsFreeAfterLeave() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      Room resultRoom = hotel.rentRoom(4);
      assertTrue(resultRoom.isRent());
      hotel.leaveRoom(4);
      assertFalse(resultRoom.isRent());
   }
   
   @Test 
   public void numberOfFreeRoomsTest() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      assertEquals(12, hotel.numberOfFreeRooms());
      hotel.rentRoom(2);
      hotel.rentRoom(5);
      assertEquals(10, hotel.numberOfFreeRooms());
      hotel.leaveRoom(2);
      assertEquals(11, hotel.numberOfFreeRooms());
   }
   
   @Test
   public void firstFreeNumberTestWhenHotelNotFull() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 12);
      assertEquals(1, hotel.firstFreeNumber());
      hotel.rentRoom(1);
      hotel.rentRoom(2);
      assertEquals(3, hotel.firstFreeNumber());
   }
   @Test
   public void freeNumberReturnsZeroWhenHotelFull() {
      Hotel hotel = new Hotel("hotel", Status.COSY, 2);
      hotel.rentRoom(1);
      hotel.rentRoom(2);
      assertEquals(0, hotel.firstFreeNumber());
   }
   
   
   
   // ---Pour permettre l'exécution des test----------------------
   public static junit.framework.Test suite() {
       return new junit.framework.JUnit4TestAdapter(HotelTest.class);
   }

}
