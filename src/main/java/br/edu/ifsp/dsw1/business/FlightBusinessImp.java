package br.edu.ifsp.dsw1.business;

import java.io.InvalidObjectException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.State;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.observer.ArrivingObserverImp;
import br.edu.ifsp.dsw1.model.observer.BoardingObserverImp;
import br.edu.ifsp.dsw1.model.observer.TakingOffObserverImp;
import jakarta.servlet.http.HttpServletRequest;

public class FlightBusinessImp implements FlightBusiness {
	private static final FlightDataCollection flightDAO = new FlightDataCollection();
	
	private static ArrivingObserverImp arrivingObserver = new ArrivingObserverImp();
	private static BoardingObserverImp boardingObserver = new BoardingObserverImp();
	private static TakingOffObserverImp takingOffObserver = new TakingOffObserverImp();
	
	public FlightBusinessImp() {
		flightDAO.register(arrivingObserver);
		flightDAO.register(boardingObserver);
		flightDAO.register(takingOffObserver);
	}

	@Override
	public List<FlightData> getAllFlights() {
		return flightDAO.getAllFligthts();
	}

	@Override
	public List<FlightData> getArrivingFlights() {
		return Collections.unmodifiableList(arrivingObserver.arrivingFlights);
	}

	@Override
	public List<FlightData> getBoardingFlights() {
		return Collections.unmodifiableList(boardingObserver.boardingFlights);
	}

	@Override
	public List<FlightData> getTakingOffFlights() {
		return Collections.unmodifiableList(takingOffObserver.takingOffFlights);
	}

	@Override
	public void insert(FlightData flight) throws InvalidObjectException {
		if (flight == null) {
			throw new InvalidObjectException("Flight does not exist.");
		}
		flightDAO.insertFlight(flight);
	}

	@Override
	public void updateFlight(Long flightNumber) throws InvalidObjectException {
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

			if (StringUtils.isBlank(flightNumberString)) {
				throw new IllegalArgumentException();
			}

			Long flightNumber = Long.parseLong(flightNumberString);

			FlightData flight = new FlightData(flightNumber, company, time);
			State state = getStateByRequest(request);

			flight.setState(state);

			return flight;
		} catch (Throwable t) {
			System.out.println("error getByRequest " + t);
			throw t;
		}
	}

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
}
