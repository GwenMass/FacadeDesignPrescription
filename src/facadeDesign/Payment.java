package facadeDesign;

import java.util.Scanner;

public class Payment {
    private double amount;
    private String drivingRecipient;
    private String paymentType;
    private boolean processed;
    private double orderPrice;

    public Payment() {
        this.processed = false;
        //this.order = order;
    }

    public void acceptPaymentDetails(double price) {
    	this.orderPrice = price;
        Scanner in = new Scanner(System.in);

        do {
        	System.out.print("Enter the payment amount: $");
            amount = in.nextDouble();
            in.nextLine(); 
            
            if(amount < price) {
            	System.out.println("Payment amount is less than the order price. Insufficient funds!");
            }
            
        } while(amount < price);
        
        System.out.print("Enter the payment type (e.g., credit): ");
        paymentType = in.nextLine();

        System.out.print("Enter the customer name: ");
        drivingRecipient = in.nextLine();
    }

    public void processPayment() {
        if (!processed) {
            double change = (amount - orderPrice);
            System.out.println("\nProcessing payment of $" + amount + " via " + paymentType + " to " + drivingRecipient);
            System.out.println("Your change will be: " + change);
            processed = true;
        } else {
            System.out.println("Payment has already been processed.");
        }
    }

    public boolean isProcessed() {
        return processed;
    }

    @Override
    public String toString() {
        return "Payment\n" +
                "Amount = " + amount +
                ", Payment Type = " + paymentType +
                ", Driving Recipient = " + drivingRecipient +
                ", Is the payment processed? " + processed;
    }
}