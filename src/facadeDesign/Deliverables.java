package facadeDesign;

public enum Deliverables {
	BURGER("Burger", 9.99),							//Item 1
	PIZZA("Pizza", 7.99),							//Item 2
	TACOS("Tacos", 3.99),							//Item 3
	SALAD("Salad", 5.95),							//Item 4
	RAMEN("Ramen", 3.49),							//Item 5
	CHICKENFINGERS("Chicken Fingers",8.99),			//Item 6
	CHICKENSANDWICH("Chicken Sandwich", 8.95),		//Item 7
	SUSHI("Sushi", 9.65),							//Item 8
	SODA("Soda", 2.99),								//Item 9
	TEA("Tea", 1.99),								//Item 10
	COFFEE("Coffee", 5.65),							//Item 11
	MILKSHAKE("Milkshake", 4.95),					//Item 12
	DONUTS("Dozen Donuts", 9.45),					//Item 13
	FRIES("Fries", 3.99),							//Item 14
	HOTDOG("Hotdog", 6.95);							//Item 15
	
	private String itemName;
	private double price;
	
	private static Deliverables[] itemList = Deliverables.values();
	
	Deliverables(String itemName, double price){
		this.itemName = itemName;
		this.price = price;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static Deliverables getItem(int i) {
		return itemList[i];
	}
	
}
