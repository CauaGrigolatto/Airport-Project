package br.edu.ifsp.dsw1.business;

import java.util.List;

import br.edu.ifsp.dsw1.feedback.FlightAlreadyRegisteredException;
import br.edu.ifsp.dsw1.feedback.FlightIsNullException;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Provides the business logic for classes that will manage flights in the system.
 * This interface defines methods for retrieving, creating, and updating flights, 
 * as well as querying flight states based on various criteria.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public interface FlightBusiness {
	/**
     * Retrieves a list of all flights in the system.
     * 
     * @return a list of all flights
     */
	List<FlightData> getAllFlights();
	
	/**
     * Inserts a new flight into the system.
     * This method throws exceptions if the flight is null or already exists.
     * 
     * @param flight the flight to be inserted
     * @throws FlightIsNullException if the flight data is null
     * @throws FlightAlreadyRegisteredException if the flight is already registered in the system
     */
	void insert(FlightData flight) throws FlightIsNullException, FlightAlreadyRegisteredException;
	
	 /**
     * Updates the state of an existing flight.
     * 
     * @param flight the flight which state will be updated
     * @throws FlightIsNullException if the flight data is null
     */
	void updateFlight(FlightData flight) throws FlightIsNullException;
	
	/**
     * Retrieves flight data from the HTTP request.
     * This method builds a flight from the request and returns it.
     * 
     * @param request the HTTP request containing the flight information
     * @return the FlightData object extracted from the request
     * @throws IllegalArgumentException if the flight data in the request is invalid
     */
	FlightData getByRequest(HttpServletRequest request) throws IllegalArgumentException;
	
	/**
     * Retrieves the flight state based on the request.
     * 
     * @param request the HTTP request containing the flight information
     * @return the flight state associated with the request
     */
	State getStateByRequest(HttpServletRequest request);
	
	/**
     * Retrieves a list of flights that are arriving.
     * 
     * @return a list of flights that are arriving
     */
	List<FlightData> getArrivingFlights();
	
	/**
     * Retrieves a list of flights that are boarding.
     * 
     * @return a list of flights that are boarding
     */
	List<FlightData> getBoardingFlights();
	
	/**
     * Retrieves a list of flights that are taking off.
     * 
     * @return a list of flights that are taking off
     */
	List<FlightData> getTakingOffFlights();
	
	/**
     * Retrieves a flight based on its flight number in the request.
     * This method is used to fetch a specific flight identified by its flight number.
     * 
     * @param request the HTTP request containing the flight number
     * @return the flight identified by the flight number
     * @throws FlightIsNullException if no flight is found for the given flight number
     * @throws IllegalArgumentException if the flight number in the request is invalid
     */
	FlightData getFlightByNumberInRequest(HttpServletRequest request) throws FlightIsNullException, IllegalArgumentException;
}
