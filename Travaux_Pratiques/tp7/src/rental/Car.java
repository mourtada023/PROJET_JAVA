package rental ; 

/**
 * Class Car
 */

public class Car extends Vehicle{
    /**
     * build a car
     * @param brand brand of car
     * @param model model of car
     * @param productionYear productionYear of car
     * @param dailyRentalPrice dailyRentalPrice of car
     */
    

    public Car (String brand, String model, int productionYear, float dailyRentalPrice){
        super(brand, model, productionYear, dailyRentalPrice);
    }


    /**
     * dilplay
     */
    public String toString() {
		return super.toString() ;
	}
    
}