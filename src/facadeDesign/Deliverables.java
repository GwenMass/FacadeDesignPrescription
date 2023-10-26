package facadeDesign;

public enum Deliverables {
	BURGER("Order Burger", 9.99),							//Item 1
	PIZZA("Order Pizza", 7.99),								//Item 2
	TACOS("Order 3 Tacos", 3.99),							//Item 3
	SALAD("Order Salad", 5.95),								//Item 4
	RAMEN("Order Ramen", 3.50),								//Item 5
	CHICKENFINGERS("Order Chicken Fingers",8.99),			//Item 6
	CHICKENSANDWICH("Order Chicken Sandwich", 8.95),		//Item 7
	SUSHI("Order Sushi", 9.65),								//Item 8
	SODA("Order Soda", 2.99),								//Item 9
	TEA("Order Tea", 1.99),									//Item 10
	COFFEE("Order Coffee", 5.65),							//Item 11
	MILKSHAKE("Order Milkshake", 4.95),						//Item 12
	DONUTS("Order Dozen Donuts", 9.45),						//Item 13
	FRIES("Order Fries", 3.99),								//Item 14
	HOTDOG("Order Hotdog", 6.95);							//Item 15
	
	private String itemDescription;
	private double price;
	
	Deliverables(String itemDescription, double price){
		this.itemDescription = itemDescription;
		this.price = price;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public double getPrice() {
		return price;
	}
}
