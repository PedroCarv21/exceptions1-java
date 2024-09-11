package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			Integer number = Integer.parseInt(sc.nextLine());
			System.out.print("Check-in date (dd/mm/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			System.out.printf("%n%nEnter data to update the reservation:%n");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = LocalDate.parse(sc.nextLine(), Reservation.dtf);
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (RuntimeException iae) {
			System.out.println("Error in syntax: " + iae);
		}
		
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		sc.close();
	}
	
}
