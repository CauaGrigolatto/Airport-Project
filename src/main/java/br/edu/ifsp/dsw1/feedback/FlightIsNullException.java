package br.edu.ifsp.dsw1.feedback;

/**
 * Represents an exception thrown when a flight-related operation encounters a null or invalid flight.
 * 
 * This exception is typically used to signal that a flight object is either null or lacks 
 * the necessary data to proceed with the intended operation. It helps enforce validation 
 * and maintain data integrity in flight management processes.
 * 
 * Example usage:
 * - Thrown when attempting to create or update a flight with insufficient or null data.
 * - Used to indicate errors in flight-related business logic or data handling.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class FlightIsNullException extends Exception {
	/**
     * Serialization identifier for ensuring compatibility during the serialization process.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new FlightIsNullException with the specified detail message.
     * 
     * @param message the detail message explaining the reason for the exception
     */
	public FlightIsNullException(String message) {
		super(message);
	}
}
