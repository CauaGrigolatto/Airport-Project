package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;

public class TakingOffObserverImp implements FlightDataObserver {
	public final List<FlightData> takingOffFlights = new ArrayList<FlightData>();
	
	@Override
	public void update(FlightData flight) {
		if (! (flight.getState() instanceof TakingOff)) {
			takingOffFlights.remove(flight);
		}
		else if (! takingOffFlights.contains(flight)) {
			takingOffFlights.add(flight);
		}
	}
}
