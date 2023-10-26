package facadeDesign;

import java.util.Scanner;

public class Payment {
    private double amount;
    private String drivingRecipient;
    private String paymentType;
    private boolean processed;
    private Order order;

    public Payment() {
        this.processed = false;
        this.order = order;
    }

    public void acceptPaymentDetails() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the payment amount: $");
        amount = in.nextDouble();
        in.nextLine(); 

        System.out.println("Enter the payment type: ");
        paymentType = in.nextLine();

        System.out.println("Enter the driving recipient: ");
        drivingRecipient = in.nextLine();

        in.close();
    }

    public void processPayment() {
        if (!processed) {
        	double orderPrice = order.calculateOrderPrice(); 
            if (amount < orderPrice) {
                System.out.println("Payment amount is less than the order price. Insufficient funds!");
            } else {
            	double change = amount - orderPrice;
                System.out.println("Processing payment of $" + amount + " via " + paymentType + " to " + drivingRecipient);
                System.out.println("Your change is: " + change);
                processed = true;
            }
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