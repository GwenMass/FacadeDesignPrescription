package facadeDesign;
import java.time.*;
/* 	Tracking.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/

public class Tracking {
private Clock startTime;
private Duration estimatedTime;

	private void Tracking() {
		startTime = Clock.systemUTC();
		estimatedTime = null;
	}
	
	public Clock getDeliveryTime()
	{
		Clock deliveryTime = Clock.offset(startTime, estimatedTime);
		return deliveryTime;
	}
	
	//passes driver to function to get estimated delivery time
	public void SetEstimatedTime(Driver driver)
	{
		//algorithm for caluclating duration based on distance 
		//5 minutes at store + average 20 miles/hour
		long estimatedMinutes = (long)driver.getDistance()/25/60;
		estimatedTime = Duration.ofMinutes(estimatedMinutes);
	}
	//displays times for delivery tracking purposes
	public void trackerDisplay()
	{
		System.out.println("The current time is : " + startTime);
		System.out.println("Your estimated wait is...");
		System.out.println(estimatedTime + " minutes");
		
		
		System.out.println("Your food has been delivered at " + getDeliveryTime());
		
	}
}
