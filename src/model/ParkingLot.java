package model;

public class ParkingLot {
	
	private static ParkingLot instance = new ParkingLot(0);
	private static Car[] slot;
	private static int numberOfEmptySlot;
	
	private ParkingLot(int size) {
		instantiate(size);
	}
	
	public static void instantiate(int size) {
		slot = new Car[size + 1];
		numberOfEmptySlot = size;
	}

	public static ParkingLot getInstance() {
		return instance;
	}
	
	public static int getSize() {
		return slot.length - 1;
	}
	
	public static int getNumberOfEmptySlot() {
		return numberOfEmptySlot;
	}
	
	public static boolean isFull() {
		return numberOfEmptySlot == 0;
	}
	
	public static Car getCarAt(int slotNumber) {
		return slot[slotNumber];
	}
	
	public static int getFirstEmptySlotNumber() {
		int result = 1;
		while (result <= getSize()) {
			if (getCarAt(result) == null) {
				return result;
			}
			result++;
		}
		return -1;
	}
	
	public static int park(Car car) {
		if (!isFull()) {
			int slotNumber = getFirstEmptySlotNumber();
			slot[slotNumber] = car;
			numberOfEmptySlot--;
			return slotNumber;
		}
		return -1;
	}
	
	public static void leave(int slotNumber) {
		if (slot[slotNumber] != null) {
			slot[slotNumber] = null;
			numberOfEmptySlot++;
		}
	}
	
}
