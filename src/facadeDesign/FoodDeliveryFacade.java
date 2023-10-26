package facadeDesign;

/* 	FoodDeliveryFacade.java
 * 	is the Facade Class that wraps around the collection of other classes 
 *  that each implement some functionality related to food delivery.
 */

public class FoodDeliveryFacade {
	
	private Order order;
	private Payment payment;
	private Driver driver;
	private Tracking tracking;
	
	public FoodDeliveryFacade() {
		order = new Order();
		payment = new Payment();
		driver = new Driver();
		tracking = new Tracking();
	}
	
	private void createOrder() {
		
	}
	
	private void trackOrder() {
		
	}
	
	private void tipDriver() {
		
	}
	
	private void rateDriver() {
		
	}

}
