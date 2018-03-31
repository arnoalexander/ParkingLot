package test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import src.model.Car;

public class CarTest {
	
	@Test
	public void testConstructorColour() {
		String registrationNumber = "KB-01-UU-1230";
		String colour = "Red";
		
		Car car = new Car(registrationNumber, colour);
		assertEquals(registrationNumber, car.getRegistrationNumber());
	}
	
	@Test
	public void testConstructorRegistrationNumber() {
		String registrationNumber = "KB-01-UU-1230";
		String colour = "Red";
		
		Car car = new Car(registrationNumber, colour);
		assertEquals(registrationNumber, car.getRegistrationNumber());
	}
	
	@Test
	public void testSetGetColour() {
		String colour = "Pink";
		Car car = new Car("", "");
		
		car.setColour(colour);
		assertEquals(colour, car.getColour());
	}
	
	@Test
	public void testSetGetRegistrationNumber() {
		String registrationNumber = "BK-01-AA-9230";
		Car car = new Car("", "");
		
		car.setRegistrationNumber(registrationNumber);
		assertEquals(registrationNumber, car.getRegistrationNumber());
	}

}
