package src.utility;

import src.model.Car;
import src.model.ParkingLot;

public class Query {
	
	public static final String CREATE = "create_parking_lot";
	public static final String PARK = "park";
	public static final String LEAVE = "leave";
	public static final String STATUS = "status";
	public static final String REGISTRATION_NUMBERS_FOR_COLOUR = "registration_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBERS_FOR_COLOUR = "slot_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	
	private Query() {}
	
	public static void process(String query) {
		String[] queryParts = query.split("\\s+");
		if (queryParts.length > 0) {
			execute(queryParts);
		}
	}
	
	private static void execute(String[] queryParts) {
		
		switch (queryParts[0]) {
		case CREATE:
			if (queryParts.length >= 2) {
				int size = Integer.parseInt(queryParts[1]);
				ParkingLot.instantiate(size);
				System.out.println("Created a parking lot with " + queryParts[1] + " slots");
			}
			break;
		case PARK:
			if (queryParts.length >= 3) {
				if (ParkingLot.getInstance().isFull()) {
					System.out.println("Sorry, parking lot is full");
				} else {
					String registrationNumber = queryParts[1];
					String colour = queryParts[2];
					Car car = new Car(registrationNumber, colour);
					int slotNumber = ParkingLot.getInstance().park(car);
					System.out.println("Allocated slot number: " + slotNumber);
				}
			}
			break;
		case LEAVE:
			if (queryParts.length >= 2) {
				int slotNumber = Integer.parseInt(queryParts[1]);
				if (slotNumber >= 1 && slotNumber <= ParkingLot.getInstance().getSize()) {
					ParkingLot.getInstance().leave(slotNumber);
					System.out.println("Slot number " + queryParts[1] + " is free");
				}
			}
			break;
		case STATUS:
			System.out.println("Slot No\tRegistration No\tColour");
			for (int slotNumber = 1; slotNumber <= ParkingLot.getInstance().getSize(); slotNumber++) {
				Car car = ParkingLot.getInstance().getCarAt(slotNumber);
				if (car != null) {
					System.out.println(slotNumber + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
				}
			}
			break;
		case REGISTRATION_NUMBERS_FOR_COLOUR:
			if (queryParts.length >= 2) {
				String colour = queryParts[1];
				boolean found = false;
				for (int slotNumber = 1; slotNumber <= ParkingLot.getInstance().getSize(); slotNumber++) {
					Car car = ParkingLot.getInstance().getCarAt(slotNumber);
					if (car != null && colour.equals(car.getColour())) {
						if (found) {
							System.out.print(", ");
						} else {
							found = true;
						}
						System.out.print(car.getRegistrationNumber());
					}
				}
				if (found) {
					System.out.println("");
				} else {
					System.out.println("Not found");
				}
			}
			break;
		case SLOT_NUMBERS_FOR_COLOUR:
			if (queryParts.length >= 2) {
				String colour = queryParts[1];
				boolean found = false;
				for (int slotNumber = 1; slotNumber <= ParkingLot.getInstance().getSize(); slotNumber++) {
					Car car = ParkingLot.getInstance().getCarAt(slotNumber);
					if (car != null && colour.equals(car.getColour())) {
						if (found) {
							System.out.print(", ");
						} else {
							found = true;
						}
						System.out.print(slotNumber);
					}
				}
				if (found) {
					System.out.println("");
				} else {
					System.out.println("Not found");
				}
			}
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			if (queryParts.length >= 2) {
				String registrationNumber = queryParts[1];
				int slotNumber = 1;
				boolean found = false;
				while (slotNumber <= ParkingLot.getInstance().getSize() && !found) {
					Car car = ParkingLot.getInstance().getCarAt(slotNumber);
					if (car != null && registrationNumber.equals(car.getRegistrationNumber())) {
						found = true;
						System.out.println(slotNumber);
					} else {
						slotNumber++;
					}
				}
				if (!found) {
					System.out.println("Not found");
				}
			}
			break;
		}
		
	}
	
}
