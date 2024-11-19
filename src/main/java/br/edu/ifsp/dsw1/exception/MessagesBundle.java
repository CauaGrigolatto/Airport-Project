package br.edu.ifsp.dsw1.exception;

public interface MessagesBundle {
	final String INVALID_LOGIN                      =   "Invalid credentials. Please check your username and password.";
	final String FLIGHT_FIELDS_EMPTY                =   "There are required fields that have not been filled. Please review and complete all necessary information.";
	final String FLIGHT_IS_NULL                     =   "Flight cannot be empty.";
	final String FLIGHT_NUMBER_ALREADY_REGISTERED   =   "This flight number is already registered.";
	final String INVALID_FLIGHT_NUMBER              =   "Flight number is invalid.";
}
