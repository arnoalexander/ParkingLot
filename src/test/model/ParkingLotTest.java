package test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import src.model.Car;
import src.model.ParkingLot;;

public class ParkingLotTest {
	
	@Test
	public void testInstanceInstantiation() {
		assertNotNull(ParkingLot.getInstance());
	}
	
	@Test
	public void testSize() {
		int size = 12;
		
		ParkingLot.instantiate(size);
		assertEquals(size, ParkingLot.getInstance().getSize());
	}
	
	@Test
	public void testNumberOfEmptySlot() {
		int size = 13;
		int numberOfParkedCar = 2;
		Car car = new Car("", "");
		
		ParkingLot.instantiate(size);
		for (int index = 1; index <= numberOfParkedCar; index++) {
			ParkingLot.getInstance().park(car);
		}
		assertEquals(size - numberOfParkedCar, ParkingLot.getInstance().getNumberOfEmptySlot());
	}
	
	@Test
	public void testFull() {
		int size = 9;
		int carCount = 0;
		Car car = new Car("", "");
		
		ParkingLot.instantiate(size);
		while (!ParkingLot.getInstance().isFull()) {
			ParkingLot.getInstance().park(car);
			carCount++;
		}
		assertEquals(carCount, ParkingLot.getInstance().getSize());
	}
	
	@Test
	public void testCarAt() {
		int size = 4;
		int trueSlotNumber = 2;
		String registrationNumber = "BK-22-AA-2222";
		String colour = "Orange";
		Car falseCar = new Car("", "");
		Car trueCar = new Car(registrationNumber, colour);
		
		ParkingLot.instantiate(size);
		for (int index = 1; index <= size; index++) {
			if (index != trueSlotNumber) {
				ParkingLot.getInstance().park(falseCar);
			} else {
				ParkingLot.getInstance().park(trueCar);
			}
		}
		assertEquals(registrationNumber, ParkingLot.getInstance().getCarAt(trueSlotNumber).getRegistrationNumber());
		assertEquals(colour, ParkingLot.getInstance().getCarAt(trueSlotNumber).getColour());
	}
	
	@Test
	public void testFirstEmptySlotNumber() {
		int size = 10;
		int filledSlot = 8;
		int leftSlotNumber = 6;
		Car car = new Car("", "");
		
		ParkingLot.instantiate(size);
		for (int index = 1; index <= filledSlot; index++) {
			ParkingLot.getInstance().park(car);
		}
		ParkingLot.getInstance().leave(leftSlotNumber);
		assertEquals(leftSlotNumber, ParkingLot.getInstance().getFirstEmptySlotNumber());
	}
	
}
