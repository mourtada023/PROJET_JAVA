package rental;
/**
 * class for vehicle
 */

public class Vehicle {

	/** */
	protected int nbpPassager;
	/** */
	protected String brand;
	/** */
	protected String model;
	/** */
	protected int productionYear;
	/** */
	protected float dailyRentalPrice;

	/**
	 * creates a vehivle with given informations
	 * 
	 * @param brand
	 *            the vehicle's brand
	 * @param model
	 *            the vehicle's model
	 * @param productionYear
	 *            the vehicle's production year
	 * @param dailyRentalPrice
	 *            the daily rental price
	 */
	public Vehicle(String brand, String model, int productionYear, float dailyRentalPrice) {
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.dailyRentalPrice = dailyRentalPrice;
		this.nbpPassager =0;
	}

	/**
	 * Return the number og the passager
	 * @return (int) the number passeger
	 */

	public int getNbpPassager(){
		return this.nbpPassager;
	}
	/**
	 * 
	 * @param newNb the new nb passager
	 */

	public void setNbpassager( int newNb){
		this.nbpPassager = newNb;
	}

	/**
	 * @return the brand for this vehicle
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * @return the modelfor this vehicle
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * @return the production year for this vehicle
	 */
	public int getProductionYear() {
		return this.productionYear;
	}

	/**
	 * @return this vehicle daily price
	 */
	public float getDailyPrice() {
		return this.dailyRentalPrice;
	}

	/**
	 * this vehicle is equals to another if they have same brand, model,
	 * production year and daily rental price
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof Vehicle) {
			Vehicle theOther = ((Vehicle) o);
			return this.brand.equals(theOther.brand) 
					&& this.model.equals(theOther.model)
					&& this.productionYear == theOther.productionYear
					&& this.dailyRentalPrice == theOther.dailyRentalPrice
					&& this.nbpPassager == theOther.nbpPassager;
		} else {
			return false;
		}
	}

	public String toString() {
		return "Year :" + this.productionYear + "  brand :" + this.brand + " price : " + this.dailyRentalPrice + " " ;
	}

	
}
