package facadeDesign;
import java.time.*;
/* 	Tracking.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/

public class Tracking {
	private LocalTime startTime;
	private long estimatedTime;

	public Tracking() {
		startTime = LocalTime.now();
		estimatedTime = 0;
	}
	
	public LocalTime getDeliveryTime()
	{
		if(estimatedTime == 0)
			return null;
		LocalTime deliveryTime = startTime.plusMinutes(estimatedTime);
		return deliveryTime;
	}
	
	//passes distance from driver to get an estimated time
	public void setEstimatedTime(double distance)
	{	
		estimatedTime = Math.round(distance * 2.5);
	}

}
