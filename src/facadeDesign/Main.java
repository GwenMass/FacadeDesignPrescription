package facadeDesign;

/* 	Main.java
* 	is the client that uses the Facade Class
*/

public class Main {
	
	public static void main (String[] args) {
		
		FoodDeliveryFacade foodService = new FoodDeliveryFacade();
		
		// Use methods of the FoodDeliveryFacade object to complete a food delivery order
		foodService.createOrder();
		foodService.trackOrder();
		
		foodService.tipDriver();
		foodService.rateDriver();
		
		System.out.println("\nThank you for your purchase, and enjoy your meal!");
	}
	
}
