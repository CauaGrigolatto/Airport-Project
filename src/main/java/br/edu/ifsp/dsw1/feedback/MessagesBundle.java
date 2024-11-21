package br.edu.ifsp.dsw1.feedback;

/**
 * Provides a centralized collection of constant messages used across the application.
 * These messages are primarily used for error handling and user feedback.
 * 
 * The interface defines a set of predefined messages as constants, allowing for consistent
 * and reusable error and feedback messages throughout the system.
 * 
 * Example usage:
 * - Displaying error messages to users when an exception occurs.
 * - Logging meaningful information for debugging purposes.
 * 
 * This approach ensures that all messages are defined in a single place, facilitating 
 * maintainability and localization if needed in the future.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public interface MessagesBundle {
	final String INVALID_LOGIN                      =   "Invalid credentials. Please check your username and password.";
	final String FLIGHT_FIELDS_EMPTY                =   "There are required fields that have not been filled. Please review and complete all necessary information.";
	final String FLIGHT_IS_NULL                     =   "Flight cannot be empty.";
	final String FLIGHT_NUMBER_ALREADY_REGISTERED   =   "This flight number is already registered.";
	final String INVALID_FLIGHT_NUMBER              =   "Flight number is invalid.";
	final String ACTION_DENIED_BY_PERMISSIONS       =   "No permissions to do this action.";
	final String FLIGHT_CREATED_SUCCESSFULLY        =   "Flight created successfully.";
}
