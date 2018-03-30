package model;

public class ParkingLot {
	
	private static ParkingLot instance = new ParkingLot(0);
	private static Car[] slot;
	
	private ParkingLot(int size) {
		instantiate(size);
	}
	
	public static void instantiate(int size) {
		slot = new Car[size + 1];
	}

	public static ParkingLot getInstance() {
		return instance;
	}
	
	public static int getSize() {
		return slot.length - 1;
	}
	
	public static Car getCarAt(int slotNumber) {
		return slot[slotNumber];
	}
	
	public static void setCarAt(int slotNumber, Car car) {
		slot[slotNumber] = car;
	}
	
}
