package facadeDesign;
import java.time.*;
/* 	Tracking.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/

public class Tracking {
	private Clock startTime;
	private Duration estimatedTime;

	public Tracking() {
		startTime = Clock.systemUTC();
		estimatedTime = null;
	}
	
	public Clock getDeliveryTime()
	{
		if(estimatedTime == null)
			return null;
		Clock deliveryTime = Clock.offset(startTime, estimatedTime);
		return deliveryTime;
	}
	
	//passes driver to function to get estimated delivery time
	public void setEstimatedTime(double distance)
	{
		//algorithm for caluclating duration based on distance 
		//5 minutes at store + average 20 miles/hour
		long estimatedMinutes = (long) distance/25/60;

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
