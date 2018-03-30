package utility;

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
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case PARK:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case LEAVE:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case STATUS:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case REGISTRATION_NUMBERS_FOR_COLOUR:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case SLOT_NUMBERS_FOR_COLOUR:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			// TODO : run this query
			System.out.println("Parsing " + queryParts[0]);
			break;
		}
		
	}
	
}
