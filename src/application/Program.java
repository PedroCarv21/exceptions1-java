package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		Integer number = Integer.parseInt(sc.nextLine());
		System.out.print("Check-in date (dd/mm/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf);
		
		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.printf("%n%nEnter data to update the reservation:%n");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			
			LocalDate now = LocalDate.now();
			
			if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		
		sc.close();
	}
	
}
