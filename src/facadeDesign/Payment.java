package facadeDesign;

/* 	Payment.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/

public class Payment {
	
	private double amount;
	private String drivingRecipient;
	private String paymentType;
	private boolean processed;
	
	public Payment(double amount, String drivingRecipient, String paymentType) {
		this.amount = amount;
		this.drivingRecipient = drivingRecipient;
		this.paymentType = paymentType;
		this.processed = false;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getDrvingRecipient() {
		return drivingRecipient;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void processPayment() {
		if(!processed) {
			//come back to this logic after Order class
			processed = true;
		} else {
			System.out.println("Payment has already been sent!");
		}
		
	}
	
	public boolean isProcessed() {
		return processed;
	}
	
	public String toString() {
		return "Payment\n" + 
				"Amount = " + amount + 
				", Payment Type = " + paymentType +
				", Driving Recipient = " + drivingRecipient +
				", Is the payment processed? " + processed;
	}
}
