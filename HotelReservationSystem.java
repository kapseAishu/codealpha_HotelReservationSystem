package CodeAlpha_HotelReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
	static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initRooms();
        int choice;
        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Reservations");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom();
                case 3 -> cancelReservation();
                case 4 -> viewReservations();
                case 5 -> System.out.println("Thank you for using our system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void initRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public static void bookRoom() {
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter room type to book (Standard/Deluxe/Suite): ");
        String type = sc.nextLine();

        for (Room r : rooms) {
            if (r.type.equalsIgnoreCase(type) && r.isAvailable) {
                r.isAvailable = false;
                Reservation res = new Reservation(name, r);
                reservations.add(res);
                System.out.println("Room booked successfully!");
                System.out.println(res);
                return;
            }
        }
        System.out.println("No available rooms of type: " + type);
    }

    public static void cancelReservation() {
        System.out.print("\nEnter your name to cancel reservation: ");
        String name = sc.nextLine();
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).customerName.equalsIgnoreCase(name)) {
                Room r = reservations.get(i).room;
                r.isAvailable = true;
                reservations.remove(i);
                System.out.println("Reservation canceled for " + name);
                return;
            }
        }
        System.out.println("No reservation found for " + name);
    }

    public static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("\n--- All Reservations ---");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }

}
