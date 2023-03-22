package rental;
/**
 * class UnknownVehicleException
 */

public class UnknownVehicleException extends RuntimeException {
  

	/**
	 * build exception
	 */
	public UnknownVehicleException() {}
	/**
	 * build exception
	 * @param msg msg
	 */
	public UnknownVehicleException(String msg) {
		super(msg);
	}
}

