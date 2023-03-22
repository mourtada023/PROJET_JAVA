package rental; 

/**
 * Motorbike
 */
public class Motorbike extends Vehicle{
    private int cylindree; 

    /**
     * build class 
     * @param cylindree the cylindree
     * @param brand the brand
     * @param model  the model 
     * @param productionYear the productionYear
     * @param dailyRentalPrice the dailyRentalPrice
     */
    public Motorbike ( int cylindree, String brand, String model, int productionYear, float dailyRentalPrice){
        super(brand, model, productionYear,dailyRentalPrice);
        this.cylindree = cylindree;
    }

    /**
     * set Nbpassager
     * @param newNb Nbpassager
     */
    @Override
    public void setNbpassager( int newNb) throws MaxPassengerReachedException{
        if(newNb > 2)
            throw new MaxPassengerReachedException("Une moto est de maximum 2 place");
        this.nbpPassager = newNb;
    }

    

    /**
     * display it
     */

    public String toString(){
        return super.toString() + " cylindree : " +this.cylindree+ " cm3" ;
    }
}