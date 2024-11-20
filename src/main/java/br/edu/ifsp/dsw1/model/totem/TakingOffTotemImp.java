package br.edu.ifsp.dsw1.model.totem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;

public class TakingOffTotemImp implements FlightTotem {
	private final List<FlightData> takingOffFlights = new ArrayList<FlightData>();
	
	@Override
	public void update(FlightData flight) {
		if (! (flight.getState() instanceof TakingOff)) {
			takingOffFlights.remove(flight);
		}
		else if (! takingOffFlights.contains(flight)) {
			takingOffFlights.add(flight);
		}
	}
	
	@Override
	public List<FlightData> getFlights() {
		return Collections.unmodifiableList(takingOffFlights);
	}
}
