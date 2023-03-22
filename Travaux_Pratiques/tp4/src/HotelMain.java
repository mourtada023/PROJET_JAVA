public class HotelMain{
    /**
    * Method allowing us to do a test of the HotelMain class 
     */
    public static void main (String[] args){
        //Creating the hotel whose name's "california" and the number's 100 rooms

        Hotel hotel1= new Hotel("california", Status.PREMIUM,100);

       if (args.length>0){
            System.out.println("Le nombre de chambre : " + hotel1.numberOfRooms());
            System.out.println("La chambre dont le numéro a été passé en argument  :" + hotel1.rentRoom(Integer.parseInt(args[0])));
            System.out.println("Affiche la chambre à louer : " + hotel1.getRoom(Integer.parseInt(args[0])));
            System.out.println("Afficher le nombre de chambre libre dans l'hotel :" + hotel1.numberOfFreeRooms());
            hotel1.leaveRoom(Integer.parseInt(args[0]));
            System.out.println("Afficher à nouveau le nombre de chambre libre dans l'hotel :" + hotel1.numberOfFreeRooms());

       }
       else{
           System.out.println("Rentrer un nombre de chambre ");
       }


    }
}
