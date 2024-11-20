package br.edu.ifsp.dsw1.feedback;

/**
 * Represents an exception thrown when a login attempt fails due to invalid credentials.
 * 
 * This exception is used to indicate errors specifically related to authentication, 
 * such as incorrect usernames or passwords. It allows the application to handle login 
 * failures in a consistent and structured manner.
 * 
 * Example usage:
 * - Thrown by the login logic when provided credentials do not match the expected values.
 * - Used to notify the user or log an error when an invalid login attempt is detected.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class InvalidLoginException extends Exception {
	
	/**
     * Serialization identifier for ensuring compatibility during the serialization process.
     */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new InvalidLoginException with the specified detail message.
     * 
     * @param message the detail message explaining the reason for the exception
     */
	public InvalidLoginException(String message) {
		super(message);
	}
}
