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
	
	//creates and displays order for user
	public void createOrder() 
	{
		order.orderItems();
		order.displayOrder();
		
	}
	//gets tracking information and displays it
	public void trackOrder() 
	{
		tracking.SetEstimatedTime(driver);
		tracking.trackerDisplay();
	}
	//tips and rates the driver
	public void customerFeedback() 
	{
		driver.tipDriver();
		driver.rateDriver();
	}
	
	

}
