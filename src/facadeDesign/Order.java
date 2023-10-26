package facadeDesign;

import java.util.ArrayList;
import java.util.Scanner;

/* 	Order.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/
public class Order {
	
	private ArrayList<Deliverable> items;
	//private Payment payment;
	
	public Order() {
		items = new ArrayList<Deliverable>();
		//payment = new Payment();
	}
	
	// Displays all deliverable items and allows user to pick items to order
	public void orderItems() {
		// Display the menu
		System.out.println("Item No. \tPrice \tItem");
		int itemNo = 0;
		for(Deliverables item : Deliverables.values()) {
			System.out.println("Item " + ++itemNo + "\t\t$" + item.getPrice() + "\t" + item.getItemName());
		}
		
		//Prompt user to pick items from menu
		Scanner in = new Scanner(System.in);
		int userInput = 1;
		
		do {
			System.out.print("Enter an Item No. to order an item (enter 0 to finish ordering): ");
			userInput = in.nextInt();
			
			// If input is in range and not 0, add the appropriate item to the ArrayList of ordered items
			if(userInput < 0 || userInput > Deliverables.values().length)
				System.out.println("Error. Invalid Item No.");
			else if (userInput != 0){
				Deliverable newItem = new Deliverable(Deliverables.getItem(userInput-1).getItemName(), Deliverables.getItem(userInput-1).getPrice());
				items.add(newItem);
			}
			
		} while (userInput != 0);
		
		//in.close();
		
		//payment.acceptPaymentDetails();
	}
	
	public void displayOrder() {
		// Display each item and its pre-tax price
		for(Deliverable item : items) {
			System.out.println(item.getItemName() + " for $" + item.getPrice());
		}
		
	}
	
	public double calculateOrderPrice() {
		double orderPrice = 0;
		
		for(Deliverable item : items) {
			orderPrice += item.getPrice();
		}
		
		return orderPrice;
	}
	
	
	private class Deliverable {
		private String itemName;
		private double price;
		
		public Deliverable(String itemName, double price) {
			this.itemName = itemName;
			this.price = price;
		}
		
		private String getItemName() {
			return itemName;
		}
		
		private double getPrice() {
			return price;
		}
	}

}
