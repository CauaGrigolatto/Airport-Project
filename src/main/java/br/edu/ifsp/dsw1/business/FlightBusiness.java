package br.edu.ifsp.dsw1.business;

import java.io.InvalidObjectException;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;
import jakarta.servlet.http.HttpServletRequest;

public interface FlightBusiness {
	void insert(FlightData flight) throws InvalidObjectException;
	void update(Long flightNumber) throws InvalidObjectException;
	FlightData getByRequest(HttpServletRequest request);
	State getStateByRequest(HttpServletRequest request);
}
