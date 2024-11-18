package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;

public class BoardingObserverImp implements FlightDataObserver {
	public final List<FlightData> boardingFlights = new ArrayList<FlightData>();
	
	@Override
	public void update(FlightData flight) {
		if (! (flight.getState() instanceof Boarding)) {
			boardingFlights.remove(flight);
		}
		else if (! boardingFlights.contains(flight)) {
			boardingFlights.add(flight);
		}
	}
}
