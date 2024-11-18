package br.edu.ifsp.dsw1.business;

import java.io.InvalidObjectException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.State;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import jakarta.servlet.http.HttpServletRequest;

public class FlightBusinessImp implements FlightBusiness {
	private static final FlightDataCollection flightDAO = new FlightDataCollection();
	
	@Override
	public List<FlightData> getAllFlights() {
		return flightDAO.getAllFligthts();
	}
	
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
			throw new InvalidObjectException("Flight does not exist.");
		}
		flightDAO.updateFlight(flightNumber);
	}
	
	@Override
	public FlightData getByRequest(HttpServletRequest request) {
		try {
			String flightNumberString = request.getParameter("flightNumber");
			String company = request.getParameter("company");
			String time = request.getParameter("time");
			
			if (StringUtils.isBlank(flightNumberString) ||
					StringUtils.isBlank(company) ||
					StringUtils.isBlank(time)) {
				throw new IllegalArgumentException();
			}
			
			Long flightNumber = Long.parseLong(flightNumberString);
			
			FlightData flight = new FlightData(flightNumber, company, time);
			State state = getStateByRequest(request);
			
			flight.setState(state);
			
			return flight;
		}
		catch(Throwable t) {
			System.out.println("error getByRequest " + t);
			throw t;
		}
	}
	
	@Override
	public State getStateByRequest(HttpServletRequest request) {
		State state = Arriving.getIntance();
		String stateString = request.getParameter("state");
		
		if (StringUtils.isNotBlank(stateString)) {
			if (stateString.equals(Boarding.class.getName())) {
				state = Boarding.getIntance();
			}
			else if (stateString.equals(TakingOff.class.getName())) {
				state = TakingOff.getIntance();
			}
			else if (stateString.equals(TookOff.class.getName())) {
				state = TookOff.getIntance();
			}
		}
		
		return state;
	}
}
