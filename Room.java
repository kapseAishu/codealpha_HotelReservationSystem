package CodeAlpha_HotelReservationSystem;

public class Room {
	 int roomNumber;
	    String type;
	    boolean isAvailable;

	    Room(int roomNumber, String type) {
	        this.roomNumber = roomNumber;
	        this.type = type;
	        this.isAvailable = true;
	    }

	    @Override
	    public String toString() {
	        return "Room " + roomNumber + " (" + type + ") - " + (isAvailable ? "Available" : "Booked");
	    }

}
