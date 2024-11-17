package br.edu.ifsp.dsw1.business;

import java.io.InvalidObjectException;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.http.HttpServletRequest;

public class FlightBusinessImp implements FlightBusiness {
	private static final FlightDataCollection flightDAO = new FlightDataCollection();
	
	@Override
	public void insert(FlightData flight) throws InvalidObjectException {
		if (flight == null) {			
			throw new InvalidObjectException("Flight does not exist.");
		}
		flightDAO.insertFlight(flight);
	}
	
	@Override
	public void update(Long flightNumber) throws InvalidObjectException {
		if (flightNumber == null) {
			throw new InvalidObjectException("Flight does not exist.")
		}
		flightDAO.updateFlight(flightNumber);
	}
	
	@Override
	public FlightData getByRequest(HttpServletRequest request) {
		return null;
	}
}
