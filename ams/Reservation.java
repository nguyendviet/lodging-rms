package ams;
import java.util.*;

/**
 * Reservation number prefixes: HT = hotel, CB = cabin, SH = house
 */
public abstract class Reservation {

	/**
	 * Validate parameters
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of lodge (address, number of beds, etc.)
	 * Calculate the price based on check in and check out dates and the type of lodge.
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param checkIn 
	 * @param checkOut
	 */
	public Reservation(String accountNumber, String reservationNumber, Date checkIn, Date checkOut) {
	}

	/**
	 * Validate parameter is not null and throw IllegalArgumentException.
	 * Validate fileName with path. If not found, throw IllegalLoadException.
	 * If found, load the object’s attributes with the content in the file.
	 * @param fileName
	 */
	public Reservation(String fileName) throws IllegalLoadException {
	}

	/**
	 * 
	 */
	protected String accountNumber;

	/**
	 * 
	 */
	protected String reservationNumber;

	/**
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of the account (address,  number of beds, etc.) from the account's details
	 */
	private Address address;

	/**
	 * 
	 */
	private String status = "draft";

	/**
	 * 
	 */
	private Date checkIn;

	/**
	 * 
	 */
	private Date checkOut;

	/**
	 * 
	 */
	private double price;

	/**
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * Required method for the subclass to implement.
	 * @return
	 */
	public abstract double calculatePrice();

	/**
	 * Calculate the nights based on the class’s attributes checkIn and checkOut.
	 * @return
	 */
	public int calculateNights() {
		// TODO implement here
		return 0;
	}

	/**
	 * Validate parameters
	 * Update reservation data using passed in parameters.
	 * Update the details if found. If file not found, throw IllegalLoadException.
	 * @param checkIn 
	 * @param checkOut 
	 * @param address 
	 * @return
	 */
	public void updateReservation(Date checkIn, Date checkOut, Address address) throws IllegalLoadException {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getAccountNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getReservationNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getAddress() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getStatus() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public Date getCheckIn() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Date getCheckOut() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		// TODO implement here
		return 0.0d;
	}

	/**
	 * If for some reasons, cannot complete the reservation 
	 * (e.g. lodge doesn't have available rooms at the time of booking), 
	 * throw IllegalOperationException.
	 * @param status
	 */
	public void setStatus(String status) throws IllegalOperationException {
		// TODO implement here
	}

	/**
	 * Update/replace the class's checkIn attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkInDate
	 */
	public void setCheckIn(Date checkInDate) throws IllegalOperationException {
		// TODO implement here
	}

	/**
	 * Update/replace the class's checkOut attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkOutDate
	 */
	public void setCheckOut(Date checkOutDate) throws IllegalOperationException {
		// TODO implement here
	}

}