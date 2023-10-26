package facadeDesign;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* 	Driver.java
* 	is a subsystem class to be wrapped around by the Facade Class
*/
public class Driver {
	
	Scanner in = new Scanner(System.in);
	private Person driver;
	private ArrayList<Person> drivers;
	private static int NUM_DRIVERS = 20;
	private static double MIN_DISTANCE = 2, MAX_DISTANCE = 10;
	private double driverRating = 0.0;
	private int numRatings = 0;
	private int totalRatings = 0;
	private double driverTips = 0.0;
	
	public Driver() {
		generateDrivers();
		selectDriver();
	}
	
	public String getName() {
		return driver.getName();
	}
	
	public double getDistance() {
		return driver.getDistance();
	}
	
	// Pick from available drivers based on shortest distance, perhaps
	private void selectDriver() {
		Person minDriver = drivers.get(0);
		for(Person driv : drivers) {
			if(driv.getDistance() < minDriver.getDistance())
				minDriver = driv;
		}
		
		driver = minDriver;
	}
	
	private void generateDrivers() {
		String[] fNames = {"Kobie", "Lainey", "Estevan", "Bill", "Rhea", "Cristian", "Katarina", "Lincoln", "Don", "Reilly"};
		String[] lNames = {"Meeks", "Mason", "Case", "Sosa", "Osborne", "Rich", "Marsh", "Trujillo", "Delaney", "Albertson"};
		
		drivers = new ArrayList<Person>();
		for (int i = 0; i < NUM_DRIVERS; i++) {
			Person newDriver = new Person();
			//do {
			newDriver.setName(fNames[new Random().nextInt(fNames.length)] + " " + lNames[new Random().nextInt(lNames.length)]);
			//} while(drivers.contains());
				
			newDriver.setDistance(ThreadLocalRandom.current().nextDouble(MIN_DISTANCE, MAX_DISTANCE));
			
			drivers.add(newDriver);
		}
	}
	//gets a tip for the driver
		public void tipDriver(double tip)
		{
			driverTips += tip;
		}
		//gets a rating for the driver
		public void rateDriver(int rating)
		{
			numRatings += 1;
			totalRatings += rating;
			driverRating = totalRatings / numRatings;
			
		}
	}
	
	class Person {
		
		private String name;
		private double distance;
		
		public Person() {

		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setDistance(double distance) {
			this.distance = distance;
		}
		
		public String getName() {
			return name;
		}
		
		public double getDistance() {
			return distance;
		}
		
	}

