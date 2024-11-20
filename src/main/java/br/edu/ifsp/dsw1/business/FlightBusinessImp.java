package br.edu.ifsp.dsw1.business;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.feedback.FlightAlreadyRegisteredException;
import br.edu.ifsp.dsw1.feedback.FlightIsNullException;
import br.edu.ifsp.dsw1.feedback.MessagesBundle;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.State;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.totem.ArrivingTotemImp;
import br.edu.ifsp.dsw1.model.totem.BoardingTotemImp;
import br.edu.ifsp.dsw1.model.totem.FlightTotem;
import br.edu.ifsp.dsw1.model.totem.TakingOffTotemImp;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Implements the FlightBusiness interface, providing methods for handling flight data, 
 * such as retrieving, inserting, updating, and managing flight information.
 * It interacts with the FlightDataCollection and FlightTotem instances to perform these operations.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class FlightBusinessImp implements FlightBusiness {
	private static final FlightDataCollection flightDAO = new FlightDataCollection();
	
	private static FlightTotem arrivingTotem = new ArrivingTotemImp();
	private static FlightTotem boardingTotem = new BoardingTotemImp();
	private static FlightTotem takingOffTotem = new TakingOffTotemImp();
	
	/**
     * Constructor for FlightBusinessImp. Registers the flight totems (observers) for different flight states.
     */
	public FlightBusinessImp() {
		flightDAO.register(arrivingTotem);
		flightDAO.register(boardingTotem);
		flightDAO.register(takingOffTotem);
	}
	
	/**
     * Retrieves all flights from the collection.
     * 
     * @return a list of all FlightData instances.
     */
	@Override
	public List<FlightData> getAllFlights() {
		return flightDAO.getAllFligthts();
	}
	
	/**
     * Retrieves all flights that are arriving.
     * 
     * @return a list of flights in the arriving state.
     */
	@Override
	public List<FlightData> getArrivingFlights() {
		return arrivingTotem.getFlights();
	}

	/**
     * Retrieves all flights that are boarding.
     * 
     * @return a list of flights in the boarding state.
     */
	@Override
	public List<FlightData> getBoardingFlights() {
		return boardingTotem.getFlights();
	}
	
	/**
     * Retrieves all flights that are taking off.
     * 
     * @return a list of flights in the taking off state.
     */
	@Override
	public List<FlightData> getTakingOffFlights() {
		return takingOffTotem.getFlights();
	}
	
	/**
     * Inserts a new flight into the flight collection.
     * 
     * @param flight the flight to be inserted.
     * @throws FlightIsNullException if the flight or its number is null.
     * @throws FlightAlreadyRegisteredException if the flight number is already registered.
     */
	@Override
	public void insert(FlightData flight) throws FlightIsNullException, FlightAlreadyRegisteredException {
		if (flight == null || flight.getFlightNumber() == null) {
			throw new FlightIsNullException(MessagesBundle.FLIGHT_IS_NULL);
		}
		
		if (flightDAO.findByNumber(flight.getFlightNumber()) != null) {
			throw new FlightAlreadyRegisteredException(MessagesBundle.FLIGHT_NUMBER_ALREADY_REGISTERED);
		}
		
		
		flightDAO.insertFlight(flight);
	}
	
	/**
     * Updates the state of an existing flight.
     * 
     * @param flight the flight to be updated.
     * @throws FlightIsNullException if the flight is null.
     */
	@Override
	public void updateFlight(FlightData flight) throws FlightIsNullException {
		if (flight == null) {
			throw new FlightIsNullException(MessagesBundle.FLIGHT_IS_NULL);
		}
		flightDAO.updateFlight(flight.getFlightNumber());
	}
	
	/**
     * Retrieves a flight from the request parameters and creates a FlightData object.
     * 
     * @param request the HTTP request containing flight details.
     * @return a FlightData object created from the request parameters.
     * @throws IllegalArgumentException if any required parameters are missing or invalid.
     */
	@Override
	public FlightData getByRequest(HttpServletRequest request) throws IllegalArgumentException {
		try {
			String flightNumberString = request.getParameter("flightNumber");
			String company = request.getParameter("company");
			String time = request.getParameter("time");

			if (StringUtils.isBlank(flightNumberString) || StringUtils.isBlank(company) || StringUtils.isBlank(time)) {
				throw new IllegalArgumentException(MessagesBundle.FLIGHT_FIELDS_EMPTY);
			}

			Long flightNumber = Long.parseLong(flightNumberString);

			FlightData flight = new FlightData(flightNumber, company, time);
			State state = getStateByRequest(request);

			flight.setState(state);

			return flight;
		} 
		catch (NumberFormatException e) {
			throw new IllegalArgumentException(MessagesBundle.INVALID_FLIGHT_NUMBER);
		}
		catch (Throwable t) {
			System.out.println("error getByRequest " + t);
			throw t;
		}
	}
	
	/**
     * Determines the flight state based on the request parameters.
     * The default state is Arriving.
     * 
     * @param request the HTTP request containing the state parameter.
     * @return the corresponding State object based on the request.
     */
	@Override
	public State getStateByRequest(HttpServletRequest request) {
		State state = Arriving.getIntance();
		String stateString = request.getParameter("state");

		if (StringUtils.isNotBlank(stateString)) {
			if (stateString.equals(Boarding.class.getSimpleName())) {
				state = Boarding.getIntance();
			} else if (stateString.equals(TakingOff.class.getSimpleName())) {
				state = TakingOff.getIntance();
			} else if (stateString.equals(TookOff.class.getSimpleName())) {
				state = TookOff.getIntance();
			}
		}

		return state;
	}
	
	/**
     * Retrieves a flight by its number from the request parameters.
     * 
     * @param request the HTTP request containing the flight number.
     * @return the FlightData object corresponding to the flight number.
     * @throws FlightIsNullException if no flight is found for the given number.
     * @throws IllegalArgumentException if the flight number is invalid.
     */
	@Override
	public FlightData getFlightByNumberInRequest(HttpServletRequest request) throws FlightIsNullException, IllegalArgumentException {
		try {			
			String flightNumberString = (String) request.getParameter("flightNumber");
			
			if (StringUtils.isBlank(flightNumberString)) {
				throw new FlightIsNullException(MessagesBundle.FLIGHT_IS_NULL);
			}
			
			Long flightNumber = Long.parseLong(flightNumberString);
			FlightData flight = flightDAO.findByNumber(flightNumber);
			
			if (flight == null) {
				throw new FlightIsNullException(MessagesBundle.FLIGHT_IS_NULL);
			}
			
			return flight;
		}
		catch(NumberFormatException e) {
			throw new IllegalArgumentException(MessagesBundle.INVALID_FLIGHT_NUMBER);
		}
	}
}
