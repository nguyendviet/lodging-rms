package ams;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class Account {
	
	private String accountNumber;
	private Address address;
	private String phoneNumber;
	private String email = null;
	private Vector<Reservation> reservations;

	/**
	 * Construct to create Account object and assign values for a new Account 
	 * object
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public Account(String accountNumber, Address address, String phoneNumber, 
	String email) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException except for 
		// email address
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);

		this.accountNumber = accountNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		reservations = new Vector<Reservation>();
	}

	/**
	 * Overloading constructor if parameter is a file name
	 * Validate parameters and throws IllegalArgumentException
	 * Read content from file
	 * @param accountNumber 
	 */
	public Account(String accountNumber) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException
		Helper.validateParameters(accountNumber);

		// Create a constructor of file class and parsing an XML file 
		try { 
			File accountFile = new File("./accounts/" + accountNumber +"/acc" + accountNumber + ".xml");  
			boolean exists = accountFile.exists();
			if (!exists) {
				throw new IllegalLoadException(accountNumber);
			}
			// Create an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			// Ceate an instance of builder to parse the specified xml accountFile  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document document = db.parse(accountFile);
			String street = Helper.getValueFromTag("street", document);
			String city = Helper.getValueFromTag("city", document);
			String state = Helper.getValueFromTag("state", document);
			String zipcode = Helper.getValueFromTag("zipcode", document);
			// Assign values from file to object
			this.accountNumber = Helper.getValueFromTag("accountNumber", document);
			this.address = new Address(street, city, state, zipcode);
			this.phoneNumber = Helper.getValueFromTag("phoneNumber", document);
			this.email = Helper.getValueFromTag("email", document);
			
			reservations = new Vector<Reservation>();
		} catch (Exception e) {  
			e.printStackTrace();
		}  
	}

	/**
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<account>" + 
				"<accountNumber>" + accountNumber + "</accountNumber>" +
				address.toString() +
				"<phoneNumber>" + phoneNumber + "</phoneNumber>" + 
				"<email>" + email + "</email>" + 
				"<reservations>" +
					"<reservation></reservation>" +
				"</reservations>" + 
			"</account>";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		Helper.validateParameters(address.toString());
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		Helper.validateParameters(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Helper.validateParameters(email);
		this.email = email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Save account information in file.
	 * If found duplicate, throw DuplicateObjectException.
	 * @param fileName 
	 * @return
	 */
	public void saveToFile(String fileName) throws DuplicateObjectException {
		// TODO implement here
	}

	/**
	 * Add reservation object to the Vector of Reservation objects (check for duplicates)
	 * and return the reservation number.
	 * If duplicate found, throw DuplicateObjectException.
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public String addReservation(Reservation reservation) throws DuplicateObjectException {
		// TODO implement here
		return "";
	}

	/**
	 * Cancel reservation matching reservation number from currently loaded Account.  
	 * Can only cancel reservation if the start date is in the future.
	 * If cannot cancel, throw IllegalOperationException.
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public void editReservation(Reservation reservation) throws IllegalOperationException {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public List<Reservation> getReservations() {
		// TODO implement here
		return null;
	}

}
