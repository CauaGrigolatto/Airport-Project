package br.edu.ifsp.dsw1.feedback;

/**
 * Represents an exception thrown when a flight registration attempt fails due to an already registered flight.
 * 
 * This exception is used to indicate that a flight already exists in the system, 
 * preventing duplicate entries. 
 * It ensures data integrity and avoids conflicts in flight management operations.
 * 
 * Example usage:
 * - Thrown when attempting to register a flight with a number that is already present in the system.
 * - Used to notify the user or log an error regarding duplicate flight registrations.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class FlightAlreadyRegisteredException extends Exception {
	/**
     * Serialization identifier for ensuring compatibility during the serialization process.
     */
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructs a new FlightAlreadyRegisteredException with the specified detail message.
     * 
     * @param message the detail message explaining the reason for the exception
     */
	public FlightAlreadyRegisteredException(String message) {
		super(message);
	}
}
