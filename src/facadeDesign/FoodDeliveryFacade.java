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
	
	public void createOrder() {
		// Get items in order and their price
		order.orderItems();
		double orderPrice = order.calculateOrderPrice();
		System.out.println("\nYou ordered:");
		order.displayOrder();
		System.out.println("The total price is: $" + orderPrice + "\n");
		
		// Process payment for order
		payment.acceptPaymentDetails(orderPrice);
		payment.processPayment();
	}
	
	public void trackOrder() {
		// Show Driver information
		System.out.println("Tracking Order...");
		System.out.println("\nDelivery Driver \'" + driver.getName() + "\' is " + Math.round(driver.getDistance()*100.0)/100.0 + " miles away with your order.");
		
		// Show Delivery time
		tracking.setEstimatedTime(driver.getDistance());
		System.out.println("Your order will arrive at " + tracking.getDeliveryTime().instant());
	}
	
	public void tipDriver() {
		
	}
	
	public void rateDriver() {
		
	}

}
