package facadeDesign;

import java.util.ArrayList;

/* 	Order.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/

public class Order {
	
	// Instead of ArrayList<String> maybe we could have an ArrayList<Deliverable> or something that
	// combines both a String for an item's name and a double for its price
	private ArrayList<String> items;
	
	public Order() {
		
	}

}
