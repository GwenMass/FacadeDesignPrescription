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
	private double driverRating;
	private int numRatings;
	private int totalRatings;
	private double driverTips;
	
	public Driver() {
		generateDrivers();
		selectDriver();
		
		driverRating = 0;
		numRatings = 0;
		totalRatings = 0;
		driverTips = 0;
	}
	
	public String getName() {
		return driver.getName();
	}
	
	public double getDistance() {
		return driver.getDistance();
	}
	
	// Pick from available drivers based on shortest distance
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
		
		// Generate a list of potential drivers with random names and distances 
		drivers = new ArrayList<Person>();
		for (int i = 0; i < NUM_DRIVERS; i++) {
			Person newDriver = new Person();
			
			// Generate random combination of first and last name and random distance for each potential driver
			newDriver.setName(fNames[new Random().nextInt(fNames.length)] + " " + lNames[new Random().nextInt(lNames.length)]);
			newDriver.setDistance(ThreadLocalRandom.current().nextDouble(MIN_DISTANCE, MAX_DISTANCE));
			
			drivers.add(newDriver);
		}
	}
	
	// Accumulates a tip for the driver
	public void tipDriver(double tip) {
		driverTips += tip;
	}
	
	// Adjusts the rating for the driver
	public void rateDriver(int rating){
		numRatings += 1;
		totalRatings += rating;
		driverRating = totalRatings / numRatings;
			
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

