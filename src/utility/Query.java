package utility;

import model.Car;
import model.ParkingLot;

public class Query {
	
	public static final String CREATE = "create_parking_lot";
	public static final String PARK = "park";
	public static final String LEAVE = "leave";
	public static final String STATUS = "status";
	public static final String REGISTRATION_NUMBERS_FOR_COLOUR = "registration_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBERS_FOR_COLOUR = "slot_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	
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
				if (ParkingLot.isFull()) {
					System.out.println("Sorry, parking lot is full");
				} else {
					String registrationNumber = queryParts[1];
					String colour = queryParts[2];
					Car car = new Car(registrationNumber, colour);
					int slotNumber = ParkingLot.park(car);
					System.out.println("Allocated slot number: " + slotNumber);
				}
			}
			break;
		case LEAVE:
			// TODO : implement this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case STATUS:
			// TODO : implement this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case REGISTRATION_NUMBERS_FOR_COLOUR:
			// TODO : implement this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case SLOT_NUMBERS_FOR_COLOUR:
			// TODO : implement this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			// TODO : implement this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		}
		
	}
	
}
