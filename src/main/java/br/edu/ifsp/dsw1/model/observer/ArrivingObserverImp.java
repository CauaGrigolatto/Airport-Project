package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

public class ArrivingObserverImp implements FlightDataObserver {
	public List<FlightData> arrivingFlights = new ArrayList<FlightData>();
	
	@Override
	public void update(FlightData flight) {
		if (! (flight.getState() instanceof Arriving)) {
			arrivingFlights.remove(flight);
		}
		else if (! arrivingFlights.contains(flight)) {
			arrivingFlights.add(flight);
		}
	}
	
}
