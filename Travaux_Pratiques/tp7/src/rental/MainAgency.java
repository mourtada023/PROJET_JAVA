package rental;
import  java.io.PrintStream;
import java.util.Iterator;
/**
 * Class main
 */

public class MainAgency {
    /**
     * the main
     * @param args args
     */
     public static void main(String[] args) {

         
         //Creation of the cars 
         Vehicle v1 = new Vehicle("Timo","Leon",1920,200);
         Vehicle v2 = new Vehicle("Audi","A1",2018,500);
         Vehicle v3 = new Vehicle("Renault","clio",2001,100);
         
         Car car = new Car("Audi", "Manual", 2014, 40) ;
         Motorbike motorbike = new Motorbike(150,"Toyota", "Manual", 2013, 100) ;

         
         //Creation of customers
         Client c1 = new Client("Tarik",22);
         Client c2 = new Client("Ibrahima",21);

         //Creation of agencies
         RentalAgency agency = new RentalAgency();
         SuspiciousRentalAgency suspiciousRentalAgency = new SuspiciousRentalAgency() ;
        
         
         //Creation of filters
         AndFilter andFilter= new AndFilter();
         MaxPriceFilter maxPriceFilter = new MaxPriceFilter(300);
         BrandFilter brandFilter = new BrandFilter("Timo");
         
         //Adding filters
         andFilter.addFilter(maxPriceFilter);
         andFilter.addFilter(brandFilter);

         //Addition of vahicles in the agency
         suspiciousRentalAgency.addVehicle(motorbike);
         suspiciousRentalAgency.addVehicle(v3);
         suspiciousRentalAgency.addVehicle(car);
         agency.addVehicle(v1);
         agency.addVehicle(v2);
         agency.addVehicle(v3);
         agency.displaySelection(andFilter);

         //Affichage de la liste des voitures
         System.out.println("Les voitures ajouter a la liste AGENCY sont  : " +"\n" + agency.getAllVehicles() + "\n");
         System.out.println("Les voitures ajouter a la liste suspiciousRentalAgency sont  : " +"\n" + suspiciousRentalAgency.getAllVehicles()+ "\n");


        // rent car, vehicle to clients at two agencies
        float l1 = agency.rentVehicle(c1, v1) ;
        float l2 = agency.rentVehicle(c2, v2) ;

        float l3 = suspiciousRentalAgency.rentVehicle(c2, motorbike) ;

        // Affichage des vehicule loué :
        System.out.println("\nLes vehicules loues dans AGENCY sont : ");
        agency.displaySelection(andFilter);

        Iterator<Vehicle> it = agency.allRentedVehicles().iterator();
        while(it.hasNext()) {
            Vehicle ref = it.next(); 
            System.out.println(ref);
        }

        System.out.println("\nLes vehicules loues dans suspiciousRentalAgency sont : ");
        suspiciousRentalAgency.displaySelection(andFilter);

        Iterator<Vehicle> su = suspiciousRentalAgency.allRentedVehicles().iterator();
        while(su.hasNext()) {
            Vehicle ref = su.next(); 
            System.out.println(ref);
        }


        

        // Affichages des vehicule acceptant  les filtres
        System.out.print("\nDisplay of vehicle filters for agency \n");
        agency.displaySelection(andFilter);

        System.out.println("\n"+"Display of vehicle filters for suspiciousRentalAgency ");
        suspiciousRentalAgency.displaySelection(andFilter);

        System.out.println("\n" + c1.getName()+" rented the brand's car  "+v1.getBrand()+" model "+v1.getModel()+" at "+l1+" euros in the agency ") ;
        System.out.println(c2.getName()+" rented the brand's car "+v2.getBrand()+" model "+v2.getModel()+" at "+l2+" euros in the agency \n") ;

        System.out.println(c1.getName()+" Did he rent a car in one of the agencies ? : "+agency.hasRentedAVehicle(c1));
        System.out.println(c2.getName()+" Did he rent a car in one of the agencies ? : "+agency.hasRentedAVehicle(c2));


        agency.returnVehicle(c1) ;
        System.out.println("\n"+"the vehicle of brand "+v3.getBrand()+" is it rented : "+agency.isRented(v3));
        System.out.print("\n After application of the method returnVehicle which allows customer 1 to return the vehicle\n");
        System.out.println("Here is the list of cars rented in the agency  : "+agency.allRentedVehicles()+"\n");




        
    }
}
