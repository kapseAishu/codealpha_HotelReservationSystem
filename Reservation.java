package CodeAlpha_HotelReservationSystem;

public class Reservation {
	String customerName;
    Room room;
    String paymentStatus;

    Reservation(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
        this.paymentStatus = "Paid"; // Simulated
    }

    @Override
    public String toString() {
        return customerName + " booked " + room.type + " Room " + room.roomNumber + " - Payment: " + paymentStatus;
    }

}
