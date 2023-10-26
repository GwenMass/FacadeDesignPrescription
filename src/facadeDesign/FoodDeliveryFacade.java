package facadeDesign;
import java.util.Scanner;
/* 	FoodDeliveryFacade.java
 * 	is the Facade Class that wraps around the collection of other classes 
 *  that each implement some functionality related to food delivery.
 */

public class FoodDeliveryFacade {
	
	private Order order;
	private Payment payment;
	private Driver driver;
	private Tracking tracking;
	Scanner in = new Scanner(System.in);
	
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
		System.out.println("\nTracking Order...");
		System.out.println("Delivery Driver \'" + driver.getName() + "\' is " + Math.round(driver.getDistance()*100.0)/100.0 + " miles away with your order.");
		
		// Show Delivery time
		tracking.setEstimatedTime(driver.getDistance());
		System.out.println("Your order will arrive at " + tracking.getDeliveryTime().instant());
	}
	
	public void tipDriver() {
		System.out.println("\nWould you like to tip " + driver.getName() + "?");
		System.out.println("Enter the amount you would like to tip, or 0 for no tip:");
		System.out.println("15%\t18%\t20%");
		System.out.println(
			    String.format("$%.2f\t$%.2f\t$%.2f",
			        0.15 * order.calculateOrderPrice(),
			        0.18 * order.calculateOrderPrice(),
			        0.20 * order.calculateOrderPrice()
			    )
			);
		double tip = in.nextDouble();
		driver.tipDriver(tip);
		
	}
	
	public void rateDriver() {
		int rating = 0;
		System.out.println("\nHow would you rate your experience with " + driver.getName() + "?");
		do {
			System.out.println("Please give a rating of 1-5 based on your experience.");
			rating = in.nextInt();
			if (rating < 1 || rating > 5)
				System.out.println("Invalid entry! Try again.");
		}while (rating < 1 || rating > 5);
		driver.rateDriver(rating);
	}

}
