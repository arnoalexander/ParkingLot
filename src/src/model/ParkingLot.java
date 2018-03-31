package src.model;


public class ParkingLot {
	
	private static ParkingLot instance = new ParkingLot(0);
	private Car[] slot;
	private int numberOfEmptySlot;
	
	private ParkingLot(int size) {
		slot = new Car[size + 1];
		numberOfEmptySlot = size;
	}
	
	public static void instantiate(int size) {
		getInstance().slot = new Car[size + 1];
		getInstance().numberOfEmptySlot = size;
	}

	public static ParkingLot getInstance() {
		return instance;
	}
	
	public int getSize() {
		return slot.length - 1;
	}
	
	public int getNumberOfEmptySlot() {
		return numberOfEmptySlot;
	}
	
	public boolean isFull() {
		return numberOfEmptySlot == 0;
	}
	
	public Car getCarAt(int slotNumber) {
		return slot[slotNumber];
	}
	
	public int getFirstEmptySlotNumber() {
		int result = 1;
		while (result <= getSize()) {
			if (getCarAt(result) == null) {
				return result;
			}
			result++;
		}
		return -1;
	}
	
	public int park(Car car) {
		if (!isFull()) {
			int slotNumber = getFirstEmptySlotNumber();
			slot[slotNumber] = car;
			numberOfEmptySlot--;
			return slotNumber;
		}
		return -1;
	}
	
	public void leave(int slotNumber) {
		if (slot[slotNumber] != null) {
			slot[slotNumber] = null;
			numberOfEmptySlot++;
		}
	}
	
}
