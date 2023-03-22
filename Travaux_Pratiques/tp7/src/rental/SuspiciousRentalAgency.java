package rental;
/**
 * class which applies a 10% surcharge on
the rental price for customers under 25.
 */

public class SuspiciousRentalAgency extends RentalAgency {
    
    /**
     * 
     */
    public SuspiciousRentalAgency(){
        super ();    
    }

    
    // To manage the 10% increase for young people aged under 25%, we redefine the rentVehicle method and we complete it
    //with the corresponding lines of codes

    /**
     * overload
     */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        float res = super.rentVehicle(client, v) ;
        if(client.getAge()<25) {
           return  res+(res*10)/100 ;
        }
        return res ;
    }

}
