package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation{
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getcheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public Duration duration() {
		Duration diff = Duration.between(checkIn.atTime(0, 0), checkOut.atTime(0, 0));
		return diff;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException{
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %s nights", this.roomNumber, dtf.format(checkIn), dtf.format(checkOut), this.duration().toDays());
	}
	
}
