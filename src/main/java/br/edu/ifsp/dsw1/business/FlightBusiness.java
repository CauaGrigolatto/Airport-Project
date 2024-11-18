package br.edu.ifsp.dsw1.business;

import java.io.InvalidObjectException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;
import jakarta.servlet.http.HttpServletRequest;

public interface FlightBusiness {
	List<FlightData> getAllFlights();
	void insert(FlightData flight) throws InvalidObjectException;
	void updateFlight(Long flightNumber) throws InvalidObjectException;
	FlightData getByRequest(HttpServletRequest request);
	State getStateByRequest(HttpServletRequest request);
	
	List<FlightData> getArrivingFlights();
	List<FlightData> getBoardingFlights();
	List<FlightData> getTakingOffFlights();
}
