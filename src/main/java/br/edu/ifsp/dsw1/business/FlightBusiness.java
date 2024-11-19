package br.edu.ifsp.dsw1.business;

import java.util.List;

import br.edu.ifsp.dsw1.exception.FlightAlreadyRegisteredException;
import br.edu.ifsp.dsw1.exception.FlightIsNullException;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;
import jakarta.servlet.http.HttpServletRequest;

public interface FlightBusiness {
	List<FlightData> getAllFlights();
	void insert(FlightData flight) throws FlightIsNullException, FlightAlreadyRegisteredException;
	void updateFlight(FlightData flight) throws FlightIsNullException;
	FlightData getByRequest(HttpServletRequest request) throws IllegalArgumentException;
	State getStateByRequest(HttpServletRequest request);
	
	List<FlightData> getArrivingFlights();
	List<FlightData> getBoardingFlights();
	List<FlightData> getTakingOffFlights();
	FlightData getFlightByNumberInRequest(HttpServletRequest request) throws FlightIsNullException, IllegalArgumentException;
}
