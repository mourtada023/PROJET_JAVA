package rental;
/**
 * class MaxPassengerReachedException
 */

public class MaxPassengerReachedException extends RuntimeException {

	/**
	 * 
	 */
	public MaxPassengerReachedException() {}

	/**
	 * 
	 * @param msg msg
	 */
	public MaxPassengerReachedException(String msg) {
		super(msg);
	}
}
